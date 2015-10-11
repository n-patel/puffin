package com.puffin;

/**
 * Created by Lear on 10/10/2015.
 */
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.PolygonShape;
import com.badlogic.gdx.physics.box2d.World;
import com.puffin.GroundUserData;
import com.puffin.RunnerUserData;

public class WorldUtils {

    /**
     * Creates a World, which is the entire screen
     * @return World a World with gravity set to value in Constants file
     */
    public static World createWorld() {
        return new World(Constants.WORLD_GRAVITY, true);
    }
/*
    public static Body createGround(World world) {
        BodyDef bodyDef = new BodyDef();
        bodyDef.position.set(new Vector2(Constants.GROUND_X, Constants.GROUND_Y));
        bodyDef.type = BodyDef.BodyType.KinematicBody;
        Body body = world.createBody(bodyDef);

        PolygonShape shape = new PolygonShape();
        shape.setAsBox(Constants.GROUND_WIDTH / 2, Constants.GROUND_HEIGHT / 2);
        body.createFixture(shape, Constants.GROUND_DENSITY).setFriction(0f);
        body.setLinearVelocity(Constants.GROUND_SPEED);
        body.setUserData(new GroundUserData());
        shape.dispose();
        return body;
    }
*/

    /**
     * Creates a Runner body on the world passed in. Body is of type DynamicBody,
     * and has height, width, density, x and y position specified from Constants file
     * @param world The World on which the body is created
     * @return Body Runner body
     */
    public static Body createRunner(World world) {
        BodyDef bodyDef = new BodyDef();
        bodyDef.type = BodyDef.BodyType.DynamicBody;
        bodyDef.position.set(new Vector2(Constants.RUNNER_X, Constants.RUNNER_Y));

        PolygonShape shape = new PolygonShape();
        shape.setAsBox(Constants.RUNNER_WIDTH / 2, Constants.RUNNER_HEIGHT / 2);
        Body body = world.createBody(bodyDef);
        body.setGravityScale(Constants.RUNNER_GRAVITY_SCALE);
        body.createFixture(shape, Constants.RUNNER_DENSITY);
        body.resetMassData();
        body.setUserData(new RunnerUserData());
        shape.dispose();
        return body;
    }

}
