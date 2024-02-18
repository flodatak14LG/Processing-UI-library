package UILib;


import processing.core.*;

import java.awt.Color;
import java.lang.Math.*;
import java.util.*;

/**
 *This is an Image that acts as a Button
 *
 <!-- * @example ButtonExample  -->
 *
 * (the tag @example followed by the name of an example included in folder 'examples' will
 * automatically include the example in the javadoc.)
 *
 */

public class ButtonImage extends Button {
    PImage img;
    ButtonImage(float x,float y,int w,int h, PImage image, PApplet parent) {
        super(x,y,w,h,parent);
        img = image;
    }

    @Override
    public void draw() {
        parent.imageMode(parent.CENTER);
        parent.image(img,this.x,this.y,this.w,this.h);
    }
}