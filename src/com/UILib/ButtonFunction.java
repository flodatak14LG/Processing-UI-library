package UILib;


import processing.core.*;

import java.awt.Color;
import java.lang.Math.*;
import java.util.*;
import java.lang.reflect.Method;

/**
 * This is a template class and can be used to start a new processing library or tool.
 * Make sure you rename this class as well as the name of the example package 'template'
 * to your own library or tool naming convention.
 *
 <!-- * @example ButtonExample  -->
 *
 * (the tag @example followed by the name of an example included in folder 'examples' will
 * automatically include the example in the javadoc.)
 *
 */

public class ButtonFunction extends Button {
    String method;
    PApplet parent;
    ButtonFunction(float x,float y,int w,int h,String onClickFunct,PApplet papplet) {
        super(x,y,w,h,papplet);
        method = onClickFunct;
        parent = papplet;
    }

    void onClick() {
        if(super.isMouseOver()) {
            try {
                parent.getClass().getMethod(method).invoke(parent);
            } catch (SecurityException e) {
                e.printStackTrace();
            } catch (NoSuchMethodException e) {
                e.printStackTrace();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}