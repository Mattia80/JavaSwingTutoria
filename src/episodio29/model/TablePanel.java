package episodio29.model;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

public class TablePanel extends JPanel {
    private JTable table;
    private TableModelAuto tableModelAuto;
    private JPopupMenu popupMenu;

    public TablePanel() {
        tableModelAuto = new TableModelAuto();
        table = new JTable(tableModelAuto);

        popupMenu = new JPopupMenu();
        JMenuItem menuItemEliminaAuto = new JMenuItem("Elimina Auto");
        popupMenu.add(menuItemEliminaAuto);

        table.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                if (e.getButton() == MouseEvent.BUTTON3) {
                    popupMenu.show(table, e.getX(), e.getY());
                }
            }
        });


        setLayout(new BorderLayout());
        add(new JScrollPane(table), BorderLayout.CENTER);
    }

    public void setData(List<Auto> listaAutomobili) {
        tableModelAuto.setData(listaAutomobili);
    }

    public void aggiorna() {
        tableModelAuto.fireTableDataChanged();
    }
}
