import UILib.*;

UILib lib;
Joystick joy;

int x=100;
int y=100;

int speed = 10;

void setup() {
  size(500,500);
  lib = new UILib(this);
  joy = lib.addJoystick(100,height-100,100);
}

void draw() {
  background(200);
  x+=(joy.getRelativeOffsetX()*speed);
  if(x<0) x=0;
  else if (x+100>width) x= width-100;
  y+=(joy.getRelativeOffsetY()*speed);
  if(y<0) y=0;
  else if (y+100>height) y=height-100;
  rect(x,y,100,100);
}
