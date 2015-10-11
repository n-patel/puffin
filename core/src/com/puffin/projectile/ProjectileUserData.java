package com.puffin.projectile;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Vector2;
import com.puffin.util.UserData;

public class ProjectileUserData extends UserData {
    private Sprite[] img = {
            new Sprite(new Texture("ice-projectile-1.png")),
            new Sprite(new Texture("ice-projectile-2.png")),
            new Sprite(new Texture("ice-projectile-3.png"))
    };
    private int i = 0;

    public static Vector2 calculateDir(Projectile projectile, Vector2 vectorTouch){
        Vector2 deltaVector = vectorTouch.sub(projectile.runner.getBody().getPosition());
        deltaVector = deltaVector.nor();
        return deltaVector;
    }

    public Sprite getSprite(){
        i++;
        return img[(i / 10) % img.length];
    }
}
