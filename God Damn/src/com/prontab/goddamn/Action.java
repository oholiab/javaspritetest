package com.prontab.goddamn;

import java.util.HashMap;
import java.util.Map;

import org.newdawn.slick.Animation;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.SpriteSheet;

import com.prontab.goddamn.Text;

public class Action {
  public Animation anim;
  Text words;
  
  Map<String, int[]> frameref;
  SpriteSheet sheet;
  
  public Action(Animation animation, Text text) throws SlickException{
    anim = animation;
    words = text;
    
    frameref = loadFrameref();
    
    sheet = new SpriteSheet("assets/sprites/matt.png", 77, 123, 5);

  }
  public void update(int delta){
    if (words.update(delta)){
      anim.update(delta);
    }
  }

  public void act(String action, boolean repeat, int keyframe, int keyframerepeats) {
    Image image;
    int length;
    anim = new Animation();
    anim.setAutoUpdate(false);
    for (int frame : frameref.get(action)){
      
      // length is the length each frame is shown for
      length = 150;
      if (keyframe != 0 && frame == keyframe && keyframerepeats > 0) {
        length = 450 * keyframerepeats;
      }
      // Scales up to 3 times original keeping it pixelated
      try {
        image = sheet.getSprite(frame, 0);
        image.setFilter(Image.FILTER_NEAREST);
        anim.addFrame(image.getScaledCopy(3), length);
      }
      catch(SlickException e){
        e.printStackTrace();
      }
    }
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
