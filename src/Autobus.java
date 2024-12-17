
package tec;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

class Autobus implements Transport, Vehicule {
    private int numeroArret;
    private List<Passager> passagers;
    private Jauge assis;
    private Jauge debout;

     Autobus(int nbPlaceAssise, int nbPlaceDebout)  {
        if (nbPlaceAssise < 0 || nbPlaceDebout < 0)
            throw new IllegalArgumentException("Une valeur negative pour le nombre de place ");
        assis = new Jauge(nbPlaceAssise, 0);
        debout = new Jauge(nbPlaceDebout, 0);
        passagers = new ArrayList<>();
        numeroArret = 0;
    }
  private int chercherEmplacementVide() {
      if(aPlaceAssise() || aPlaceDebout()) return 1; 
      return -1;
  }
  private int chercherPassager(Passager p) {
      Iterator<Passager> iterator = passagers.iterator();
      int i = 0;
      while (iterator.hasNext()) {
          Passager passager = iterator.next();
          if (passager == p) {
              return i;
          }
          i++;
      }
      return -1;
    }
    
    public void allerArretSuivant() {
        List<Passager> copiePassagers = new ArrayList<>(passagers);
        for (Passager passager : copiePassagers) {
            if (passager != null) {
                passager.nouvelArret(this, numeroArret);
            }
        }
        numeroArret += 1;
    }

    public boolean aPlaceAssise() {
        return assis.estVert();
    }

    public boolean aPlaceDebout() {
        return debout.estVert();
    }

    public void monteeDemanderAssis(Passager p) {
        if (chercherPassager(p) != -1) {
            throw new IllegalStateException("Passager déjà existe!");
        }
        int index = chercherEmplacementVide();
        if (index != -1) {
            passagers.add(p);
            p.changerEnAssis();
            assis.incrementer();
        }
    }

    public void monteeDemanderDebout(Passager p) {
        if (chercherPassager(p) != -1) {
            throw new IllegalStateException("Passager déjà existe!");
        }
        int index = chercherEmplacementVide();
        if (index != -1) {
            passagers.add(p);
            p.changerEnDebout();
            debout.incrementer();
        }
    }

    public void arretDemanderDebout(Passager p) {
        if (p.estDebout() || p.estAssis()) {
            p.changerEnDebout();
            assis.decrementer();
            debout.incrementer();
        }
    }

    public void arretDemanderAssis(Passager p) {
        p.changerEnAssis();
        assis.incrementer();
        debout.decrementer();
    }

    public void arretDemanderSortie(Passager p) {
        Iterator<Passager> iterator = passagers.iterator();
        while (iterator.hasNext()) {
            Passager passager = iterator.next();
            if (passager == p) {
                  if (p.estAssis()) {
                  assis.decrementer();
              } else if (p.estDebout()) {
                  debout.decrementer();
              }
              p.changerEnDehors();
              iterator.remove();
            }
        }
    }

    public String toString(){
    //     Pattern pattern = Pattern.compile("<(\\d+) \\[(\\d+),(\\d+)\\[>");
    //     Matcher matcher_assis = pattern.matcher(this.assis.toString());
    //     // if (matcher.find()) {
    //         // Extraction des valeurs des groupes
    //         int valeur_assis = Integer.parseInt(matcher_assis.group(1));
    //         int max_assis = Integer.parseInt(matcher_assis.group(2));

    //      Matcher matcher_debout = pattern.matcher(this.debout.toString());
    //     // if (matcher.find()) {
    //         // Extraction des valeurs des groupes
    //         int valeur_debout = Integer.parseInt(matcher_debout.group(1));
    //         int max_debout = Integer.parseInt(matcher_debout.group(2));
    //     // }
    //   int restantAssis = max_assis - valeur_assis;
    //   int restantDebout  = max_debout - valeur_debout;
      int restantAssis =  (int)(this.assis.toString().charAt(6))- (int)(this.assis.toString().charAt(1)) ;
      int restantDebout =  (int)(this.debout.toString().charAt(6))- (int)(this.debout.toString().charAt(1)) ;
      return "[arret "+ this.numeroArret + "] assis<" +(restantAssis)  + "> debout<" + (restantDebout) + ">" ;
    }
    
}
