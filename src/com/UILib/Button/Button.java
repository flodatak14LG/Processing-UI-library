package UILib;


import processing.core.*;

import java.awt.Color;
import java.lang.Math.*;
import java.util.*;

/**
 * This allows to display a clickable button
 *
 <!-- * @example ButtonExample  -->
 *
 * (the tag @example followed by the name of an example included in folder 'examples' will
 * automatically include the example in the javadoc.)
 *
 */
public class Button {
    float x,y;
    int w,h;
    PApplet parent;

    int color = 255;
    int strokeColor = 0;
    Button(float xb,float yb,int wb,int hb, PApplet theParent) {
        x=xb;
        y=yb;
        w=wb;
        h=hb;
        parent = theParent;
    }

    public boolean isPressed() {
        if(Math.abs(parent.mouseX-x)<w/2 && Math.abs(parent.mouseY-y)<h/2 && parent.mousePressed) {
            return true;
        } else return false;
    }

    public boolean isMouseOver() {
        if(Math.abs(parent.mouseX-x)<w/2 && Math.abs(parent.mouseY-y)<h/2) {
            return true;
        } else return false;
    }

    public void draw() {
        parent.rectMode(parent.CENTER);
        parent.fill(color);
        parent.stroke(strokeColor);
        parent.rect(x,y,w,h);
        if(isPressed()) {
            parent.fill(parent.color(150,100));
            parent.rect(x,y,w,h);
        }
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
     * Changes the color of the button.
     *
     * @param theColor
     *               the new color: use processing's color(r,g,b)
     *
     */

    public void setColor(int theColor) {
        color = theColor;
    }

    /**
     * Changes the color of the button's outline.
     *
     * @param theColor
     *               the new color: use processing's color(r,g,b)
     *
     */

    public void setStrokeColor(int theColor) {
        strokeColor = theColor;
    }

    /**
     * Returns the background color (color) and the utline color (strokeColor)
     *
     * @return	array of both color ans stroke color: [color,strokeColor]
     *
     */

    public int[] getColors() {
        int[] colors = {color,strokeColor};
        return colors;
    }
}