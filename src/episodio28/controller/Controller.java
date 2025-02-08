package episodio28.controller;

import episodio28.model.Auto;
import episodio28.model.Bagagliaio;
import episodio28.model.Cambio;
import episodio28.model.Database;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class Controller {

    Database db = new Database();

    public void addAuto(String marca, String modello, boolean vendita, String targa,
                        String cambioString, int bagagliaioInt, String alimentazione, int numeroPosti, int cilindrata,
                        int colore) {
        // Conversione Cambio
        Cambio cambio = null;
        if (cambioString.equals("Manuale")) {
            cambio = Cambio.MANUALE;
        } else if (cambioString.equals("Automatico")) {
            cambio = Cambio.AUTOMATICO;
        }

        // Conversione Bagagliaio
        Bagagliaio bagagliaio = null;
        switch (bagagliaioInt) {
            case 0:
                bagagliaio = Bagagliaio.PICCOLO;
                break;
            case 1:
                bagagliaio = Bagagliaio.MEDIO;
                break;
            case 2:
                bagagliaio = Bagagliaio.GRANDE;
                break;
        }

        // Creazione Auto
        Auto auto = new Auto(marca, modello, vendita, targa, cambio, bagagliaio, alimentazione, numeroPosti, cilindrata, colore);

        // Aggiungiamo l'auto nel database
        db.addAuto(auto);
    }

    public List<Auto> getAutomobili() {
        return db.getAutomobili();
    }

    public void salvaSuFile(File file) throws IOException {
        db.salvaSuFile(file);
    }

    public void caricaDaFile(File file) throws IOException {
        db.caricaDaFile(file);
    }
}
