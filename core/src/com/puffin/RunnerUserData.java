package com.puffin;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Vector2;
import com.puffin.UserDataType;
import com.puffin.Constants;

public class RunnerUserData extends UserData {

    private Vector2 jumpingLinearImpulse;
    private Sprite[] img = {new Sprite(new Texture("puffin-running-1.png")),
            new Sprite(new Texture("puffin-running-2.png")),
            new Sprite(new Texture("puffin-running-3.png")),
            new Sprite(new Texture("puffin-running-4.png"))};
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

    public Sprite getSprite(){
        i++;
        return img[(i / 10) % img.length];
    }
}