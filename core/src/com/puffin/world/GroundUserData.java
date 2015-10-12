package com.puffin.world;

/**
 * Created by Lear on 10/10/2015.
 */
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.puffin.util.UserData;
import com.puffin.util.UserDataType;
public class GroundUserData extends UserData {

    private Sprite img;

    public GroundUserData() {
        super();
        userDataType = UserDataType.GROUND;

        img = new Sprite(new Texture("ice-floe-body.png"));
    }

    public Sprite getSprite() {
        return img;
    }

}
