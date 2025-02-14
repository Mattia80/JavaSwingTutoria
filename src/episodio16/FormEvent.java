package episodio16;

import java.util.EventObject;

public class FormEvent extends EventObject {
    private String marca;
    private String modello;
    private boolean vendita;
    private String targa;
    private String cambio;
    private int bagagliaio;

    public FormEvent(Object source) {
        super(source);
    }

    public FormEvent(Object source, String marca, String modello, boolean vendita, String targa, String cambio, int bagagliaio) {
        super(source);
        this.marca = marca;
        this.modello = modello;
        this.vendita = vendita;
        this.targa = targa;
        this.cambio = cambio;
        this.bagagliaio = bagagliaio;
    }

    public FormEvent(Object source, String marca, String modello) {
        super(source);
        this.marca = marca;
        this.modello = modello;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModello() {
        return modello;
    }

    public void setModello(String modello) {
        this.modello = modello;
    }

    public boolean isVendita() {
        return vendita;
    }

    public void setVendita(boolean vendita) {
        this.vendita = vendita;
    }

    public String getTarga() {
        return targa;
    }

    public void setTarga(String targa) {
        this.targa = targa;
    }

    public String getCambio() {
        return cambio;
    }

    public void setCambio(String cambio) {
        this.cambio = cambio;
    }

    public int getBagagliaio() {
        return bagagliaio;
    }

    public void setBagagliaio(int bagagliaio) {
        this.bagagliaio = bagagliaio;
    }
}
