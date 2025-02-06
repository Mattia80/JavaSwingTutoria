package episodio13;

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

      PannelloForm() {
            setPreferredSize(new Dimension(300, 100));
            setLayout(new GridBagLayout());

            // Bordi
            Border bordoInterno = BorderFactory.createTitledBorder("Aggiungi Automobile");
            Border bordoEsterno = BorderFactory.createEmptyBorder(0,5,5,5);
            Border bordoFinale = BorderFactory.createCompoundBorder(bordoEsterno, bordoInterno);
            setBorder(bordoFinale);

            labelMarca = new JLabel("Marca: ");
            fieldMarca = new JTextField(20);

            labelModello = new JLabel("Modello: ");
            fieldModello = new JTextField(20);

            aggiungi = new JButton("Aggiungi!");

            aggiungi.addActionListener(new ActionListener() {
                  @Override
                  public void actionPerformed(ActionEvent e) {
                        String marca = fieldMarca.getText();
                        String modello = fieldModello.getText();
                        FormEvent formEvent = new FormEvent(this, marca, modello);

                        if (formListener != null) {
                              formListener.formEventListener(formEvent);
                        }
                  }
            });

            // Layout
            GridBagConstraints gbc = new GridBagConstraints();

            // Label Marca
            gbc.gridx = 0;
            gbc.gridy = 0;
            gbc.weightx = 0.01;
            gbc.weighty = 0.01;
            gbc.anchor = GridBagConstraints.LINE_END;
            gbc.insets = new Insets(0,0, 0, 5);
            add(labelMarca, gbc);

            // Field Marca
            gbc.gridx = 1;
            gbc.gridy = 0;
            gbc.weightx = 0.01;
            gbc.weighty = 0.01;
            gbc.anchor = GridBagConstraints.LINE_START;
            gbc.insets = new Insets(0,0, 0, 0);
            add(fieldMarca, gbc);

            // Label Modello
            gbc.gridx = 0;
            gbc.gridy = 1;
            gbc.weightx = 0.01;
            gbc.weighty = 0.01;
            gbc.anchor = GridBagConstraints.LINE_END;
            gbc.insets = new Insets(0,0, 0, 5);
            add(labelModello, gbc);

            // Field Modello
            gbc.gridx = 1;
            gbc.gridy = 1;
            gbc.weightx = 0.01;
            gbc.weighty = 0.01;
            gbc.anchor = GridBagConstraints.LINE_START;
            gbc.insets = new Insets(0,0, 0, 0);
            add(fieldModello, gbc);

            // Bottone Aggiungi
            gbc.gridx = 0;
            gbc.gridy = 2;
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
 