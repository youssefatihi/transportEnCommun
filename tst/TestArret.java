package tec;
import java.util.List;
class TestArret  {

  public static void main (String[] args) {
    boolean estMisAssertion = false;
    assert estMisAssertion = true;

    if (!estMisAssertion) {
      System.out.println("Execution impossible sans l'option -ea");
      return;
    }

    int nbTest = 0;
    //************ Verifier l'instanciation *************

    testChoixArretAgoraphobe();
     System.out.print('.'); nbTest++;
 

    //********* Verifier changement d'etat **************

     System.out.print('.'); nbTest++;
 

     System.out.println("(" + nbTest + "):OK: " + "tec.TestArret"); 
  }
  //********************************************************
  static void testChoixArretAgoraphobe(){
    PassagerAbstrait passager=new MonteeFatigue("passager1", 5, new ArretAgoraphobe());
    
    FauxVehicule faux = new FauxVehicule(FauxVehicule.PLEIN);
    passager.changerEnDebout();
    passager.nouvelArret(faux, 1);
    assert passager.estDehors() == false : "okkkaaay broo";
  }

/* Interaction a un arret
     * Deux cas
     *  - numero d'arret < a la destination
     *  - numero d'arret >= a la destination 
     */

  static void testChoixPlaceArret(){
    PassagerStandard p=new PassagerStandard("passager1", 5);
     FauxVehicule faux = new FauxVehicule(FauxVehicule.VIDE);
    p.nouvelArret(faux,5);


  }


}

