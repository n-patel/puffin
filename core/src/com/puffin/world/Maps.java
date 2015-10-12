package com.puffin.world;


import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.World;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.puffin.runner.Runner;
import com.puffin.util.Constants;

/**
 * Created by Caleb on 10/10/2015.
 */
public class Maps {
    //public static Platform[] platforms = {new Platform(1, 0), new Platform(1, 1.5f), new Platform(.5f, 3)};
    private int n;
    public float a;
    public float b;


    public Maps(){
        n = 0;
    }

    public Ground next(World world) {
        if (GameStage.getGrounds().size() ==0) {
            return new Ground(world, Constants.GROUND_WIDTH, Constants.GROUND_HEIGHT, 0);


        }
        else {

            //Ground lastGround = GameStage.getGrounds().get(GameStage.getGrounds().size() - 1);
           // System.out.println(lastGround.xPos + " REAL " + lastGround.getX());


            return new Ground(world, Constants.GROUND_WIDTH, Constants.GROUND_HEIGHT, Constants.VIEWPORT_WIDTH);
        }
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

    public Float generateGap(Ground ground, Runner runner) {
        float x_min_delta =  Constants.MINIMUM_GAP;
        float y_min_delta = Constants.GROUND_HEIGHT - ground.getHeight();
        //float mass = Constants.RUNNER_DENSITY*Constants.RUNNER_HEIGHT*Constants.RUNNER_WIDTH;
        float mass = runner.getBody().getMass();
        //y_min_delta = b*x_delta - x_delta^2*b
        a = 15/(Constants.GROUND_SPEED.x*Constants.GROUND_SPEED.x);
        b = Constants.RUNNER_JUMPING_LINEAR_IMPULSE.y / (Math.abs(Constants.GROUND_SPEED.x)*mass);

        //use quadratic equation to get max x_delta 0 = bx - ax^2 - y
        float x_max_delta = (float) (-b- Math.sqrt(b*b -4f*(-a)*(-y_min_delta)))/(2f*-a);
        System.out.println("x_max_delta: " + x_max_delta + " y_min_delta: " + y_min_delta);
        System.out.println("mass: " + mass + " a: " + a + " b: " + b);

        float x_delta = (float) Math.random()*(x_max_delta-x_min_delta)+x_min_delta;

        return x_delta;

    }


    public Float generateHeight(Ground ground, Float x) {

        float y_delta =  b*x- a*x*x;

        float height  = ground.getHeight()+y_delta;
        return height;


    }
}
