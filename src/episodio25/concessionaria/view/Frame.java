package episodio25.concessionaria.view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

public class Frame extends JFrame {

    private TextAreaPanel textAreaPanel;
    private JButton button;
    private BarraStrumenti barraStrumenti;
    private PannelloForm pannelloForm;
    private JFileChooser fileChooser;

    public Frame() {
        super("La mia prima finestra");
        setLayout(new BorderLayout());

        setJMenuBar(creaBarraMenu());

        barraStrumenti = new BarraStrumenti();
        textAreaPanel = new TextAreaPanel();
        pannelloForm = new PannelloForm();

        fileChooser = new JFileChooser();
        fileChooser.addChoosableFileFilter(new FileFilterAutomobile());
        fileChooser.setAcceptAllFileFilterUsed(false);

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
                int numeroPosti = formEvent.getNumeroPosti();
                int cilindrata = formEvent.getCilindrata();
                int colore = formEvent.getColore();

                textAreaPanel.appendiTesto("Marca: " + marca + "\nModello: " + modello + "\nVenduta: " + vendita + "\nTarga: " + targa + "\nCambio: " + cambio + "\n" +
                        "Bagagliaio: " + bagagliaio + "\nAlimentazione: " + alimentazione + "\nNumero posti: " + numeroPosti + "\nCilindrata: " + cilindrata + "\nColore: " + colore + "\n");
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

    private JMenuBar creaBarraMenu() {
        JMenuBar barraMenu = new JMenuBar();

        JMenu menuFile = new JMenu("File");
        menuFile.setMnemonic(KeyEvent.VK_F);
        JMenuItem menuItemImporta = new JMenuItem("Importa");
        JMenuItem menuItemEsporta = new JMenuItem("Esporta");
        JMenuItem menuItemEsci = new JMenuItem("Esci (X)");
        menuItemEsci.setMnemonic(KeyEvent.VK_X);
        menuItemEsci.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_X, ActionEvent.CTRL_MASK));

        menuFile.add(menuItemImporta);
        menuFile.add(menuItemEsporta);
        menuFile.addSeparator();
        menuFile.add(menuItemEsci);

        JMenu menuFinestra = new JMenu("Finestra");
        JMenu menuMostra = new JMenu("Mostra");

        JCheckBoxMenuItem menuItemMostraForm = new JCheckBoxMenuItem("Mostra Form");
        menuItemMostraForm.setSelected(true);
        menuItemMostraForm.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JCheckBoxMenuItem menuItem = (JCheckBoxMenuItem) e.getSource();
                pannelloForm.setVisible(menuItem.isSelected());
            }
        });

        menuItemImporta.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (fileChooser.showOpenDialog(Frame.this) == JFileChooser.APPROVE_OPTION) {
                    System.out.println(fileChooser.getSelectedFile());
                }
            }
        });

        menuItemEsporta.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (fileChooser.showSaveDialog(Frame.this) == JFileChooser.APPROVE_OPTION) {
                    System.out.println(fileChooser.getSelectedFile());
                }
            }
        });

        menuItemEsci.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int azioneFinestra = JOptionPane.showConfirmDialog(Frame.this, "Vuoi uscire dall'applicazione?", "Chiusura applicazione", JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE);
                if (azioneFinestra == JOptionPane.OK_OPTION) {
                    System.exit(0);
                }
            }
        });

        menuMostra.add(menuItemMostraForm);
        menuFinestra.add(menuMostra);

        barraMenu.add(menuFile);
        barraMenu.add(menuFinestra);

        return barraMenu;
    }

}
