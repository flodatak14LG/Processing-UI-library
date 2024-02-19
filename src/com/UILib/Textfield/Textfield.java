package UILib;


import processing.core.*;

import java.awt.Color;
import java.lang.Math.*;
import java.util.*;

/**
 * This allows to display a textfield in android mode
 *
 <!-- * @example ButtonExample  -->
 *
 * (the tag @example followed by the name of an example included in folder 'examples' will
 * automatically include the example in the javadoc.)
 *
 */

public class Textfield {
    public float x,y,w,h;
    public String content = "";
    public boolean focus = false;
    private boolean showCursor = false;
    private PApplet parent;

    public int bgColor=250;
    public int textColor=0;
    public int strokeColor = 0;
    Textfield(float xpos,float ypos,float Width,float Height,String defaultContent,PApplet parent) {
        x=xpos;
        y=ypos;
        w=Width;
        h=Height;
        content = defaultContent;
        this.parent = parent;
    }

    private boolean isPressed() {
        if(Math.abs(parent.mouseX-x-w/2)<w/2 && Math.abs(parent.mouseY-y-h/2)<h/2) {
            return true;
        } else return false;
    }

    public void onClick() {
        if(this.isPressed()) {
            if(!focus) parent.openKeyboard();
            focus = true;
        } else {
            if(focus) parent.closeKeyboard();
            focus = false;
        }
    }

    public void onKeyPressed(int Key,int KeyCode) {
        if(this.focus) {
            if(Key == parent.ENTER || Key == parent.RETURN) {
                //content += '\n';
            } else if(KeyCode == 67) {
                if(content.length() != 0) content = content.substring( 0, content.length()-1 );
            } else if(Key == parent.CODED && KeyCode == parent.SHIFT) {

            } else {
                if(parent.textWidth(content+(char)Key+"|") <= w) {
                    content += (char) Key;
                }
            }
        }
    }

    public void draw() {
        parent.rectMode(parent.CORNER);
        parent.fill(bgColor);
        parent.stroke(strokeColor);
        parent.rect(x,y,w,h);
        if(focus) {
            parent.fill(parent.color(150,100));
            parent.rect(x,y,w,h);
            if(parent.frameCount%20 == 0) {
                showCursor = !showCursor;
            }
        }
        parent.fill(textColor);
        parent.textSize(h-(20*h/100));
        parent.textAlign(parent.LEFT);
        parent.text(showCursor&&focus? this.content+"|":this.content,x,y+h-(20*h/100));
    }

    //============================================================================//

    /**
     * Deletes the content of the Textfield
     */
    public void clearText() {
        this.content = "";
    }

    /**
     * Returns the content of the Textfield as a String
     * @return String
     */
    public String getText() {
        return content;
    }

    /**
     * Changes the absolute position of the textfield.
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
     * Changes the size of the textfield.
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
     * Changes the background color of the Textfield
     * @param theColor the new background color
     */
    public void setBackgroundColor(int theColor){
        bgColor = theColor;
    }

    /**
     * Changes the color of the text inside the textfield.
     * @param theColor the new text color
     */
    public void setTextColor(int theColor) {
        textColor = theColor;
    }

    /**
     * Changes the color of the textfields's outline.
     *
     * @param theColor
     *               the new color: use processing's color(r,g,b)
     *
     */

    public void setStrokeColor(int theColor) {
        strokeColor = theColor;
    }
}