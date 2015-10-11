package com.puffin.world;


import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.World;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.puffin.util.Constants;

/**
 * Created by Caleb on 10/10/2015.
 */
public class Maps {
    //public static Platform[] platforms = {new Platform(1, 0), new Platform(1, 1.5f), new Platform(.5f, 3)};
    private int n;

    public Maps(){
        n = 0;
    }

    public Ground next(World world) {
        return new Ground(world, (1 / 2) * Constants.VIEWPORT_WIDTH, Constants.VIEWPORT_HEIGHT* .15f, n++ * 1.15f*Constants.VIEWPORT_WIDTH);
    }

    /**
     * input: platform: platform of current glacier, runner\
     * output: height and position of next glacier Vector2
     *
     * platform.xpos
     * platform.width
     * platform.height
     * Constant.groundSpeed
     *
     */

    public Ground generateNext(World world, Ground ground) {
        float x_min_delta =  Constants.MINIMUM_GAP;
        float y_min_delta = Constants.GROUND_HEIGHT - ground.getHeight();
        float mass = Constants.RUNNER_DENSITY*Constants.RUNNER_HEIGHT*Constants.RUNNER_WIDTH;
        //y_min_delta = b*x_delta - x_delta^2*b
        float a = 5/(Constants.GROUND_SPEED.x*Constants.GROUND_SPEED.x);
        float b = Constants.RUNNER_JUMPING_LINEAR_IMPULSE.y / (Math.abs(Constants.GROUND_SPEED.x)*mass);

        //use quadratic equation to get max x_delta 0 = bx - ax^2 - y
        float x_max_delta = (float) (-b+ Math.sqrt(b*b -4f*(-a)*(-y_min_delta)))/(2f*-a);

        float x_delta = (float) Math.random()*(x_max_delta-x_min_delta)+x_min_delta;
        float y_delta =  b*x_delta - a*x_delta*x_delta;

        float height  = ground.getHeight()+y_delta;
        float xPos = ground.getPosition().x+ ground.getWidth()* Constants.VIEWPORT_WIDTH+ x_delta;

        return new Ground(world, Constants.GROUND_WIDTH /2 , height, xPos);



    }

}
