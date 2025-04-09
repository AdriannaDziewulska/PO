import javax.swing.*;
import java.awt.*;

public static void main(String[] args) {
    JFrame frame = new JFrame("Konwenter Walut");
    frame.setLayout(new FlowLayout());


    JComboBox<String> fromCurrency = new JComboBox<>(new String[]{"PLN", "EUR", "USD"});
    JComboBox<String> toCurrency = new JComboBox<>(new String[]{"PLN", "EUR", "USD"});
    JButton convertButton = new JButton("Przelicz");
    JLabel resultLabel = new JLabel("Wynik: ");

    frame.add(new JLabel("Kwota:"));
    JTextField amount = new JTextField(10);
    frame.add(amount);

    frame.add(new JLabel("Z waluty:"));
    frame.add(fromCurrency);

    frame.add(new JLabel("Na walutę:"));
    frame.add(toCurrency);

    frame.add(new JLabel());
    frame.add(convertButton);

    frame.add(new JLabel());
    frame.add(resultLabel);

    Map<String, Double> rates = new HashMap<>();
    rates.put("PLN", 1.0);
    rates.put("EUR", 4.5);
    rates.put("USD", 4.2);

    convertButton.addActionListener(e -> {
        try {
            double result = Double.parseDouble(amount.getText());
            String from = (String) fromCurrency.getSelectedItem();
            String to = (String) toCurrency.getSelectedItem();

            double inPLN = result * rates.get(from);
            double converted = inPLN / rates.get(to);

            resultLabel.setText(String.format("Wynik: %.2f %s", converted, to));
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(frame, "Wprowadź poprawną kwotę!", "Błąd", JOptionPane.ERROR_MESSAGE);
        }
    });

    frame.setSize(180, 200);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setVisible(true);
}

