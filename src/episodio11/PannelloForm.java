package episodio11;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class PannelloForm extends JPanel {

      private JLabel marca;
      private JLabel modello;

      private JTextField fieldMarca;
      private JTextField fieldModello;

      private JButton aggiungi;

      PannelloForm() {
            setPreferredSize(new Dimension(300, 100));
            Border bordoInterno = BorderFactory.createTitledBorder("Aggiungi Automobile");
            Border bordoEsterno = BorderFactory.createEmptyBorder(0,5,5,5);
            Border bordoFinale = BorderFactory.createCompoundBorder(bordoEsterno, bordoInterno);
            setBorder(bordoFinale);

            marca = new JLabel("Marca: ");
            fieldMarca = new JTextField(20);

            modello = new JLabel("Modello: ");
            fieldModello = new JTextField(20);

            aggiungi = new JButton("Aggiungi!");
      }

}
 