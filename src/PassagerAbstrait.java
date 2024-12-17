package tec;
abstract class PassagerAbstrait implements Passager, Usager {

 protected Position position;
 private final String name;
 private int destination;

 private final ComportementArret comportement;


  PassagerAbstrait(String name, int destination, ComportementArret c){
    if(destination < 0) throw new IllegalArgumentException("Valeur négative de la destination!");
    this.position = Position.createPosition();
    this.destination=destination;
    this.name=name;
    this.comportement = c;
 }

  public String nom(){
    return this.name;
  }
  /**
   * Le passager est-il en dehors d'un véhicule ?
   * @return vrai si la position du passager est dehors.
   */
   public boolean estDehors(){
    return position.estDehors();
  }
  
  /**
   * Le passager est-il assis dans un véhicule ?
   * @return vrai si la position du passager est assis.
   */
   public boolean estAssis(){
    return position.estAssis();
  }
  
  /**
   * Le passager est-il debout dans un véhicule?
   * @return vrai si la position du passager est debout.
   */
   public boolean estDebout(){
    return position.estDebout();
  }
  /**
   * Change la position du passager en dehors.
   * Cette méthode est appélee par un véhicule.
   */
   public void changerEnDehors(){
    this.position=position.dehors();
  }
  
  /**
   * Change la position du passager en assis. 
   * Cette méthode est appélee par un véhicule.
   */
   public void changerEnAssis(){
    this.position=position.assis();
  }
  
  /**
   * Change la position du passager en debout.
   * Cette méthode est appélee par un véhicule.
   */
  public void changerEnDebout(){
    this.position=position.debout();
  }


  /**
   * Cette méthode réalise le caractère à la montée du passager.
   * Elle est appelée par le client.
   *
   * @param v le véhicule dans lequel va monter le passager.
   */
  public final void monterDans(Transport b) throws TecException{// interdire aux xclasses derivee de redefinir ces methodes
     try {
        Vehicule v = (Vehicule) b;

        if (!(v instanceof Vehicule)) {
            throw new TecException("La conversion Transport/Vehicule a échoué");
        }

        choixPlaceMontee(v);
    } catch (ClassCastException e) {
        throw new TecException("La conversion Transport/Vehicule a échoué", e);
    } catch (IllegalStateException e) {
        throw new TecException("Erreur dans choixPlaceMontee", e);
    }
  }
  /**
   * Cette méthode réalise le caractère à un arrêt du passager. 
   * Elle est appelée par le véhicule dans lequel est monté le passager. 
   *
   * @param v le vehicule dans lequel se trouve le passager.
   * @param numeroArret numéro de l'arrêt courant.
   */
  public final void nouvelArret(Vehicule v, int numeroArret){
    comportement.choixPlaceArret(this, v, distanceDestination(numeroArret));
  }
  //on peut ajouter le cacrtere standard comme le caractere par defaut avec default
  protected abstract void choixPlaceMontee(Vehicule v);
  
  protected final int distanceDestination(int numeroArret){
    return this.destination - numeroArret ;
  }
  public String toString(){
    return this.nom() + this.position.toString();
  }
}
