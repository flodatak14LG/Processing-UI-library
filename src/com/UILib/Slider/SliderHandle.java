package UILib;


import processing.core.*;
import static processing.core.PGraphics.*;

import java.awt.Color;
import java.lang.Math.*;
import java.util.*;

/**
 * This allows to display a slider with a handle and tick marks
 *
 <!-- * @example SliderExample  -->
 *
 * (the tag @example followed by the name of an example included in folder 'examples' will
 * automatically include the example in the javadoc.)
 *
 */

public class SliderHandle extends Slider {
    int tickNum = 5;
    float handleW;
    SliderHandle(float x, float y, float w, float h, PApplet parent) {
        super(x,y,w,h,parent);
        handleX = x+w/2;
        handleW = w/10;
    }

    @Override
    public void draw() {
        parent.fill(color);
        parent.stroke(color);
        parent.strokeWeight(10);
        parent.line(x,y,x+w,y);
        parent.rectMode(CENTER);
        snapToTicks();
        parent.rect(handleX,y,handleW,h);
        for(int i = 0;i<tickNum;i++) {
            parent.fill(255);
            parent.strokeWeight(1);
            parent.rect(x+ w*i/(tickNum-1),y+h,2,h/4);
        }
    }

    private void snapToTicks() {
        for(int i = 0;i<tickNum;i++) {
            if(Math.abs(handleX-(x+w*i/(tickNum-1)))<=w/(2*tickNum -2)) {
                handleX= x+ w*i/(tickNum-1);
            }
        }
    }

    /**
     * Changes the width of the handle
     *
     * @param width
     *  the new handle width
     */

    public void setHandleWidth(float width) {
        handleW = width;
    }

    /**
     * Changes the number of tick marks (= number of possible positions for the handle)
     *
     * @param number
     *  the number of ticks
     */

    public void setTickNum(int number) {
        tickNum = number;
    }

    /**
     * Returns the number of the tick at which the handle is placed (0 being the first and tickNumber-1 being the last)
     * @return an int between 0 and tickNumber-1
     */
    public int getTickPos() {
        return (int)((handleX-x)*(tickNum-1)/w);
    }
}