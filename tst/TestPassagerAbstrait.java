package tec;
class TestPassagerAbstrait {
  private PassagerAbstrait creerPassager(String nom, int destination, ComportementArret c) {
      return new PassagerAbstrait(nom, destination, c) {
        protected void choixPlaceMontee(Vehicule v) {}
        protected void choixPlaceArret(Vehicule v, int arret) {}
      };
    }

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
    new TestPassagerAbstrait().testInstanciation();

    //********* Verifier changement d'etat **************
    System.out.print('.'); nbTest++;
    new TestPassagerAbstrait().testGestionEtat();

    //********* Verifier les interactions  *************
    System.out.print('.'); nbTest++;
    new TestPassagerAbstrait().testInteractionMontee();

   /* System.out.print('.'); nbTest++;
    new TestPassagerStandard().testInteractionArret();*/
    System.out.print('.'); nbTest++;
    new TestPassagerAbstrait().testExceptionDestination();

    System.out.println("(" + nbTest + "):OK: " + "tec.PassagerAbstrait"); 
  }

  //********************************************************
  /* Etat apres instanciation
   * Un seul cas 
   */  
  public void testInstanciation() {
    PassagerAbstrait p = creerPassager("xxx", 3, new ArretCalme());

    assert false == p.estAssis();
    assert false == p.estDebout();
    assert true == p.estDehors();
  }

  /* Gestion des changement d'état.
   * 
   * Changer Debout puis Dehors puis assis. 
   */
  public void testGestionEtat() {
    PassagerAbstrait p = creerPassager("yyy", 3, new ArretCalme());

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
 
  /* Interaction a la montee
   * Trois cas
   *  - des places assises et debout
   *  - pas de place assise
   *  - aucune place. 
   */
  public void testInteractionMontee() throws TecException{
    PassagerAbstrait p = creerPassager("yyy", 5, new ArretCalme());
    
    FauxVehicule faux = new FauxVehicule(FauxVehicule.VIDE);
    p.monterDans(faux);
  
    assert 0 == faux.logs.size() : "pas de place";    
    
    faux = new FauxVehicule(FauxVehicule.DEBOUT);
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
  public void testInteractionArret() throws TecException {
    PassagerAbstrait p = creerPassager("yyy", 5, new ArretCalme());
    
    FauxVehicule faux = new FauxVehicule(FauxVehicule.VIDE);

    p.nouvelArret(faux, 1);
    assert 0 == faux.logs.size() : "pas a destination";

    p.nouvelArret(faux, 5);
    assert "arretDemanderSortie" == getLastLog(faux) : "destination";    
  }
  private String getLastLog(FauxVehicule f) {
    return f.logs.get(f.logs.size() -1);
  }

  public void testExceptionDestination(){
        try {
    PassagerAbstrait p = creerPassager("yyy", -5, new ArretCalme());   
            assert false : "Exception non levée";
        } catch (IllegalArgumentException e) {
        }
  }
}
