package com.puffin;

/**
 * Created by Lear on 10/10/2015.
 */

import com.puffin.UserDataType;
public abstract class UserData {

    protected UserDataType userDataType;

    public UserData() {

    }

    public UserDataType getUserDataType() {
        return userDataType;
    }

}