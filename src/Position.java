package tec;
/**
 * Cette classe représente la position d'un passager par rapport à un transport.
 * Une position a trois états possibles : assis dans un transport, 
 * debout dans un transport et dehors d'un transport.
 *
 * Les instances de cette classe sont des objets constants.
 *
 * @author Georgy
 * @since 2007-2019
 **/

class Position {
  private static final Position DEHORS = new Position();
  private static final Position ASSIS  = new Position();
  private static final Position DEBOUT = new Position();

  public static Position createPosition(){
    return DEHORS;
 }
  /**
   * construit une l'instance dans la position dehors.
   * 
   */
  private  Position(){
  }


  /**
   * La position est-elle dehors ?
   *
   * @return vrai si l'état de l'instance est dehors;
   */
  public boolean estDehors() {
    return this == DEHORS;
  }

  /**
   * La position est-elle assis ?
   *
   * @return vrai si l'état de l'instance est assis;
   */
  public boolean estAssis() {
    return this == ASSIS;
  }

  /**
   * La position est-elle debout ?
   *
   * @return vrai si l'état de l'instance est debout;
   */
  public boolean estDebout() {
    return this == DEBOUT;
  }

  /**
   * La position est-elle assis ou debout ?
   *
   * @return vrai la position est assis ou debout.
   */
  public boolean estInterieur() {
    return this != DEHORS;
  }


  /**
   * Retourne une instance de Position assis.
   *
   * @return instance dans l'état assis.
   */
  public Position assis() {
    return ASSIS; 
  }

  /**
   * Retourne une instance de Position debout.
   *
   * @return instance dans l'état debout.
   */
  public Position debout() {
    return DEBOUT;
  }

  /**
   * Retourne une instance de Position dehors.
   *
   * @return instance dans l'état dehors.
   */
  public Position dehors() {
    return DEHORS;
  }

  /**
   * Cette méthode est héritée de la classe {@link java.lang.Object}.
   * Très utile pour le débogage, elle permet de fournir une 
   * chaîne de caractères correspondant à l'état d'un objet.
   * Mais, il faut adapter son code à chaque classe.
   */
  @Override
  public String toString() {
    String nom = null;
    /*we can'tuse the switch anymore because the actual type of position is "this", 
    but its not constant */
    if (this.estAssis()) nom = "assis";
    else if (this.estDebout()) nom = "debout";
    else nom = "endehors";
    return "<" + nom + ">";
  }
}
