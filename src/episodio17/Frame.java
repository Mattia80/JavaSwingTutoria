package episodio17;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Frame extends JFrame {

    private TextAreaPanel textAreaPanel;
    private JButton button;
    private BarraStrumenti barraStrumenti;
    private PannelloForm pannelloForm;

    public Frame() {
        super("La mia prima finestra");
        setLayout(new BorderLayout());

        barraStrumenti = new BarraStrumenti();
        textAreaPanel = new TextAreaPanel();
        pannelloForm = new PannelloForm();
        barraStrumenti.setTextListener(new TextListener() {
            @Override
            public void testoEmesso(String testo) {
                textAreaPanel.appendiTesto(testo);
            }
        });
        button = new JButton("Cliccami");

        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textAreaPanel.appendiTesto("Porcodio!\n");
            }
        });

        pannelloForm.setFormListener(new FormListener() {
            @Override
            public void formEventListener(FormEvent formEvent) {
                String marca = formEvent.getMarca();
                String modello = formEvent.getModello();
                boolean vendita = formEvent.isVendita();
                String targa = formEvent.getTarga();
                String cambio = formEvent.getCambio();
                String bagagliaio = null;

                switch (formEvent.getBagagliaio()) {
                    case 0:
                        bagagliaio = "Piccolo";
                        break;
                    case 1:
                        bagagliaio = "Medio";
                        break;
                    case 2:
                        bagagliaio = "Grande";
                        break;
                }

                String alimentazione = formEvent.getAlimentazione();

                textAreaPanel.appendiTesto("Marca: " + marca + "\nModello: " + modello + "\nVenduta: " + vendita + "\nTarga: " + targa + "\nCambio: " + cambio + "\n" + "Bagagliaio: " + bagagliaio + "\nAlimentazione: " + alimentazione + "\n");
            }
        });

        add(textAreaPanel, BorderLayout.CENTER);
        add(barraStrumenti, BorderLayout.PAGE_START);
        add(button, BorderLayout.PAGE_END);
        add(pannelloForm, BorderLayout.LINE_START);

        setSize(1000, 600);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

}
