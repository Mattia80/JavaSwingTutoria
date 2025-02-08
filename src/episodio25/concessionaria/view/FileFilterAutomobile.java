package episodio25.concessionaria.view;

import javax.swing.filechooser.FileFilter;
import java.io.File;

public class FileFilterAutomobile extends FileFilter {

    @Override
    public boolean accept(File f) {
        if (f.isDirectory()) {
            return true;
        }

        String estensione = Utils.getExtension(f);
        if (estensione == null) {
           return false;
        }
        if (estensione.equals("car")) {
            return true;
        }
        return false;
    }

    @Override
    public String getDescription() {
        return "File Automobile (*.car)";
    }
}
