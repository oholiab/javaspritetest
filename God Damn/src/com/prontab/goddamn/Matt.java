package com.prontab.goddamn;

import java.util.Map;

import org.newdawn.slick.Animation;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.Graphics;

import com.prontab.goddamn.Text;
import com.prontab.goddamn.Action;

public class Matt {
  
  public Animation anim;
  public int posx, posy;
  public int targetx, targety;
  Map<String, int[]> frameref;
  Text speech;
  Action action;
  
  public Matt(int x, int y) {
    posx = x;
    posy = y;
    speech = new Text("", posx, posy, 80);
    try {
      action = new Action(speech);
      action.act("stand", true, 0, 0);
      
    }
    catch(SlickException e) {
      e.printStackTrace();
    }
  }
  
  public void draw(Graphics g) {
    action.anim.draw(posx, posy);
    speech.draw(g, posx, posy, action.sheet.getSubImage(0, 0));
  }
  
  public void update(int delta){
    move(delta);
    action.update(posx, posy, delta);
  }
  
  public void move(int delta) {
	if(targetx != posx | targety != posy) { //unless position and target position are the same
      int diffx, diffy;
      diffx = targetx - posx;
      diffy = targety - posy;
      if(diffx > 0) {
    	posx += Global.vel * delta;
      }
      if(diffy > 0) {
    	posy += Global.vel * delta;
      }
      if(diffx < 0) {
    	posx -= Global.vel * delta;
      }
      if(diffy < 0) {
    	posy -= Global.vel * delta;
      }
	}
  }
  
  public void moveTo(int targx, int targy) {
	targetx = targx;
	targety = targy;
  }
  
  public void talk(String line) {
    action.act("talk", true, 0, 0);
    speech.settext(line);
    
  }
  
  public void shrug(String line) {
    action.act("shrug", true, 3, 3);
    action.anim.setPingPong(true);
    action.anim.setLooping(false);
    speech.settext(line);
  }
  
  public void stand() {
    action.act("stand", true, 0, 0);
    speech.settext("");
  }
}
