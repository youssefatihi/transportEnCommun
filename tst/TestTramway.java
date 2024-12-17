package tec;
class TestTramway {
  
  public static void main (String[] args) {
    boolean estMisAssertion = false;
    assert estMisAssertion = true;

    if (!estMisAssertion) {
      System.out.println("Execution impossible sans l'option -ea");
      return;
    }

    int nbTest = 0;

    //************ Verifier l'instanciation *************
    System.out.print('.'); nbTest++;
    new TestTramway().testInstanciation();

    //********* Verifier la gestion des places **********
    System.out.print('.'); nbTest++;
    new TestTramway().testGestionDemander();

    System.out.print('.'); nbTest++;
    new TestTramway().testGestionChanger();

    System.out.print('.'); nbTest++;
    new TestTramway().testGestionSortie();

    //******** Verifier les interactions  *************
    System.out.print('.'); nbTest++;
    new TestTramway().testInteractionDemander();

    System.out.print('.'); nbTest++;
    new TestTramway().testInteractionChanger();

    System.out.print('.'); nbTest++;
    new TestTramway().testInteractionSortie();

    //********* Gestion des passagers ***************
    System.out.print('.'); nbTest++;
    new TestTramway().testArretSuivant();

    System.out.println("(" + nbTest + "):OK: " + "tec.TestTramway"); 
  }

  //********************************************************
  
  /* Etat apres instanciation
   * Deux cas d'autobus:
   *   - uniquement des places assises.
   *   - uniquement des places debout.
   */
  public void testInstanciation() {
    //*********** Assis ****************************

    Tramway assis = new Tramway(new Autobus(66, 0));
    assert true == assis.aPlaceAssise();
    assert false == assis.aPlaceDebout();

    //************ Debout ***************************
    Tramway debout =new Tramway(new Autobus(0, 99));
    assert false == debout.aPlaceAssise();
    assert true == debout.aPlaceDebout();
  }


  /* Gestion des places a la montee.
   *
   * Remplir toutes les places assises d'un autobus.
   * Remplir toutes les places debout d'un autobus.
   */
  public void testGestionDemander() {
    FauxPassager[] faux = {new FauxPassager(),
			       new FauxPassager(),
			       new FauxPassager(),
			       new FauxPassager(),
			       new FauxPassager(),
			       new FauxPassager(),
			       new FauxPassager(),
			       new FauxPassager(),
			       new FauxPassager(),
			       new FauxPassager()}; //10

    Tramway tram = new Tramway(new Autobus(5,3));

    //********* Assis *******************************
    for (int i = 1; i < 5; i++) { //4
      tram.monteeDemanderAssis(faux[i]);
      assert true == tram.aPlaceAssise() : "demande " + i;	
    }

    tram.monteeDemanderAssis(faux[5]);
    assert false == tram.aPlaceAssise() : "demande 5: fin assis";


    //*********** Debout ******************************
    tram.monteeDemanderDebout(faux[6]);
    assert true == tram.aPlaceDebout() : "demande 1";	

    tram.monteeDemanderDebout(faux[7]);
    assert true == tram.aPlaceDebout() : "demande 2";	

    tram.monteeDemanderDebout(faux[8]);
    assert false == tram.aPlaceDebout() : "demande 3: fin debout";
  }

  /* Gestion des places à la sortie d'un passager a un arret. 
   *
   * Remplir toutes les places assises et toutes les places debout.
   * Faire sortir un assis et un debout.
   */
  public void testGestionSortie() {
    FauxPassager[] faux = {new FauxPassager(),
			       new FauxPassager(),
			       new FauxPassager(),
			       new FauxPassager(),
			       new FauxPassager(),
			       new FauxPassager(),
			       new FauxPassager(),
			       new FauxPassager(),
			       new FauxPassager()}; // 9

    Tramway tram = new Tramway(new Autobus(3, 4));
    //*************** Remplir **********************
    for (int i = 1; i < 4; i++) { //3
      tram.monteeDemanderAssis(faux[i]);
      faux[i].status = FauxPassager.ASSIS;
    }

    for (int i = 4; i <= 7; i++) { //4
      tram.monteeDemanderDebout(faux[i]);
      faux[i].status = FauxPassager.DEBOUT;
    }

    //***************** Sortir *************************
    tram.arretDemanderSortie(faux[6]);
    assert true == tram.aPlaceDebout() : "sortie debout";

    tram.arretDemanderSortie(faux[2]);
    assert true == tram.aPlaceAssise() : "sortie assis";
  }

