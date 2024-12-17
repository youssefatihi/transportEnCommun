package tec;
import java.util.List;
class TestPassageStressed  {

  public static void main (String[] args) {
    boolean estMisAssertion = false;
    assert estMisAssertion = true;

    if (!estMisAssertion) {
      System.out.println("Execution impossible sans l'option -ea");
      return;
    }

    int nbTest = 0;
  //   //************ Verifier l'instanciation *************
     System.out.print('.'); nbTest++;
  //   new TestPassagerStandard().testInstanciation();
 

  //   //********* Verifier changement d'etat **************
     
  
    
    testChoixPlaceMontee();
  System.out.print('.'); nbTest++;
  //   //********* Verifier les interactions  *************
    System.out.print('.'); nbTest++;
  testChoixPlaceArret();

     System.out.println("(" + nbTest + "):OK: " + "tec.PassagerStresse"); 
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

 static void testChoixPlaceArret(){
    PassagerStandard p=new PassagerStandard("passager1", 5);
     FauxVehicule faux = new FauxVehicule(FauxVehicule.VIDE);
    //p.nouvelArret(faux, 1);
	//assert 0 == faux.logs.size() : "pas a destination";
  //  p.choixPlaceArret(faux,4);
	
	//assert "arretDemanderSortie" != faux.logs.get( : "destination"; 


  }

}

