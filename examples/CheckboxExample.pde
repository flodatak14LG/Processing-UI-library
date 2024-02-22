import UILib.*;
 UILib lib;
 Checkbox cb;

void setup() {
  size(400,400);
  lib = new UILib(this);
  cb = lib.addCheckbox(100,100,50,50);
}

void draw() {
  println(cb.isChecked);
}