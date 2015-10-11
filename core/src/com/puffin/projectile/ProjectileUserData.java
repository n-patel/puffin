package com.puffin.projectile;

import com.badlogic.gdx.math.Vector2;

public class ProjectileUserData extends com.puffin.util.UserData {

    public static Vector2 calculateDir(Projectile projectile, Vector2 vectorTouch){
        Vector2 deltaVector = vectorTouch.sub(projectile.runner.getBody().getPosition());
        deltaVector = deltaVector.nor();
        return deltaVector;

    }
}
