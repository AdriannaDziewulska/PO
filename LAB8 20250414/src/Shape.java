import java.awt.*;

public abstract class Shape {
    protected int x;
    protected int y;
    protected String color;

    public Shape(int x, int y, String color){
        this.x=x;
        this.y=y;
        this.color=color;
    }

    abstract void draw(Graphics2D g2d);
    public abstract String getType();
    public void setX(int x) {this.x=x;}
    public void setY(int y) {this.y=y;}
}
