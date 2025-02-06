package episodio10;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class PannelloForm extends JPanel {

      PannelloForm() {
            setPreferredSize(new Dimension(300, 100));
            Border bordoInterno = BorderFactory.createTitledBorder("Aggiungi Automobile");
            Border bordoEsterno = BorderFactory.createEmptyBorder(0,5,5,5);
            Border bordoFinale = BorderFactory.createCompoundBorder(bordoEsterno, bordoInterno);
            setBorder(bordoFinale);
      }

}
