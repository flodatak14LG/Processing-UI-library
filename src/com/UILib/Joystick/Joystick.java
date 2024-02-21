package UILib;
import processing.core.*;

import java.awt.Color;
import java.lang.Math.*;
import java.util.*;

/**
 * This allows to display and use a joystick
 *
 <!-- * @example JoystickExample  -->
 *
 */

public class Joystick {
    public float centerX,centerY;
    float centerRadius,radiusMax,joystickRadius;;
    public float Xj,Yj;
    PApplet parent;
    public boolean isVisible = true;
    Joystick(float x,float y,float radius,PApplet parent) {
        centerX = x;
        centerY = y;
        Xj = centerX;
        Yj = centerY;
        radiusMax = radius;
        centerRadius = radius/3;
        joystickRadius = 2*radius/5;
        this.parent = parent;
    }

    public void draw() {
        //the appearance
        parent.fill(0);
        parent.ellipse(centerX,centerY,centerRadius*2,centerRadius*2);
        parent.fill(parent.color(255,200));
        parent.ellipse(Xj,Yj,joystickRadius*2,joystickRadius*2);
        parent.fill(parent.color(255,100));
        parent.ellipse(centerX,centerY,radiusMax*2,radiusMax*2);

    }

    public void update() {
        if(parent.mousePressed) {
            float dist = (float)Math.sqrt(Math.pow((parent.mouseX-centerX),2)+Math.pow((parent.mouseY-centerY),2));
            if(dist > radiusMax) {//too far away from center
                Xj = centerX + (parent.mouseX-centerX)*radiusMax/dist;
                Yj = centerY + (parent.mouseY-centerY)*radiusMax/dist;
            } else {
                Xj = parent.mouseX;
                Yj = parent.mouseY;
            }
        } else {
            Xj=centerX;
            Yj=centerY;
        }
    }

    /**
     * get the absolute offset of the joystick to the center on the X axis
      * @return float
     */
    public float getAbsoluteOffsetX() {
        return (Xj-centerX);
    }
    /**
     * get the absolute offset of the joystick to the center on the Y axis
     * @return float
     */
    public float getAbsoluteOffsetY() {
        return (Yj-centerY);
    }
    /**
     * get the offset of the joystick to the center on the X axis relative to the radius
     * @return float between -1.0 and 1.0
     */
    public float getRelativeOffsetX() {
        return (Xj-centerX)/radiusMax;
    }
    /**
     * get the offset of the joystick to the center on the Y axis relative to the radius
     * @return float between -1.0 and 1.0
     */
    public float getRelativeOffsetY() {
        return (Yj-centerY)/radiusMax;
    }

    /**
     * sets the joystick as visible
     */
    public void show() {
        isVisible = true;
    }

    /**
     * sets the joystick as hidden
     */
    public void hide() {
        isVisible = false;
    }

    /**
     * Changes the position of the joystick
     * @param x the new X coordinate
     * @param y the new Y coordinate
     */
    public void setPosition(float x,float y) {
        centerX = x;
        centerY = y;
    }

    /**
     * Changes the radius of the joystick
     * @param radius the new overall radius
     */
    public void setRadius(float radius) {
        radiusMax = radius;
        centerRadius = radius/3;
        joystickRadius = 2*radius/5;
    }
}