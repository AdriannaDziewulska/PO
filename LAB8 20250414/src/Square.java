import java.awt.*;

public class Square extends Shape{
    private int width;

    public Square(int x, int y, String color, int width){
        super(x,y,color);
        this.width=width;
    }

    @Override
    void draw(Graphics2D g2d) {
        g2d.setColor(Color.decode(color));
        g2d.fillRect(x,y,width,width);
    }

    @Override
    public String getType() {
        return "Square";
    }
}
