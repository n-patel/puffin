package com.puffin.projectile;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.math.Vector2;
import com.puffin.runner.Runner;
import com.puffin.util.GameActor;

public class Projectile extends GameActor {
    public Vector2 linear_velocity;
    public Runner runner;
    private Vector2 vectorTouch;
    private float degrees;

    public Projectile(Body body, float x, float y, Runner runner) {
        super(body);
        this.runner = runner;
        this.vectorTouch = new Vector2(x, y);
        linear_velocity = ProjectileUserData.calculateDir(this, vectorTouch);
        //degrees = (float) ((Math.atan2(x - runner.getPosition().x, -(y - runner.getPosition().y)) * 180.0d / Math.PI) + 90.0f);
    }

    public Vector2 getVectorTouch() { return vectorTouch; }

    //public float getDegrees() { return degrees; }

    @Override
    public ProjectileUserData getUserData() {
        return (ProjectileUserData) userData;
    }

}