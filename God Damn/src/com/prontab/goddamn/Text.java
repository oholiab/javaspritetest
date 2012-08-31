package com.prontab.goddamn;

import org.newdawn.slick.Color;
import org.newdawn.slick.Font;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;

public class Text {
  
  String printline, line;
  int posx, posy, shiftx, shifty, updatefreq, length;
  int time, lineindex;
  
  public Text(String text, int x, int y, int freq){
    posx = x;
    posy = y;
    reset();
    updatefreq = freq;
    if (text.length() == 0){
      return;
    }
    else {
      line = text;
      return;
    }
  }
  
  
  public void settext(String text){
    reset();
    line = text;
  }
  
  public void setprinttext(String text){
    reset();
    printline = text;
  }
  
  public void reset(){
    lineindex = 0;
    line = "";
    printline = "";
    length = 0;
    time = 0;
  }
  
  // Get width and height of text in 2 element array
  /*private int[] getDimensions(){
    return new int[2];
  }
  */
  
  // Work out how to offset dialogue so it stays on screen
  private int[] getOffset(int x, int y, int length, int height, int spritewidth){
    int[] offset = new int[2];
    int centrex = Global.winx / 2;
    x = x + (spritewidth/2);
    System.out.println(x);
    if (x > centrex){
      offset[0] = - Global.padding - length;
    } else {
      offset[0] = spritewidth + Global.padding;
    }
    if (y <= 0){
      offset[1] = -y + Global.padding;
    } else {
      int overlap = height + y - Global.winy;
      if (overlap > 0) {
        offset[1] = -overlap - Global.padding;
      }
    }
    offset[1] = - Global.padding;
    return offset;
  }
  
  public boolean update(int x, int y, int delta){
    posx = x;
    posy = y;
    if(printline.length() == line.length()){
      return false;
    }
    time += delta;
    if (time >= updatefreq){
      time = 0;
      printline = printline + line.charAt(lineindex);
      lineindex++;
    }      
    return true;
  }
  // Draws at calculated offset, currently takes an image for the sprite width - this
  // May or may not be a problem at a later date. Be aware.
  public void draw(Graphics g, int x, int y, Image sprite){
    int[] offset;
    Font font;
    g.setColor(Color.black);
    font = g.getFont();
    
    offset = getOffset(x, y, font.getWidth(line), font.getHeight(line), sprite.getWidth());
    
    g.drawString(printline, posx + offset[0], posy + offset[1]);
  }

}
