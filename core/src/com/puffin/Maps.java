package com.puffin;

import java.util.Iterator;

/**
 * Created by Caleb on 10/10/2015.
 */
public class Maps implements Iterator<Platform> {
    //public static Platform[] platforms = {new Platform(1, 0), new Platform(1, 1.5f), new Platform(.5f, 3)};
    private int n;

    public Maps(){
        n = 0;
    }

    public boolean hasNext(){
        return true;
    }

    public Platform next(){
        return new Platform(1, 1.15f * n++);
    }

}
