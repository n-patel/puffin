package com.puffin.util;

/**
 * Created by Lear on 10/10/2015.
 */
import com.badlogic.gdx.math.Vector2;

public class Constants {

    public static final Vector2 WORLD_GRAVITY = new Vector2(0, -10);

    public static final float GROUND_X       = 0;
    public static final float GROUND_Y       = 0; //changed from 0 to 10
    public static final float GROUND_WIDTH   = 50.0f;
    public static final float GROUND_HEIGHT  = 2.0f;
    public static final float GROUND_DENSITY = 0.0f;
    public static final Vector2 GROUND_SPEED = new Vector2(-7f, 0f);

    public static final float RUNNER_X             = 2.5f;
    public static final float RUNNER_Y             = GROUND_Y + GROUND_HEIGHT;
    public static final float RUNNER_WIDTH         = 1.2f;
    public static final float RUNNER_HEIGHT        = 2.1f;
    public static final float RUNNER_DENSITY       = 0.7f;
    public static final float RUNNER_GRAVITY_SCALE = 3.0f;
    public static final Vector2 RUNNER_JUMPING_LINEAR_IMPULSE = new Vector2(0, 40 * RUNNER_DENSITY);

    public static final float PROJECTILE_SPEED  = 5.0f;      //sets the projectile speed constant
    public static final float PROJECTILE_WIDTH  = 0.6f;
    public static final float PROJECTILE_HEIGHT = 0.6f;
    public static final float FIRE_DELAY        = 0.5f;

    public static final int VIEWPORT_WIDTH  = 20;
    public static final int VIEWPORT_HEIGHT = 13;
}
