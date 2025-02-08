package episodio27.model;

import javax.swing.table.AbstractTableModel;
import java.util.List;

public class TableModelAuto extends AbstractTableModel {

    private List<Auto> listaAutomobili;
    private String[] nomiColonne = {"Id", "Marca", "Modello", "Vendita", "Targa", "Cambio", "Bagagliaio", "Alimentazione", "Numero Posti", "Cilindrata", "Colore"};

    public TableModelAuto() {

    }

    public void setData(List<Auto> listaAutomobili) {
        this.listaAutomobili = listaAutomobili;
    }

    @Override
    public int getRowCount() {
        return listaAutomobili.size();
    }

    @Override
    public int getColumnCount() {
        return 11;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Auto auto = listaAutomobili.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return auto.getId();
            case 1:
                return auto.getMarca();
            case 2:
                return auto.getModello();
            case 3:
                return auto.isVendita();
            case 4:
                return auto.getTarga();
            case 5:
                return auto.getCambio();
            case 6:
                return auto.getBagagliaio();
            case 7:
                return auto.getAlimentazione();
            case 8:
                return auto.getNumeroPosti();
            case 9:
                return auto.getCilindrata();
            case 10:
                return auto.getColore();
            default:
                return null;
        }
    }

    @Override
    public String getColumnName(int column) {
        return nomiColonne[column];
    }
}
