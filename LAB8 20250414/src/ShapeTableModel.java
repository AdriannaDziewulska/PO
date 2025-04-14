import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;
import java.util.List;

public class ShapeTableModel extends AbstractTableModel {
    private final List<Shape> shapes = new ArrayList<>();
    private final String[] columns = {"Typ", "X", "Y", "Kolor"};

    public void addShape(Shape shape) {
        shapes.add(shape);
        fireTableRowsInserted(shapes.size() - 1, shapes.size() - 1);
    }

    public List<Shape> getShapes() {
        return shapes;
    }

    @Override
    public int getRowCount() {
        return shapes.size();
    }

    @Override
    public int getColumnCount() {
        return columns.length;
    }

    @Override
    public String getColumnName(int column) {
        return columns[column];
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Shape shape = shapes.get(rowIndex);
        return switch (columnIndex) {
            case 0 -> shape.getType();
            case 1 -> shape.x;
            case 2 -> shape.y;
            case 3 -> shape.color;
            default -> null;
        };
    }

    @Override
    public boolean isCellEditable(int row, int col) {
        return col == 1 || col == 2 || col == 3;
    }

    @Override
    public void setValueAt(Object value, int row, int col) {
        Shape s = shapes.get(row);
        try {
            if (col == 1 || col == 2) {
                int val = Integer.parseInt(value.toString());
                if (val < 0) return;
                if (col == 1) s.setX(val);
                if (col == 2) s.setY(val);
            } else if (col == 3) {
                String colorStr = value.toString().trim();
                if (!colorStr.startsWith("#")) colorStr = "#" + colorStr;
            }
            fireTableCellUpdated(row, col);
            fireTableDataChanged();
        } catch (Exception e) {
            System.err.println("Błąd edycji: " + e.getMessage());
        }
    }
}
