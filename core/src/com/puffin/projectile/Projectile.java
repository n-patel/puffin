package com.puffin.projectile;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.math.Vector2;
import com.puffin.runner.Runner;
import com.puffin.util.GameActor;

public class Projectile extends GameActor {
    public Vector2 linear_velocity;
    com.puffin.runner.Runner runner;
    Vector2 vectorTouch;

    public Projectile(Body body, float x, float y, Runner runner) {
        super(body);
        this.runner = runner;
        this.vectorTouch = new Vector2(x, y);
        linear_velocity = ProjectileUserData.calculateDir(this, vectorTouch);
    }

    @Override
    public ProjectileUserData getUserData() {
        return (ProjectileUserData) userData;
    }

}
