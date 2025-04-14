import javax.swing.*;
import java.awt.*;

public class ShapeApp {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Shape Manager");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(700, 500);
            frame.setLayout(new BorderLayout());

            ShapeTableModel model = new ShapeTableModel();
            JTable table = new JTable(model);
            DrawingPanel drawPanel = new DrawingPanel(model);
            model.addTableModelListener(e -> drawPanel.repaint());
            JScrollPane scrollPane = new JScrollPane(table);
            frame.add(scrollPane, BorderLayout.EAST);

            JPanel controlPanel = new JPanel();
            JTextField xField = new JTextField(3);
            JTextField yField = new JTextField(3);
            JTextField sizeField = new JTextField(3);
            JTextField colorField = new JTextField(6);
            JComboBox<String> shapeType = new JComboBox<>(new String[]{"Square","Triangle", "Circle"});
            JButton addButton = new JButton("Dodaj");

            controlPanel.add(new JLabel("Typ:")); controlPanel.add(shapeType);
            controlPanel.add(new JLabel("X:")); controlPanel.add(xField);
            controlPanel.add(new JLabel("Y:")); controlPanel.add(yField);
            controlPanel.add(new JLabel("Rozmiar:")); controlPanel.add(sizeField);
            controlPanel.add(new JLabel("Kolor (#rrggbb):")); controlPanel.add(colorField);
            controlPanel.add(addButton);
            frame.add(controlPanel, BorderLayout.SOUTH);

            frame.add(drawPanel, BorderLayout.CENTER);

            addButton.addActionListener(e -> {
                try {
                    int x = Integer.parseInt(xField.getText());
                    int y = Integer.parseInt(yField.getText());
                    int size = Integer.parseInt(sizeField.getText());
                    String color = colorField.getText();

                    Shape shape = switch (shapeType.getSelectedItem().toString()) {
                        case "Circle" -> new Circle(x, y, color, size);
                        case "Triangle" -> new Triangle(x, y, color, size);
                        case "Square" -> new Square(x, y, color, size);
                        default ->
                                throw new IllegalStateException("Unexpected value: " + shapeType.getSelectedItem().toString());
                    };

                    model.addShape(shape);
                    drawPanel.repaint();

                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(frame, "Błąd danych: " + ex.getMessage());
                }
            });

            frame.setVisible(true);
        });
    }

    static class DrawingPanel extends JPanel {
        private final ShapeTableModel model;

        public DrawingPanel(ShapeTableModel model) {
            this.model = model;
            setPreferredSize(new Dimension(400, 400));
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            Graphics2D g2d = (Graphics2D) g;
            for (Shape shape : model.getShapes()) {
                shape.draw(g2d);
            }
        }
    }
}
