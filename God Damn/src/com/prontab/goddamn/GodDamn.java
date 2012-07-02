package com.prontab.goddamn;

import org.newdawn.slick.*;

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

  @Override
  public void render(GameContainer arg0, Graphics arg1) throws SlickException {
    // TODO Auto-generated method stub
    
  }

  @Override
  public void init(GameContainer arg0) throws SlickException {
    // TODO Auto-generated method stub
    
  }

  @Override
  public void update(GameContainer arg0, int arg1) throws SlickException {
    // TODO Auto-generated method stub
    
  }
}