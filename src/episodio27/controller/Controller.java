package episodio27.controller;

import episodio27.model.Auto;
import episodio27.model.Bagagliaio;
import episodio27.model.Cambio;
import episodio27.model.Database;

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

    public List<episodio27.model.Auto> getAutomobili() {
        return db.getAutomobili();
    }
}
