package com.puffin;

import com.badlogic.gdx.math.Vector2;

public class ProjectileUserData extends UserData{


    public static Vector2 calculateDir(Projectile projectile){
        Vector2 deltaVector = projectile.body.getPosition().sub(projectile.runner.body.getPosition());
        deltaVector = deltaVector.nor();
        return deltaVector;

    }
}
