package com.puffin;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.PolygonShape;
import com.badlogic.gdx.physics.box2d.World;

/**
 * Created by Caleb on 10/10/2015.
 */
public class Platform {
    private float width;
    private float height;
    private float xPos;

    public Platform(float width, float xPos){
        this.width = width / 2 * Constants.VIEWPORT_WIDTH;
        this.height = Constants.GROUND_HEIGHT;
        this.xPos = xPos * Constants.VIEWPORT_WIDTH;
    }

    /**
     * Creates a Ground body on the World passed in. Body is of type KinematicBody,
     * and has density, height, width, x and y coordinates and speed from Constants file
     * @param world The world on which the body is created
     * @return Body Ground body
     */
    public Body createPlatform(World world) {
        BodyDef bodyDef = new BodyDef();
        bodyDef.position.set(new Vector2(xPos + width, Constants.GROUND_Y));
        bodyDef.type = BodyDef.BodyType.KinematicBody;
        Body body = world.createBody(bodyDef);
        PolygonShape shape = new PolygonShape();
        shape.setAsBox(this.width, this.height);
        body.createFixture(shape, Constants.GROUND_DENSITY).setFriction(0f);
        body.setLinearVelocity(Constants.GROUND_SPEED);
        body.setUserData(new GroundUserData());
        shape.dispose();
        return body;
    }
}