  /* Gestion du changement de places a un arret.
   *
   * Remplir Autobus max assise et max debout - 1.
   * 
   * Changer un assis en debout
   * et un debout en assis.
   */
  public void testGestionChanger() {
    FauxPassager[] faux = {new FauxPassager(),
			       new FauxPassager(),
			       new FauxPassager(),
			       new FauxPassager(),
			       new FauxPassager(),
			       new FauxPassager(),
			       new FauxPassager(),
			       new FauxPassager(),
			       new FauxPassager()}; // 9


    Tramway tram = new Tramway(new Autobus(3, 5));
    //*************** Remplir **********************
    for (int i = 1; i < 4; i++) { //3
      tram.monteeDemanderAssis(faux[i]);
      faux[i].status = FauxPassager.ASSIS;
    }

    for (int i = 4; i <= 7; i++) { //4
      tram.monteeDemanderDebout(faux[i]);
      faux[i].status = FauxPassager.DEBOUT;
    }

    //************** Changer *************************
    tram.arretDemanderDebout(faux[2]);
    assert true == tram.aPlaceAssise() : "assis";
    assert false == tram.aPlaceDebout() : "debout";


    tram.arretDemanderAssis(faux[5]);
    assert false == tram.aPlaceAssise() : "assis";
    assert true == tram.aPlaceDebout() : "debout";
  }


  /* Interaction a la montee.
   *
   * Remplir un autobus debout puis assis.
   */
  public void testInteractionDemander() {
    FauxPassager[] faux = {new FauxPassager(),
			       new FauxPassager(),
			       new FauxPassager(),
			       new FauxPassager(),
			       new FauxPassager(),
			       new FauxPassager(),
			       new FauxPassager(),
			       new FauxPassager(),
			       new FauxPassager(),
			       new FauxPassager()}; //10

    Tramway tram = new Tramway(new Autobus(3, 5));
    //*********** Debout ******************************
    for (int i = 1; i < 6; i++) { //5
      tram.monteeDemanderDebout(faux[i]);
      assert 1 == faux[i].logs.size() 
	: "erreur nombre d'appels pour " + i;
      assert "changerEnDebout" == getLastLog(faux[i])
	: "mauvais appel pour " + i;
    }

    //********* Assis *******************************
    for (int i = 6; i < 9; i++) { //3
      tram.monteeDemanderAssis(faux[i]);
      assert 1 == faux[i].logs.size() 
	: "erreur nombre d'appels pour " + i;
      assert "changerEnAssis" == getLastLog(faux[i])
	: "mauvais appel pour " + i;
    }
  }


  /* Interaction pour un changement de places.
   * 
   * Changer un debout en assis puis d'assis à debout.
   */
  public void testInteractionChanger() {
    FauxPassager faux = new FauxPassager();


    Tramway tram = new Tramway(new Autobus(1, 1));
    tram.monteeDemanderDebout(faux);
    faux.status = FauxPassager.DEBOUT;

    tram.arretDemanderAssis(faux);
    assert 2 == faux.logs.size() : "erreur nombre d'appels";
    assert "changerEnAssis" == getLastLog(faux) : "mauvais appel";

    tram.arretDemanderDebout(faux);
    assert 3 == faux.logs.size() : "erreur nombre d'appels";
    assert "changerEnDebout" == getLastLog(faux) : "mauvais appel";
  }

