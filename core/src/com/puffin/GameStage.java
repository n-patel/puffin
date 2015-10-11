package com.puffin;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.physics.box2d.*;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.puffin.WorldUtils;
import com.puffin.BodyUtils;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Controls all functionality related to the stage of the game
 */

public class GameStage extends Stage implements ContactListener{

    private World world;
    private Queue<Ground> grounds;
    private Maps map;
    private Runner runner; //the puffin
    private final float TIME_STEP = 1 / 300f;
    private float accumulator = 0f;

    private float accumulate = 0f;
    private float accumulate2 = 0f; // Used to calibrate delay for firing

    private OrthographicCamera camera;
    private Box2DDebugRenderer renderer;

    private Rectangle screenLeftSide;
    private Rectangle screenRightSide;

    private Vector3 touchPoint;

    public GameStage() {
        setUpWorld();
        setupCamera();
        setupTouchControlAreas();
        renderer = new Box2DDebugRenderer();

    }

    /**
     * Creates the world with:
     * world field is given the set gravity
     * ground is set up with setUpGround()
     * runner is set up with setUpRunner()
     */
    private void setUpWorld() {
        world = WorldUtils.createWorld();
        world.setContactListener(this);
        setUpGround();
        setUpRunner();
    }

    /**
     * Sets ground field to new body with fields specified in WorldUtils file.
     * Adds ground field to actor list
     */
    private void setUpGround() {
        grounds = new LinkedList<Ground>();
        map = new Maps();
        for(int i = 0; i < 3; i ++) {
            Ground ground = new Ground(map.next().createPlatform(world));
            addActor(ground);
            grounds.add(ground);
        }
    }
    /**
     * Adds new ground
     */
    private void updateGround(){
        if(isActorOffScreen(grounds.peek())) {
            grounds.remove().remove();
            Ground ground = new Ground(map.next().createPlatform(world));
            addActor(ground);
            grounds.add(ground);
        }

        /*
        if (grounds[1].body.getPosition().x < -Constants.GROUND_WIDTH) {
            for (int i = 0; i < grounds.length - 1; i++) {
                grounds[i] = grounds[i + 1];
                Maps.platforms[i] = Maps.platforms[i + 1];

            }
            Maps.platforms[Maps.platforms.length - 1] = new Platform(1, Maps.platforms[Maps.platforms.length - 2].xPos + 1.5f);
            Ground ground = new Ground(Maps.platforms[Maps.platforms.length - 1].createPlatform(world));
            addActor(ground);

            grounds[grounds.length - 1] = ground;
        }

        for(Actor actor : this.getActors())
        {
            Vector3 windowCoordinates = new Vector3(actor.getX(), actor.getY(), 0);
            camera.project(windowCoordinates);
            if(windowCoordinates.x + actor.getWidth() < 0)
                actor.remove();
        }
        */
    }

    private boolean isActorOffScreen(GameActor actor) {
        return actor.getPosition().x + actor.getWidth() / 2 < 0;
//        Vector3 windowCoordinates = new Vector3(actor.getX(), actor.getY(), 0);
//        camera.project(windowCoordinates);
//        return windowCoordinates.x + actor.getWidth() < 0;
    }

    /**
     * Sets runner field to new body with fields specified in WorldUtils file.
     * Adds runner field to actor list
     */
    private void setUpRunner() {
        runner = new Runner(WorldUtils.createRunner(world));
        addActor(runner);
    }

    private void setUpProjectile(float x, float y) {

        if(accumulate-accumulate2>=Constants.FIRE_DELAY) {
            Projectile projectile = new Projectile(WorldUtils.createProjectile(world, runner), x, y, runner);
            addActor(projectile);
            projectile.body.setLinearVelocity(projectile.linear_velocity.scl(Constants.PROJECTILE_SPEED));
            accumulate2 = accumulate;
        }

    }

    /**
     * Sets up new Orthographic camera and updates
     */
    private void setupCamera() {
        camera = new OrthographicCamera(Constants.VIEWPORT_WIDTH, Constants.VIEWPORT_HEIGHT);
        camera.position.set(camera.viewportWidth / 2, camera.viewportHeight / 2, 0f);
        camera.update();
    }

    private void setupTouchControlAreas() {
        touchPoint = new Vector3();
        screenLeftSide = new Rectangle(0, 0, getCamera().viewportWidth / 2, getCamera().viewportHeight);
        screenRightSide = new Rectangle(getCamera().viewportWidth/2, 0, getCamera().viewportWidth/2, getCamera().viewportHeight);
        Gdx.input.setInputProcessor(this);
    }


    @Override
    public void act(float delta) {
        super.act(delta);

        // Fixed timestep
        accumulator += delta;
        accumulate += delta;
        while (accumulator >= delta) {
            world.step(TIME_STEP, 6, 2);
            accumulator -= TIME_STEP;
        }
        updateGround();
        //TODO: Implement interpolation

    }

    @Override
    public void draw() {
        super.draw();
        renderer.render(world, camera.combined);
    }

    /**
     * If screen is touched on the left side then calls jump in runner field
     * @param x x integer coordinate of user's touch
     * @param y y integer coordinate of user's touch
     * @param pointer Not sure what this does
     * @param button Not sure what this does
     * @return boolean calls super function
     */
    @Override
    public boolean touchDown(int x, int y, int pointer, int button) {

        // Need to get the actual coordinates
        translateScreenToWorldCoordinates(x, y);

        if (leftSideTouched(touchPoint.x, touchPoint.y)) {
            runner.jump();
        }


        if (rightSideTouched(touchPoint.x, touchPoint.y))
        {
            setUpProjectile(touchPoint.x, touchPoint.y);
        }
        return super.touchDown(x, y, pointer, button);
    }

    private boolean leftSideTouched(float x, float y) {
        return screenLeftSide.contains(x, y);
    }
    private boolean rightSideTouched(float x, float y) {return screenRightSide.contains(x, y); }
    private void translateScreenToWorldCoordinates(int x, int y) {
        getCamera().unproject(touchPoint.set(x, y, 0));
    }

    @Override
    public void beginContact(Contact contact) {

        Body a = contact.getFixtureA().getBody();
        Body b = contact.getFixtureB().getBody();

        if ((BodyUtils.bodyIsRunner(a) && BodyUtils.bodyIsGround(b)) ||
                (BodyUtils.bodyIsGround(a) && BodyUtils.bodyIsRunner(b))) {
            runner.landed();
        }
    }

    @Override
    public void endContact(Contact contact) {

    }

    @Override
    public void preSolve(Contact contact, Manifold oldManifold) {

    }

    @Override
    public void postSolve(Contact contact, ContactImpulse impulse) {

    }
}
