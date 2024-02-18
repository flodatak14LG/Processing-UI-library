package UILib;


import processing.core.*;
import static processing.core.PGraphics.*;

import java.awt.Color;
import java.lang.Math.*;
import java.util.*;

/**
 * This allows to display a slider
 *
 <!-- * @example ButtonExample  -->
 *
 * (the tag @example followed by the name of an example included in folder 'examples' will
 * automatically include the example in the javadoc.)
 *
*/
public class Slider {
    float x,y;
    float w,h;
    float handleX;
    boolean sliding = false;
    PApplet parent;
    int color = 0;
    Slider(float x,float y,float w,float h, PApplet parent) {
        this.x = x;
        this.y = y;
        this.w = w;
        this.h = h;
        handleX = x+w/2;
        this.parent = parent;
    }

    public void draw() {
        parent.rectMode(CORNER);
        parent.fill(200);
        parent.rect(x,y,w,h);
        parent.fill(color);
        parent.rect(x,y,handleX-x,h);
    }


    public void update() {
        if(parent.mousePressed) {
            if(isPressed()) sliding = true;
        } else sliding = false;

        if(sliding) {
            handleX = parent.mouseX;
            if(handleX < x) {
                handleX = x;
            } else if(handleX-x > w) {
                handleX = x+w;
            }
        }
    }

    private boolean isPressed() {
        if(Math.abs(parent.mouseX-x-w/2)<w/2 && Math.abs(parent.mouseY-y-h/2)<h/2) {
            return true;
        } else return false;
    }


    /**
     * Changes the absolute position of the button.
     *
     * @param x
     *               the new X coordinate
     * @param y
     *               the new Y coordinate
     *
     */

    public void setPosition(int x,int y) {
        this.x = x;
        this.y = y;
    }

    /**
     * Changes the size of the button.
     *
     * @param width
     *               the new width
     * @param height
     *               the new height
     *
     */

    public void setSize(int width,int height) {
        this.w = width;
        this.h = height;

    }

    /**
     * Changes the color of the slider
     *
     * @param theColor
     *               the new color: use processing's color(r,g,b)
     *
     *
     */

    public void setColor(int theColor) {
        color = theColor;
    }

}