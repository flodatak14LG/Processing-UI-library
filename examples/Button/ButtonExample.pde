import UILib.*;

UILib lib;
Button but;

void setup() {
  size(400,400);
  lib = new UILib(this);
  but = lib.addButton(100,300,100,100);
    but.setColor(color(255,255,5));
    but.setStrokeColor(color(0,0,255));
}

void draw() {
 lib.draw();
 println(but.isPressed());
}