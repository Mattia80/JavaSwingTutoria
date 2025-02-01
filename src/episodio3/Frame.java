package episodio3;

import javax.swing.*;
import java.awt.*;

public class Frame extends JFrame {

    private JTextArea textArea;
    private JButton button;

    public Frame() {
        super("La mia prima finestra");

        setLayout(new BorderLayout());

        textArea = new JTextArea();
        button = new JButton("Cliccami");

        add(textArea, BorderLayout.CENTER);
        add(button, BorderLayout.PAGE_START);

        setSize(1000, 600);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

}
