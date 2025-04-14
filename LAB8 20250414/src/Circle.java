import java.awt.*;

public class Circle extends Shape{
    private int diameter;

    public Circle(int x, int y, String color, int base){
        super(x,y,color);
        this.diameter =base;
    }

    @Override
    void draw(Graphics2D g2d) {
        g2d.setColor(Color.decode(color));
        g2d.fillOval(x, y, diameter, diameter);
    }

    @Override
    public String getType() {
        return "Circle";
    }
}
