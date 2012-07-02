package com.prontab.goddamn;

import java.util.HashMap;
import java.util.Map;

import org.newdawn.slick.Animation;
import org.newdawn.slick.Image;
import org.newdawn.slick.SpriteSheet;
import org.newdawn.slick.SlickException;

public class Matt {
  
  public Animation anim;
  public int posx, posy;
  Map<String, int[]> frameref;
  SpriteSheet sheet;
  
  public Matt(int x, int y) {
    posx = x;
    posy = y;
    frameref = loadFrameref();
    try {
      sheet = new SpriteSheet("assets/sprites/matt.png", 77, 123, 5);
      anim = act("stand", true, 0, 0);
    }
    catch(SlickException e) {
      e.printStackTrace();
    }
  }
  
  public void draw() {
    anim.draw(posx, posy);
  }
  
  private Animation act(String action, boolean repeat, int keyframe, int keyframerepeats) {
    Animation animate = new Animation();
    animate.setAutoUpdate(true);
    Image image;
    int length;
    for (int frame : frameref.get(action)){
      
      length = 150;
      if (keyframe != 0 && frame == keyframe && keyframerepeats > 0) {
        length = 450 * keyframerepeats;
      }
      try {
        image = sheet.getSprite(frame, 0);
        image.setFilter(Image.FILTER_NEAREST);
        animate.addFrame(image.getScaledCopy(3), length);
      }
      catch(SlickException e){
        e.printStackTrace();
      }
    }
    return animate;
  }
  
  public void talk() {
    anim = act("talk", true, 0, 0);
  }
  
  public void shrug() {
    anim = act("shrug", true, 3, 3);
    anim.setPingPong(true);
    anim.setLooping(false);
  }
  
  public void stand() {
    anim = act("stand", true, 0, 0);
  }
  
  private HashMap<String, int[]> loadFrameref() {
    HashMap<String, int[]> hash = new HashMap<String, int[]>();
    int[] standlist = {0};
    hash.put("stand", standlist);
    int[] talklist = {0, 1};
    hash.put("talk", talklist);
    int[] shruglist = {0, 2, 3};
    hash.put("shrug", shruglist);
    return hash;
  }
}
