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
  private int getOffsetx(int x, int length, int spritewidth){
    int offset; 
    int centrex = Global.winx / 2;
    int halfwidth = spritewidth/2;
    x = x + halfwidth;
    if (x > centrex){
      offset = - Global.padding - length;
    } else {
      offset = spritewidth + Global.padding;
    }
    return offset;
  }
  
  // Placeholder always returns 0
  private int getOffsety(int y, int height){
    int offset = 0;
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
    int offsetx, offsety;
    float drawx, drawy;
    Font font;
    g.setColor(Color.black);
    font = g.getFont();
    
    offsetx = getOffsetx(x, font.getWidth(line), sprite.getWidth() * 3 /* image is upscaled 3 times */);
    // FIXME - fudge factor //
    drawx = (float) posx + (Global.fudge * offsetx);
    if (y <= Global.padding) {
      drawy = Global.padding;
    } else if (y >= Global.winy - Global.padding) {
      drawy = Global.winy - Global.padding - font.getLineHeight();
    } else {
      offsety = getOffsety(y, font.getLineHeight());
      drawy = (float) posy + offsety;
    }
    g.drawString(printline, drawx, drawy); 
  }

}
