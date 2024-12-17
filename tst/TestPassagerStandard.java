package tec;
import java.util.List;
class TestPassagerStandard  {

  public static void main (String[] args) {
    boolean estMisAssertion = false;
    assert estMisAssertion = true;

    if (!estMisAssertion) {
      System.out.println("Execution impossible sans l'option -ea");
      return;
    }

    int nbTest = 0;
  //   //************ Verifier l'instanciation *************

    testChoixPlaceMontee();
     System.out.print('.'); nbTest++;
 

  //   //********* Verifier changement d'etat **************
  //   new TestPassagerStandard().testGestionEtat();
    testChoixPlaceArret();
 
     System.out.print('.'); nbTest++;
 

     System.out.println("(" + nbTest + "):OK: " + "tec.PassagerStandard"); 
  // }
  }
  //********************************************************
  static void testChoixPlaceMontee(){
    PassagerStandard passager=new PassagerStandard("passager1", 5);
    FauxVehicule faux = new FauxVehicule(FauxVehicule.VIDE);
    passager.choixPlaceMontee(faux);
    assert "monteeDemanderAssis" == faux.logs.get(faux.logs.size()-1) : "assis";
    FauxVehicule faux2 = new FauxVehicule(FauxVehicule.DEBOUT);
    passager.choixPlaceMontee(faux2);
    assert "monteeDemanderDebout" == faux2.logs.get(faux.logs.size()-1) : "debout";
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

