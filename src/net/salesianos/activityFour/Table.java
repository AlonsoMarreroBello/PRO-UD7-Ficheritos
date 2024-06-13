package net.salesianos.activityFour;

import java.io.Serializable;

public class Table implements Serializable {
  private String color;
  private int legs;

  public Table(String color, int legs) {
    this.color = color;
    this.legs = legs;
  }

  public String getColor() {
    return color;
  }

  public void setColor(String color) {
    this.color = color;
  }

  public int getLegs() {
    return legs;
  }

  public void setLegs(int legs) {
    this.legs = legs;
  }

  @Override
  public String toString() {
    return "Table [color=" + color + ", legs=" + legs + "]";
  }

}
