package episodio7;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BarraStrumenti extends JPanel implements ActionListener {

    private JButton bottoneBuongiorno;
    private JButton bottoneBuonasera;
    private TextAreaPanel textAreaPanel;

    public BarraStrumenti() {
        bottoneBuongiorno = new JButton("Buongiorno!");
        bottoneBuonasera = new JButton("Buonasera");

        bottoneBuongiorno.addActionListener(this);
        bottoneBuonasera.addActionListener(this);

        setLayout(new FlowLayout(FlowLayout.LEFT));
        add(bottoneBuongiorno);
        add(bottoneBuonasera);
    }

    public void setTextAreaPanel(TextAreaPanel textAreaPanel) {
        this.textAreaPanel = textAreaPanel;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton premuto = (JButton) e.getSource();
        if(premuto == bottoneBuongiorno) {
            textAreaPanel.appendiTesto("Buongiorno Porcodio!\n");
        } else if (premuto == bottoneBuonasera) {
            textAreaPanel.appendiTesto("Buonasera Porca Madonna!\n");
        }
    }
}
