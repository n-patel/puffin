package com.puffin;

import com.badlogic.gdx.math.Vector2;

public class ProjectileUserData extends UserData{


    public static Vector2 calculateDir(Projectile projectile, Vector2 vectorTouch){
        Vector2 deltaVector = vectorTouch.sub(projectile.runner.body.getPosition());
        deltaVector = deltaVector.nor();
        return deltaVector;

    }
}