  /* Interaction la sortie d'un passager.
   *
   * demander des places assises et debout.
   * et faire sortir un assis et un debout.
   */
  public void testInteractionSortie() {
    FauxPassager[] faux = {new FauxPassager(),
			       new FauxPassager(),
			       new FauxPassager(),
			       new FauxPassager(),
			       new FauxPassager(),
			       new FauxPassager(),
			       new FauxPassager(),
			       new FauxPassager(),
			       new FauxPassager()}; // 9


    Tramway tram = new Tramway(new Autobus(10, 20));
    //*************** Ajouter **********************
    tram.monteeDemanderAssis(faux[1]);
    faux[1].status = FauxPassager.ASSIS;

    tram.monteeDemanderDebout(faux[2]);
    faux[2].status = FauxPassager.DEBOUT;

    tram.monteeDemanderDebout(faux[3]);
    faux[3].status = FauxPassager.DEBOUT;

    tram.monteeDemanderAssis(faux[4]);
    faux[4].status = FauxPassager.ASSIS;

    tram.monteeDemanderDebout(faux[5]);
    faux[5].status = FauxPassager.DEBOUT;

    tram.monteeDemanderAssis(faux[6]);
    faux[6].status = FauxPassager.ASSIS;

    tram.monteeDemanderAssis(faux[7]);
    faux[7].status = FauxPassager.ASSIS;

    //***************** Sortir *************************
    tram.arretDemanderSortie(faux[6]);
    assert 2 == faux[6].logs.size() : "erreur nombre d'appels";
    assert "changerEnDehors" == getLastLog(faux[6]) : "mauvais appel";

    tram.arretDemanderSortie(faux[2]);
    assert 2 == faux[2].logs.size() : "erreur nombre d'appels";
    assert "changerEnDehors" == getLastLog(faux[2]) : "mauvais appel";
  }


  //********* Gestion des passagers ***************
  /* Interaction pour indiquer un arret au passager
   * L'autobus declenche la methode nouvelArret
   * sur tous les passagers stockes. 
   * 
   * Ajouter quelques passager assise et debout.
   * Faire sortie des passagers assis et debout.
   */
  public void testArretSuivant() {
    FauxPassager[] faux = {new FauxPassager(),
			       new FauxPassager(),
			       new FauxPassager(),
			       new FauxPassager(),
			       new FauxPassager(),
			       new FauxPassager(),
			       new FauxPassager(),
			       new FauxPassager(),
			       new FauxPassager()}; // 9


    Tramway tram = new Tramway(new Autobus(99, 66));
    //********* Ajout des passagers **********
    for (int i = 1; i < 5; i++) {
      tram.monteeDemanderAssis(faux[i]);
      faux[i].status = FauxPassager.ASSIS;
    }

    for (int i = 5; i < 9; i++) {
      tram.monteeDemanderDebout(faux[i]);
      faux[i].status = FauxPassager.DEBOUT;
    }

    /*******************************************/
    tram.allerArretSuivant();
    
    for (int i = 1; i < 9; i++) {
      assert 2 == faux[i].logs.size() 
	: "erreur nombre d'appels pour " + i;
      assert "nouvelArret" == getLastLog(faux[i])
	: "mauvais appel pour " + i;
    }

    //******** Suppression de passagers ******************
    tram.arretDemanderSortie(faux[3]);
    tram.arretDemanderSortie(faux[6]);
    tram.arretDemanderSortie(faux[8]);

    tram.monteeDemanderDebout(faux[0]);
    faux[0].status = FauxPassager.DEBOUT;

    tram.allerArretSuivant();

    assert "nouvelArret" != getLastLog(faux[3])
      : "plus d'appel a nouvelArret:3";
    assert "nouvelArret" != getLastLog(faux[6]) 
      : "plus d'appel a nouvelArret:6";
    assert "nouvelArret" != getLastLog(faux[8]) 
      : "plus d'appel a nouvelArret:8";

    assert "nouvelArret" == getLastLog(faux[0]) 
      : "plus d'appel a nouvelArret:0";

    for (int i = 1; i < 8; i++) {
      if (3 == i || 6 == i)
	continue;
      
      assert 3 == faux[i].logs.size() 
	: "erreur nombre d'appels pour " + i;
      assert "nouvelArret" == getLastLog(faux[i])
	: "mauvais appel pour " + i;
    }
  }

  public void testExceptionNombreDePlaces(){
    try{
    Tramway tram = new Tramway(new Autobus(-5, -7));
    }catch (IllegalArgumentException e){

    }
  }
  public void testExceptionPassagerExistant() throws TecException{
      Transport tram = (Transport)new Tramway(new Autobus(-5, -7));
      PassagerStandard p = new PassagerStandard("Nicolas", 4);
      p.monterDans(tram);
    try{
      p.monterDans(tram);
    }catch (IllegalStateException e){

    }
  }
  private String getLastLog(FauxPassager f) {
    return f.logs.get(f.logs.size() -1);
  }
}
