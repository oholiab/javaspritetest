package com.prontab.goddamn;

import org.newdawn.slick.*;
import org.newdawn.slick.geom.Rectangle;

public class GodDamn extends BasicGame {
  
  public GodDamn() {
    super("God Damn");
  }

  public static void main(String[] arguments) {
    try {
      AppGameContainer app = new AppGameContainer(new GodDamn());
      app.setDisplayMode(640, 480, false);
      app.start();
    }
    catch (SlickException e) {
      e.printStackTrace();
    }
}
  
  Matt matt;
  Text text;
  
  public void init(GameContainer c) throws SlickException {
    matt = new Matt(50, 50);
    text = new Text("", 220, 80, 70);
  }
  
  public void render(GameContainer c, Graphics g) throws SlickException {
    g.setColor(Color.white);
    g.fill(new Rectangle(0, 0, 640, 480));
    matt.draw();
    text.draw(g);
  }

  public void update(GameContainer c, int delta) throws SlickException{
    handleinput(c);
    text.update(delta);
  }
  private void handleinput(GameContainer c) throws SlickException{
    Input input = c.getInput();
    if (input.isKeyDown(Input.KEY_ESCAPE)) {
      c.exit();
    }
    if (input.isKeyDown(Input.KEY_S)) {
      matt.stand();
      text.reset();
    }
    if (input.isKeyDown(Input.KEY_Q)) {
      matt.shrug();
      text.settext("I dunno");
    }
    if (input.isKeyDown(Input.KEY_T)) {
      matt.talk();
      text.settext("Can we go get a drink now?");
    }
  }
}