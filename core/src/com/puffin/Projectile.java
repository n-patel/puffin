package com.puffin;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.math.Vector2;

public class Projectile extends GameActor {

    public Vector2 linear_velocity;
    Runner runner;
    public Projectile(Body body, Runner runner) {

        super(body);
        this.runner = runner;
        linear_velocity = ProjectileUserData.calculateDir(this);
    }

    @Override


    public RunnerUserData getUserData() {
        return (RunnerUserData) userData;
    }

}
