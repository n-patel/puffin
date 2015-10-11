package com.puffin.runner;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Vector2;
import com.puffin.util.UserData;
import com.puffin.util.UserDataType;
import com.puffin.util.Constants;

public class RunnerUserData extends UserData {
    private Vector2 jumpingLinearImpulse;
    private Sprite[] runImg = {
            new Sprite(new Texture("puffin-running-1.png")),
            new Sprite(new Texture("puffin-running-2.png")),
            new Sprite(new Texture("puffin-running-3.png")),
            new Sprite(new Texture("puffin-running-4.png"))
    };
    private Sprite[] flyImg = {
            new Sprite(new Texture("puffin-flying-1.png")),
            new Sprite(new Texture("puffin-flying-2.png")),
            new Sprite(new Texture("puffin-flying-3.png")),
            new Sprite(new Texture("puffin-flying-2.png"))
    };
    private int i = 0;

    public RunnerUserData() {
        super();
        jumpingLinearImpulse = Constants.RUNNER_JUMPING_LINEAR_IMPULSE;
        userDataType = UserDataType.RUNNER;
    }

    public Vector2 getJumpingLinearImpulse() {
        return jumpingLinearImpulse;
    }

    public void setJumpingLinearImpulse(Vector2 jumpingLinearImpulse) {
        this.jumpingLinearImpulse = jumpingLinearImpulse;
    }

    public Sprite getSprite(boolean isJumping){
        i++;
        if (isJumping) {
            return flyImg[(i / 10) % flyImg.length];
        }
        return runImg[(i / 10) % runImg.length];
    }
}