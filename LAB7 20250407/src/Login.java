import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public static void main(String[] args) {
    JFrame frame = new JFrame();
    frame.setLayout(new FlowLayout());

    JLabel user = new JLabel("Użytkownik: ");
    JTextField textField1 = new JTextField(20);
    frame.add(user);
    frame.add(textField1);
    JLabel password = new JLabel("Hasło: ");
    JTextField textField2 = new JTextField(20);
    frame.add(password);
    frame.add(textField2);

    JButton button = new JButton("Zaloguj");
    frame.add(button);

    button.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            String username = textField1.getText();
            String password = textField2.getText();

            if (!username.isEmpty() && !password.isEmpty()) {
                JOptionPane.showMessageDialog(frame, "Logowanie powiodło się!");
            } else {
                JOptionPane.showMessageDialog(frame, "Uzupełnij dane!", "Błąd", JOptionPane.ERROR_MESSAGE);
            }
        }
    });

    frame.setSize(300, 300);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setVisible(true);
}