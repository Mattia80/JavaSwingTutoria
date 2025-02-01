package episodio4;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Frame extends JFrame {

    private JTextArea textArea;
    private JTextField textField;
    private JButton button;

    public Frame() {
        super("La mia prima finestra");

        setLayout(new BorderLayout());

        textArea = new JTextArea();
        textField = new JTextField();
        button = new JButton("Cliccami");

        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String testoTextField = textField.getText();
                if (!testoTextField.equals("")) {
                    textArea.append(testoTextField + "\n");
                    textField.setText("");
                }
            }
        });

        add(textArea, BorderLayout.CENTER);
        add(textField, BorderLayout.PAGE_START);
        add(button, BorderLayout.PAGE_END);

        setSize(1000, 600);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

}
