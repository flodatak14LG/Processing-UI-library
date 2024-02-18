import UILib.*;
UILib lib;

Slider slide1;
SliderHandle slide2;

void setup() {
  size(900,400);
  lib = new UILib(this);
  slide2 = lib.addSliderHandle(50,300,400,50);
  slide2.setColor(color(255));
  slide2.setTickNum(5);
  slide1 = lib.addSlider(50,100,400,50);
  slide1.setColor(color(255,255,0));

}

void draw() {
  background(100);
  println(slide1.getRelativePos());
}