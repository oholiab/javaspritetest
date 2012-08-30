package com.prontab.goddamn;

import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;

public class Text {
  
  String printline, line;
  int posx, posy, shiftx, shifty, updatefreq, length;
  int time, lineindex;
  
  public Text(String text, int x, int y, int freq){
    shiftx = x;
    shifty = y;
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
  
  public boolean update(int x, int y, int delta){
    posx = x + shiftx;
    posy = y + shifty;
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
  
  public void draw(Graphics g){
    g.setColor(Color.black);
    g.drawString(printline, posx, posy);
  }

}
