package tec;
import java.util.List;
class TestPassagerIndecis  {

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
 

     System.out.println("(" + nbTest + "):OK: " + "tec.PassagerIndecis"); 
  // }
  }
  //********************************************************
  static void testChoixPlaceMontee(){
    PassagerIndecis passager=new PassagerIndecis("passager1", 5);
    FauxVehicule faux = new FauxVehicule(FauxVehicule.VIDE);
    passager.choixPlaceMontee(faux);
    assert "monteeDemanderDebout" == faux.logs.get(faux.logs.size()-1) : "Debout";
     PassagerIndecis passager2=new PassagerIndecis("passager2", 5);
    FauxVehicule faux2 = new FauxVehicule(FauxVehicule.DEBOUT);
    passager.choixPlaceMontee(faux2);
    assert "monteeDemanderDebout" == faux2.logs.get(faux.logs.size()-1) : "Debout";
  }

/* Interaction a un arret
     * Deux cas
     *  - numero d'arret < a la destination
     *  - numero d'arret >= a la destination 
     */

  static void testChoixPlaceArret(){
    PassagerIndecis p=new PassagerIndecis("passager1", 5);
     FauxVehicule faux = new FauxVehicule(FauxVehicule.VIDE);
    //p.nouvelArret(faux, 1);
	//assert 0 == faux.logs.size() : "pas a destination";
   // p.choixPlaceArret(faux,4);
	
	//assert "arretDemanderSortie" != faux.logs.get( : "destination"; 


  }


}

