package tec;
class TestCaracteres {

  public static void main (String[] args) throws TecException {
    boolean estMisAssertion = false;
    assert estMisAssertion = true;

    if (!estMisAssertion) {
      System.out.println("Execution impossible sans l'option -ea");
      return;
    }

    int nbTest = 0;

    //************ Verifier l'instanciation *************
    System.out.print('.'); nbTest++;
    new TestCaracteres().testInstanciation();

    //********* Verifier changement d'etat **************
    System.out.print('.'); nbTest++;
    new TestCaracteres().testGestionEtat();

    //********* Verifier les interactions  Indecis *************
    System.out.print('.'); nbTest++;
    new TestCaracteres().testInteractionMonteeIndecis();

    //********* Verifier les interactions Stresse *************
    System.out.print('.'); nbTest++;
    new TestCaracteres().testInteractionMonteeStresse();

    //
    System.out.print('.'); nbTest++;
    new TestCaracteres().testInteractionArretIndecis();

    System.out.println("(" + nbTest + "):OK: " + "tec.PassagerIndecis + tec.PassagerStresse"); 
  }

  //********************************************************
  /* Etat apres instanciation
   * Un seul cas 
   */  
  public void testInstanciation() { 
    // tous les  caracteres ont le meme cacrtere au moment de l'instanciation
    // on choisit par exemple un passager indecis
    PassagerIndecis p = new PassagerIndecis("xxx", 3);

    assert false == p.estAssis();
    assert false == p.estDebout();
    assert true == p.estDehors();
  }

  /* Gestion des changement d'état.
   * 
   * Changer Debout puis Dehors puis assis. 
   */
  public void testGestionEtat() {
    // pareil ici, les deux passagers ont le meme comportement, on prend cette fois un
    // passger stresse
    PassagerStresse p = new PassagerStresse("yyy", 3);

    p.changerEnDebout();
    assert false == p.estAssis();
    assert true == p.estDebout();
    assert false == p.estDehors();

    p.changerEnDehors();
    assert false == p.estAssis();
    assert false == p.estDebout();
    assert true == p.estDehors();

    p.changerEnAssis();
    assert true == p.estAssis();
    assert false == p.estDebout();
    assert false == p.estDehors();
  }  
 
  /* Interaction a la montee d'un passager indecis
   * Trois cas
   *  - des places assises et debout
   *  - pas de place assise
   *  - aucune place. 
   */
  public void testInteractionMonteeStresse() throws TecException{
    PassagerStresse p = new PassagerStresse("yyy", 5);
    
    FauxVehicule faux = new FauxVehicule(FauxVehicule.VIDE);
    p.monterDans(faux);
  
    assert "monteeDemanderAssis" == getLastLog(faux) : "assis";    
    
    faux = new FauxVehicule(FauxVehicule.DEBOUT);
    p.monterDans(faux);
    
    assert "monteeDemanderDebout" == getLastLog(faux) : "debout";    

    faux = new FauxVehicule(FauxVehicule.PLEIN);
    p.monterDans(faux);
    
    assert 0 == faux.logs.size() : "pas de place";            
  }

/* Interaction a la montee d'un passager stresse
   * Trois cas
   *  - des places assises et debout, le passager demande une place debout ou reste dehors
   *  - pas de place debout, il reste dehors
   *  - aucune place, il reste dehors
   */
  public void testInteractionMonteeIndecis() throws TecException{
    PassagerIndecis p = new PassagerIndecis("yyy", 5);
    
    FauxVehicule faux = new FauxVehicule(FauxVehicule.VIDE);
    p.monterDans(faux);
  
    assert "monteeDemanderDebout" == getLastLog(faux) : "debout";    
    
    faux = new FauxVehicule(FauxVehicule.ASSIS);
    p.monterDans(faux);
    
    assert 0 == faux.logs.size() : "pas de place";    

    faux = new FauxVehicule(FauxVehicule.PLEIN);
    p.monterDans(faux);
    
    assert 0 == faux.logs.size() : "pas de place";        
  }
  /* Interaction a un arret
   * Deux cas
   *  - numero d'arret < a la destination
   *  - numero d'arret >= a la destination 
   */
  public void testInteractionArretIndecis() {
    PassagerIndecis p = new PassagerIndecis("yyy", 5);
    
    FauxVehicule faux = new FauxVehicule(FauxVehicule.VIDE);

    p.nouvelArret(faux, 1);
    assert 0 == faux.logs.size() : "pas a destination";

    // p.nouvelArret(faux, 3);
    // assert "arretDemanderDebout" == getLastLog(faux) : "debout";  

    // p.nouvelArret(faux, 5);
    // assert "arretDemanderSortie" == getLastLog(faux) : "destination";   a refaire  
  }

  private String getLastLog(FauxVehicule f) {
    return f.logs.get(f.logs.size() -1);
  }
}
