import UILib.*;

UILib lib;
Textfield tf;

void setup() {
 lib = new UILib(this);
 tf = lib.addTextfield(100,100,500,60,"");
 tf.setBackgroundColor(color(255,0,93));
 tf.setTextColor(color(0,68,263));
}

void draw() {
  println(tf.getText());
}
