import java.awt.*;

public class Triangle extends Shape{
    private int base;

    public Triangle(int x, int y, String color, int base){
        super(x,y,color);
        this.base=base;
    }

    @Override
    void draw(Graphics2D g2d) {
        g2d.setColor(Color.decode(color));
        int halfBase = base / 2;
        int height = (int) (Math.sqrt(3) / 2 * base);

        int[] xPoints = { x, x - halfBase, x + halfBase };
        int[] yPoints = { y, y + height, y + height };

        g2d.fillPolygon(xPoints, yPoints, 3);
    }

    @Override
    public String getType() {
        return "Triangle";
    }
}
