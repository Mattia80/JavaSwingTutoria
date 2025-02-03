package episodio6;

import javax.swing.*;
import java.awt.*;

public class BarraStrumenti extends JPanel {

    private JButton bottoneBuongiorno;
    private JButton bottoneBuonasera;

    public BarraStrumenti() {
        bottoneBuongiorno = new JButton("Buongiorno!");
        bottoneBuonasera = new JButton("Buonasera");

        setLayout(new FlowLayout(FlowLayout.LEFT));
        add(bottoneBuongiorno);
        add(bottoneBuonasera);
    }

}
