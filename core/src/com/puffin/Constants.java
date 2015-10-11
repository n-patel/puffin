package com.puffin;

/**
 * Created by Lear on 10/10/2015.
 */
import com.badlogic.gdx.math.Vector2;

public class Constants {

    public static final Vector2 WORLD_GRAVITY = new Vector2(0, -10);

    public static final float GROUND_X       = 0;
    public static final float GROUND_Y       = 0; //changed from 0 to 10
    public static final float GROUND_WIDTH   = 50f;
    public static final float GROUND_HEIGHT  = 2f;
    public static final float GROUND_DENSITY = 0f;
    public static final Vector2 GROUND_SPEED = new Vector2(-7f, 0f);

    public static final float RUNNER_X      = 2;
    public static final float RUNNER_Y      = GROUND_Y + GROUND_HEIGHT;
    public static final float RUNNER_WIDTH  = 1.2f;
    public static final float RUNNER_HEIGHT = 2.1f;
    public static float RUNNER_DENSITY      = 0.7f;

    public static final float RUNNER_GRAVITY_SCALE = 3f;
    public static final Vector2 RUNNER_JUMPING_LINEAR_IMPULSE = new Vector2(0, 40 * RUNNER_DENSITY);
    
    public static final float PROJECTILE_SPEED = 2f;      //sets the projectile speed constant
    public static final float PROJECTILE_WIDTH = .6f;
    public static final float PROJECTILE_HEIGHT = .6f;

    public static final int VIEWPORT_WIDTH = 20;
    public static final int VIEWPORT_HEIGHT = 13;
}
