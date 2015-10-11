package com.puffin;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.math.Vector2;

public class Projectile extends GameActor {

    public Vector2 linear_velocity;
    Runner runner;
    Vector2 vectorTouch;
    public Projectile(Body body, float x, float y, Runner runner) {

        super(body);
        this.runner = runner;
        this.vectorTouch = new Vector2(x, y);
        linear_velocity = ProjectileUserData.calculateDir(this, vectorTouch);
    }

    @Override


    public RunnerUserData getUserData() {
        return (RunnerUserData) userData;
    }

}
