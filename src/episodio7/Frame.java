package episodio7;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Frame extends JFrame {

    private TextAreaPanel textAreaPanel;
    private JButton button;
    private BarraStrumenti barraStrumenti;

    public Frame() {
        super("La mia prima finestra");
        setLayout(new BorderLayout());

        barraStrumenti = new BarraStrumenti();
        textAreaPanel = new TextAreaPanel();
        barraStrumenti.setTextAreaPanel(textAreaPanel);
        button = new JButton("Cliccami");

        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                    textAreaPanel.appendiTesto("Porcodio!\n");
            }
        });

        add(textAreaPanel, BorderLayout.CENTER);
        add(barraStrumenti, BorderLayout.PAGE_START);
        add(button, BorderLayout.PAGE_END);

        setSize(1000, 600);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

}
