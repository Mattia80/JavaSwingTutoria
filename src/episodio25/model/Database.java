package episodio25.model;

import java.util.ArrayList;
import java.util.List;

public class Database {
    private ArrayList<Auto> automobili;

   public Database() {
       automobili = new ArrayList<>();
   }

   public void addAuto(Auto auto) {
       automobili.add(auto);
       System.out.println(auto.toString());
   }

   public List<Auto> getAutomobili() {
       return automobili;
   }
}
