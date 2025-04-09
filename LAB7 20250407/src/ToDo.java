import javax.swing.*;
import java.awt.*;
import java.util.List;

public static void main(String[] args) {
    JFrame frame = new JFrame("Lista zadań");
    frame.setLayout(new FlowLayout());

    DefaultListModel<String> items = new DefaultListModel<>();
    items.addAll(List.of(
            "Kupić mleko", "Odebrać paczkę", "Sprawdzić pocztę"
    ));
    JList<String> list = new JList<>(items);
//    DefaultListModel<String> model = (DefaultListModel<String>) list.getModel();
    JScrollPane scrollPane = new JScrollPane(list);
    frame.add(scrollPane);

    JButton buttonAdd = new JButton("Dodaj");
    frame.add(buttonAdd);

    buttonAdd.addActionListener(e -> {
        String newTask = JOptionPane.showInputDialog(frame, "Wpisz nowe zadanie: ");

        if (newTask != null && !newTask.trim().isEmpty()) {
            items.addElement(newTask);
        }
    });

    JButton buttonRemove = new JButton("Usuń zaznaczone");
    frame.add(buttonRemove);
    buttonRemove.addActionListener(e -> {
        String selected = list.getSelectedValue();
        if (selected != null) {
            items.removeElement(selected);
        } else {
            JOptionPane.showMessageDialog(frame, "Nie zaznaczono żadnego zadania do usunięcia.", "Błąd", JOptionPane.ERROR_MESSAGE);
        }
    });

    frame.setSize(500, 200);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setVisible(true);
}

