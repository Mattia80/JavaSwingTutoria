package episodio23;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

public class PannelloForm extends JPanel {

    private JLabel labelMarca;
    private JLabel labelModello;

    private JTextField fieldMarca;
    private JTextField fieldModello;

    private FormListener formListener;

    private JLabel labelVendita;
    private JCheckBox checkVendita;

    private JLabel labelTarga;
    private JTextField fieldTarga;

    private JLabel labelCambio;
    private JRadioButton radioCambioManuale;
    private JRadioButton radioCambioAutomatico;
    private ButtonGroup gruppoRadioCambio;

    private JLabel labelBagagliaio;
    private JList listBagagliaio;

    private JLabel labelAlimentazione;
    private JComboBox menuAlimentazione;

    private JLabel labelPosti;
    private JSpinner spinnerPosti;

    private JLabel labelCilindrata;
    private JSlider sliderCilindrata;

    private JLabel labelColor;
    private JButton buttonColor;

    private JButton aggiungi;

    PannelloForm() {
        setPreferredSize(new Dimension(350, 100));
        setLayout(new GridBagLayout());

        // Bordi
        Border bordoInterno = BorderFactory.createTitledBorder("Aggiungi Automobile");
        Border bordoEsterno = BorderFactory.createEmptyBorder(0, 5, 5, 5);
        Border bordoFinale = BorderFactory.createCompoundBorder(bordoEsterno, bordoInterno);
        setBorder(bordoFinale);

        // Marca
        labelMarca = new JLabel("Marca: ");
        fieldMarca = new JTextField(20);
        labelMarca.setLabelFor(fieldMarca);
        labelMarca.setDisplayedMnemonic(KeyEvent.VK_M);

        // Modello
        labelModello = new JLabel("Modello: ");
        fieldModello = new JTextField(20);

        // Vendita e Targa
        labelVendita = new JLabel("Vendita: ");
        checkVendita = new JCheckBox();

        labelTarga = new JLabel("Targa: ");
        fieldTarga = new JTextField(15);

        labelTarga.setEnabled(false);
        fieldTarga.setEnabled(false);

        checkVendita.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                boolean selezione = checkVendita.isSelected();

                labelTarga.setEnabled(selezione);
                fieldTarga.setEnabled(selezione);

                if (!selezione) fieldTarga.setText("");
            }
        });

        // Cambio
        labelCambio = new JLabel("Cambio: ");

        radioCambioManuale = new JRadioButton("Manuale");
        radioCambioManuale.setActionCommand("Manuale");
        radioCambioAutomatico = new JRadioButton("Automatico");
        radioCambioAutomatico.setActionCommand("Automatico");

        gruppoRadioCambio = new ButtonGroup();
        gruppoRadioCambio.add(radioCambioManuale);
        gruppoRadioCambio.add(radioCambioAutomatico);

        // Bagagliaio
        labelBagagliaio = new JLabel("Bagagliaio: ");
        listBagagliaio = new JList();
        listBagagliaio.setPreferredSize(new Dimension(170, 55));
        listBagagliaio.setBorder(BorderFactory.createEtchedBorder());

        DefaultListModel modelloBagagliaio = new DefaultListModel();
        modelloBagagliaio.addElement(new Bagagliaio(0, "Piccolo"));
        modelloBagagliaio.addElement(new Bagagliaio(1, "Medio"));
        modelloBagagliaio.addElement(new Bagagliaio(2, "Grande"));
        listBagagliaio.setModel(modelloBagagliaio);

        // Alimentazione
        labelAlimentazione = new JLabel("Alimentazione: ");
        String[] opzioniAlimentazione = {"Benzina", "Diesel", "Elettrica", "Ibrida", "GPL"};
        menuAlimentazione = new JComboBox(opzioniAlimentazione);
        menuAlimentazione.setSelectedIndex(2);
        menuAlimentazione.setEditable(true);

        // Numero di posti
        labelPosti = new JLabel("Posti: ");
        spinnerPosti = new JSpinner();
        SpinnerNumberModel modelloSpinner = new SpinnerNumberModel(1, 1, 9, 1);
        spinnerPosti.setModel(modelloSpinner);

        // Cilindrata
        labelCilindrata = new JLabel("Cilindrata: ");
        sliderCilindrata = new JSlider(1000, 2000, 1200);
        sliderCilindrata.setPreferredSize(new Dimension(200, 55));
        sliderCilindrata.setMajorTickSpacing(250);
        sliderCilindrata.setMinorTickSpacing(50);
        sliderCilindrata.setPaintTicks(true);
        sliderCilindrata.setPaintLabels(true);
        sliderCilindrata.setSnapToTicks(true);

        // Color Chooser
        labelColor = new JLabel("Colore auto: ");
        buttonColor = new JButton("Seleziona il colore");
        buttonColor.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Color colore = JColorChooser.showDialog(new JFrame(), "Seleziona il colore", Color.BLACK);
                buttonColor.setBackground(colore);
            }
        });

        // Bottone Aggiungi
        aggiungi = new JButton("Aggiungi!");
        aggiungi.setMnemonic(KeyEvent.VK_A);

        aggiungi.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String marca = fieldMarca.getText();
                String modello = fieldModello.getText();
                boolean vendita = checkVendita.isSelected();
                String targa = fieldTarga.getText();
                String cambio = gruppoRadioCambio.getSelection().getActionCommand();
                int bagagliaio = ((Bagagliaio) listBagagliaio.getSelectedValue()).getId();
                String alimentazione = menuAlimentazione.getSelectedItem().toString();
                int numeroPosti = (int) spinnerPosti.getValue();
                int cilindrata = sliderCilindrata.getValue();
                int colore = buttonColor.getBackground().getRGB();

                FormEvent formEvent = new FormEvent(this, marca, modello, vendita, targa, cambio, bagagliaio, alimentazione, numeroPosti, cilindrata, colore);

                if (formListener != null) {
                    formListener.formEventListener(formEvent);
                }
            }
        });

        // Layout
        GridBagConstraints gbc = new GridBagConstraints();

        // RIGA 1: Label Marca
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weightx = 0.01;
        gbc.weighty = 0.01;
        gbc.anchor = GridBagConstraints.LINE_END;
        gbc.insets = new Insets(0, 0, 0, 5);
        add(labelMarca, gbc);

        // RIGA 1: Field Marca
        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.weightx = 0.01;
        gbc.weighty = 0.01;
        gbc.anchor = GridBagConstraints.LINE_START;
        gbc.insets = new Insets(0, 0, 0, 0);
        add(fieldMarca, gbc);

        // RIGA 2: Label Modello
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.weightx = 0.01;
        gbc.weighty = 0.01;
        gbc.anchor = GridBagConstraints.LINE_END;
        gbc.insets = new Insets(0, 0, 0, 5);
        add(labelModello, gbc);

        // RIGA 2: Field Modello
        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.weightx = 0.01;
        gbc.weighty = 0.01;
        gbc.anchor = GridBagConstraints.LINE_START;
        gbc.insets = new Insets(0, 0, 0, 0);
        add(fieldModello, gbc);

        // RIGA 3: Cambio
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.weightx = 0.01;
        gbc.weighty = 0.01;
        gbc.anchor = GridBagConstraints.LINE_END;
        gbc.insets = new Insets(0, 0, 0, 5);
        add(labelCambio, gbc);

        // RIGA 3: Cambio Manuale
        gbc.gridx = 1;
        gbc.gridy = 2;
        gbc.weightx = 0.01;
        gbc.weighty = 0.01;
        gbc.anchor = GridBagConstraints.LINE_START;
        gbc.insets = new Insets(0, 0, 0, 0);
        add(radioCambioManuale, gbc);

        // RIGA 4: Cambio Automatico
        gbc.gridx = 1;
        gbc.gridy = 3;
        gbc.weightx = 0.01;
        gbc.weighty = 0.01;
        gbc.anchor = GridBagConstraints.LINE_START;
        gbc.insets = new Insets(0, 0, 0, 0);
        add(radioCambioAutomatico, gbc);

        // RIGA 5: Bagagliaio
        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.weightx = 0.01;
        gbc.weighty = 0.01;
        gbc.anchor = GridBagConstraints.FIRST_LINE_END;
        gbc.insets = new Insets(0, 0, 0, 0);
        add(labelBagagliaio, gbc);

        // RIGA 5: Lista Bagagliaio
        gbc.gridx = 1;
        gbc.gridy = 4;
        gbc.weightx = 0.01;
        gbc.weighty = 0.01;
        gbc.anchor = GridBagConstraints.LINE_START;
        gbc.insets = new Insets(0, 0, 0, 0);
        add(listBagagliaio, gbc);

        // RIGA 6: Label Posti
        gbc.gridx = 0;
        gbc.gridy = 5;
        gbc.weightx = 0.01;
        gbc.weighty = 0.01;
        gbc.anchor = GridBagConstraints.LINE_END;
        gbc.insets = new Insets(0, 0, 0, 5);
        add(labelPosti, gbc);

        // RIGA 6: Spinner Posti
        gbc.gridx = 1;
        gbc.gridy = 5;
        gbc.weightx = 0.01;
        gbc.weighty = 0.01;
        gbc.anchor = GridBagConstraints.LINE_START;
        gbc.insets = new Insets(0, 0, 0, 0);
        add(spinnerPosti, gbc);

        // RIGA 7: Label Alimentazione
        gbc.gridx = 0;
        gbc.gridy = 6;
        gbc.weightx = 0.01;
        gbc.weighty = 0.01;
        gbc.anchor = GridBagConstraints.LINE_END;
        gbc.insets = new Insets(0, 0, 0, 5);
        add(labelAlimentazione, gbc);

        // RIGA 7 Menu Alimentazione
        gbc.gridx = 1;
        gbc.gridy = 6;
        gbc.weightx = 0.01;
        gbc.weighty = 0.01;
        gbc.anchor = GridBagConstraints.LINE_START;
        gbc.insets = new Insets(0, 0, 0, 0);
        add(menuAlimentazione, gbc);

        // RIGA 8: Label Cilindrata
        gbc.gridx = 0;
        gbc.gridy = 7;
        gbc.weightx = 0.01;
        gbc.weighty = 0.01;
        gbc.anchor = GridBagConstraints.LINE_END;
        gbc.insets = new Insets(0, 0, 0, 5);
        add(labelCilindrata, gbc);

        // RIGA 8 Slider Cilindrata
        gbc.gridx = 1;
        gbc.gridy = 7;
        gbc.weightx = 0.01;
        gbc.weighty = 0.01;
        gbc.anchor = GridBagConstraints.LINE_START;
        gbc.insets = new Insets(0, 0, 0, 0);
        add(sliderCilindrata, gbc);

        // RIGA 9: Label Colore
        gbc.gridx = 0;
        gbc.gridy = 8;
        gbc.weightx = 0.01;
        gbc.weighty = 0.01;
        gbc.anchor = GridBagConstraints.LINE_END;
        gbc.insets = new Insets(0, 0, 0, 5);
        add(labelColor, gbc);

        // RIGA 9 Color Chooser
        gbc.gridx = 1;
        gbc.gridy = 8;
        gbc.weightx = 0.01;
        gbc.weighty = 0.01;
        gbc.anchor = GridBagConstraints.LINE_START;
        gbc.insets = new Insets(0, 0, 0, 0);
        add(buttonColor, gbc);

        // RIGA 10: Label Vendita
        gbc.gridx = 0;
        gbc.gridy = 9;
        gbc.weightx = 0.01;
        gbc.weighty = 0.01;
        gbc.anchor = GridBagConstraints.LINE_END;
        gbc.insets = new Insets(0, 0, 0, 5);
        add(labelVendita, gbc);

        // RIGA 10: Checkbox Vendita
        gbc.gridx = 1;
        gbc.gridy = 9;
        gbc.weightx = 0.01;
        gbc.weighty = 0.01;
        gbc.anchor = GridBagConstraints.LINE_START;
        gbc.insets = new Insets(0, 0, 0, 0);
        add(checkVendita, gbc);

        // RIGA 11: Label Targa
        gbc.gridx = 0;
        gbc.gridy = 10;
        gbc.weightx = 0.01;
        gbc.weighty = 0.01;
        gbc.anchor = GridBagConstraints.LINE_END;
        gbc.insets = new Insets(0, 0, 0, 5);
        add(labelTarga, gbc);

        // RIGA 11: Field Targa
        gbc.gridx = 1;
        gbc.gridy = 10;
        gbc.weightx = 0.01;
        gbc.weighty = 0.01;
        gbc.anchor = GridBagConstraints.LINE_START;
        gbc.insets = new Insets(0, 0, 0, 0);
        add(fieldTarga, gbc);

        // RIGA FINALE: Bottone Aggiungi
        gbc.gridx = 0;
        gbc.gridy = 11;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        gbc.gridwidth = 2;
        gbc.gridheight = 1;
        gbc.anchor = GridBagConstraints.PAGE_START;
        //gbc.fill = GridBagConstraints.BOTH;
//            gbc.ipadx =30;
//            gbc.ipady = 50;
        add(aggiungi, gbc);
    }

    public void setFormListener(FormListener formListener) {
        this.formListener = formListener;
    }

}

class Bagagliaio {
    private int id;
    private String nome;

    public Bagagliaio(int id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return nome;
    }
}
 