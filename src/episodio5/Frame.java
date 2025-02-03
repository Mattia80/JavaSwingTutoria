package episodio5;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Frame extends JFrame {

    private TextAreaPanel textAreaPanel;
    private JTextField textField;
    private JButton button;

    public Frame() {
        super("La mia prima finestra");

        setLayout(new BorderLayout());

        textAreaPanel = new TextAreaPanel();
        textField = new JTextField();
        button = new JButton("Cliccami");

        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String testoTextField = textField.getText();
                if (!testoTextField.equals("")) {
                    textAreaPanel.appendiTesto(testoTextField + "\n");
                    textField.setText("");
                }
            }
        });

        add(textAreaPanel, BorderLayout.CENTER);
        add(textField, BorderLayout.PAGE_START);
        add(button, BorderLayout.PAGE_END);

        setSize(1000, 600);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

}
