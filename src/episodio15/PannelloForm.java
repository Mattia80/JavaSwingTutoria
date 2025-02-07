package episodio15;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PannelloForm extends JPanel {

      private JLabel labelMarca;
      private JLabel labelModello;

      private JTextField fieldMarca;
      private JTextField fieldModello;

      private JButton aggiungi;

      private FormListener formListener;

      private JLabel labelVendita;
      private JCheckBox checkVendita;

      private JLabel labelTarga;
      private JTextField fieldTarga;

      private JLabel labelCambio;
      private JRadioButton radioCambioManuale;
      private JRadioButton radioCambioAutomatico;
      private ButtonGroup gruppoRadioCambio;

      PannelloForm() {
            setPreferredSize(new Dimension(300, 100));
            setLayout(new GridBagLayout());

            // Bordi
            Border bordoInterno = BorderFactory.createTitledBorder("Aggiungi Automobile");
            Border bordoEsterno = BorderFactory.createEmptyBorder(0,5,5,5);
            Border bordoFinale = BorderFactory.createCompoundBorder(bordoEsterno, bordoInterno);
            setBorder(bordoFinale);

            // Marca
            labelMarca = new JLabel("Marca: ");
            fieldMarca = new JTextField(20);

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

            // Bottone
            aggiungi = new JButton("Aggiungi!");

            aggiungi.addActionListener(new ActionListener() {
                  @Override
                  public void actionPerformed(ActionEvent e) {
                        String marca = fieldMarca.getText();
                        String modello = fieldModello.getText();
                        boolean vendita = checkVendita.isSelected();
                        String targa = fieldTarga.getText();
                        String cambio = gruppoRadioCambio.getSelection().getActionCommand();
                        FormEvent formEvent = new FormEvent(this, marca, modello, vendita, targa, cambio);

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
            gbc.insets = new Insets(0,0, 0, 5);
            add(labelMarca, gbc);

            // RIGA 1: Field Marca
            gbc.gridx = 1;
            gbc.gridy = 0;
            gbc.weightx = 0.01;
            gbc.weighty = 0.01;
            gbc.anchor = GridBagConstraints.LINE_START;
            gbc.insets = new Insets(0,0, 0, 0);
            add(fieldMarca, gbc);

            // RIGA 2: Label Modello
            gbc.gridx = 0;
            gbc.gridy = 1;
            gbc.weightx = 0.01;
            gbc.weighty = 0.01;
            gbc.anchor = GridBagConstraints.LINE_END;
            gbc.insets = new Insets(0,0, 0, 5);
            add(labelModello, gbc);

            // RIGA 2: Field Modello
            gbc.gridx = 1;
            gbc.gridy = 1;
            gbc.weightx = 0.01;
            gbc.weighty = 0.01;
            gbc.anchor = GridBagConstraints.LINE_START;
            gbc.insets = new Insets(0,0, 0, 0);
            add(fieldModello, gbc);

            // RIGA 3: Cambio
            gbc.gridx = 0;
            gbc.gridy = 2;
            gbc.weightx = 0.01;
            gbc.weighty = 0.01;
            gbc.anchor = GridBagConstraints.LINE_END;
            gbc.insets = new Insets(0,0, 0, 5);
            add(labelCambio, gbc);

            // RIGA 3: Cambio Manuale
            gbc.gridx = 1;
            gbc.gridy = 2;
            gbc.weightx = 0.01;
            gbc.weighty = 0.01;
            gbc.anchor = GridBagConstraints.LINE_START;
            gbc.insets = new Insets(0,0, 0, 0);
            add(radioCambioManuale, gbc);

            // RIGA 4: Cambio Automatico
            gbc.gridx = 1;
            gbc.gridy = 3;
            gbc.weightx = 0.01;
            gbc.weighty = 0.01;
            gbc.anchor = GridBagConstraints.LINE_START;
            gbc.insets = new Insets(0,0, 0, 0);
            add(radioCambioAutomatico, gbc);

            // RIGA 4: Label Vendita
            gbc.gridx = 0;
            gbc.gridy = 4;
            gbc.weightx = 0.01;
            gbc.weighty = 0.01;
            gbc.anchor = GridBagConstraints.LINE_END;
            gbc.insets = new Insets(0,0, 0, 5);
            add(labelVendita, gbc);

            // RIGA 4: Checkbox Vendita
            gbc.gridx = 1;
            gbc.gridy = 4;
            gbc.weightx = 0.01;
            gbc.weighty = 0.01;
            gbc.anchor = GridBagConstraints.LINE_START;
            gbc.insets = new Insets(0,0, 0, 0);
            add(checkVendita, gbc);

            // RIGA 4: Label Targa
            gbc.gridx = 0;
            gbc.gridy = 5;
            gbc.weightx = 0.01;
            gbc.weighty = 0.01;
            gbc.anchor = GridBagConstraints.LINE_END;
            gbc.insets = new Insets(0,0, 0, 5);
            add(labelTarga, gbc);

            // RIGA 4: Field Targa
            gbc.gridx = 1;
            gbc.gridy = 5;
            gbc.weightx = 0.01;
            gbc.weighty = 0.01;
            gbc.anchor = GridBagConstraints.LINE_START;
            gbc.insets = new Insets(0,0, 0, 0);
            add(fieldTarga, gbc);

            // RIGA FINALE: Bottone Aggiungi
            gbc.gridx = 0;
            gbc.gridy = 6;
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
 