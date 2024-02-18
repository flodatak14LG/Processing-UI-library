/**
 * ##library.name##
 * ##library.sentence##
 * ##library.url##
 *
 * Copyright ##copyright## ##author##
 *
 * This library is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation; either
 * version 2.1 of the License, or (at your option) any later version.
 * 
 * This library is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * Lesser General Public License for more details.
 * 
 * You should have received a copy of the GNU Lesser General
 * Public License along with this library; if not, write to the
 * Free Software Foundation, Inc., 59 Temple Place, Suite 330,
 * Boston, MA  02111-1307  USA
 * 
 * @author      KDuck
 * @modified    ##date##
 * @version     ##library.prettyVersion## (##library.version##)
 */

package UILib;


import java.util.*;

import processing.core.*;
import static processing.core.PApplet.*;
import static processing.event.MouseEvent.*;
import processing.event.*;

/**
 * This is a template class and can be used to start a new processing library or tool.
 * Make sure you rename this class as well as the name of the example package 'template' 
 * to your own library or tool naming convention.
 * 
 <!-- * @example Hello  -->
 * 
 * (the tag @example followed by the name of an example included in folder 'examples' will
 * automatically include the example in the javadoc.)
 *
 */

public class UILib {
	
	// parent is a reference to the parent sketch
	PApplet parent;

	List<Button> allButtons = new ArrayList<Button>();
	List<ButtonFunction> allFunctionButtons = new ArrayList<ButtonFunction>();
	List<ButtonImage> allImageButtons = new ArrayList<ButtonImage>();

	List<Slider> allSliders = new ArrayList<Slider>();
	List<SliderHandle> allHandleSliders = new ArrayList<SliderHandle>();

	public final static String VERSION = "1.0";
	

	/**
	 * a Constructor, usually called in the setup() method in your sketch to
	 * initialize and start the library.
	 *
	 * @param theParent
	 *               The parent sketch.
	 */
	public UILib(PApplet theParent) {
		parent = theParent;
		welcome();
		parent.registerMethod("draw", this);
		parent.registerMethod("mouseEvent", this);
	}

	public void mouseEvent(MouseEvent event) {
		if( event.getAction() == CLICK) {
			println("click");
			for(ButtonFunction button : allFunctionButtons) {
				button.onClick();
			}
		}
	}
	
	private void welcome() {
		System.out.println("UILib initialized");
	}

	public void draw() {
		//parent.rect(100,100,100,100);
		for(Button button : allButtons) {
			button.draw();
		}
		for(ButtonFunction button : allFunctionButtons) {
			button.draw();
		}
		for(ButtonImage button : allImageButtons) {
			button.draw();
		}
		for(Slider slider : allSliders) {
			slider.update();
			slider.draw();
		}
		for(SliderHandle slider : allHandleSliders) {
			slider.update();
			slider.draw();
		}
	}

	//==========================================================================================================================//

	/**
	 * Adds a button to the sketch.
	 * The button is drawn from the center.
	 *
	 <!-- * @example ButtonExample -->
	 * @param x
	 *               the X coordinate of the button
	 * @param y
	 *               the Y coordinate of the button
	 * @param w
	 *               the width of the button
	 * @param h
	 *               the height of the button
	 *
	 * @return	the Button created
	 *
	 */
	public Button addButton(float x,float y,int w,int h) {
		Button  b = new Button(x,y,w,h,parent);
		allButtons.add(b);
		return b;
	}


	/**
	 * Adds a button that calls a function to the sketch.
	 * The button is drawn from the center.
	 *
	 <!-- * @example ButtonExample -->
	 * @param x
	 *               the X coordinate of the button
	 * @param y
	 *               the Y coordinate of the button
	 * @param w
	 *               the width of the button
	 * @param h
	 *               the height of the button
	 *
	 * @return	the Button created
	 *
	 */
	public ButtonFunction addButtonFunction(float x,float y,int w,int h,String function) {
		ButtonFunction  b = new ButtonFunction(x,y,w,h,function,parent);
		allFunctionButtons.add(b);
		return b;
	}

	/**
	 * Adds an image actins as a button to the sketch.
	 * The button is drawn from the center.
	 *
	 <!-- * @example ButtonExample -->
	 * @param x
	 *               the X coordinate of the button
	 * @param y
	 *               the Y coordinate of the button
	 * @param w
	 *               the width of the button
	 * @param h
	 *               the height of the button
	 * @param image
	 * 				 the image to draw
	 *
	 * @return	the Button created
	 *
	 */
	public ButtonImage addButtonImage(float x,float y,int w,int h, PImage image) {
		ButtonImage  b = new ButtonImage(x,y,w,h,image,parent);
		allImageButtons.add(b);
		return b;
	}

	/**
	 * returns the list of all buttons in the sketch
	 *
	 * @return List<Button>
	 */

	public List<Button> getAllButtons() {
		return allButtons;
	}

	/**
	 * returns the list of all buttons that call a function
	 *
	 * @return List<ButtonFunction>
	 */

	public List<ButtonFunction> getAllFunctionButtons() {
		return allFunctionButtons;
	}

	/**
	 * returns the list of all image buttons in the sketch
	 *
	 * @return List<ButtonImage>
	 */

	public List<ButtonImage> getAllImageButtons() {
		return allImageButtons;
	}


	/**
	 * Adds a slider to the sketch.
	 * The slider is drawn from the top-left corner.
	 *
	 <!-- * @example ButtonExample -->
	 * @param x
	 *               the X coordinate of the slider
	 * @param y
	 *               the Y coordinate of the slider
	 * @param w
	 *               the width of the slider
	 * @param h
	 *               the height of the slider
	 *
	 * @return	the Slider created
	 *
	 */
	public Slider addSlider(float x,float y,int w,int h) {
		Slider  s = new Slider(x,y,w,h,parent);
		allSliders.add(s);
		return s;
	}

	/**
	 * Adds a slider with a handle and tick marks to the sketch.
	 * The slider is drawn from the top-left corner.
	 *
	 <!-- * @example ButtonExample -->
	 * @param x
	 *               the X coordinate of the slider
	 * @param y
	 *               the Y coordinate of the slider
	 * @param w
	 *               the width of the slider
	 * @param h
	 *               the height of the handle
	 *
	 * @return	the SliderHanlde created
	 *
	 */
	public SliderHandle addSliderHandle(float x,float y,int w,int h) {
		SliderHandle  s = new SliderHandle(x,y,w,h,parent);
		allHandleSliders.add(s);
		return s;
	}

	//==================================================================================================================//


	/**
	 * return the version of the library.
	 * 
	 * @return String
	 */
	public static String version() {
		return VERSION;
	}


}

