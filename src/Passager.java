package tec;
/**
 * Cette interface fixe/définit/spécifie les services d'un passager
 * qui va être pris en charge par un véhicule.
 * Elle précise les interactions avec l'interface Vehicule. 
 *
 * <p>
 * Un passager posséde un nom et une destination (un mumero d'arret). 
 * Il possède un comportement à la montée et un comportement à chaque arrêt. 
 * Quand un passager arrive a son arrêt de destination, il sort du véhicule.
 *
 * <p>
 * Dans un véhicule, un passager est forcément soit assis, soit debout. 
 * S'il n'est ni assis, ni debout, il est forcement dehors. 
 * Quand un passager est crée, il est dans la position dehors.
 * 
 * <p>
 * Les méthodes changerEnAssis(), changerEnDebout(), accepterSortie() 
 * modifie la position d'un passager. 
 *
 * <p>
 * Le client déclenche la montée du passager dans un véhicule par la méthode
 * monterDans(). 
 * Si le véhicule accepte la demande, il déclenche un des 
 * méthodes qui modifient la position du passager.
 *
 * <p>
 * A chaque arrêt, la méthode nouvelArret() est appelée par un véhicule.
 * Le passager peut choisir de changer de place ou de sortir du bus.
 * Si le véhicule accepte la demande, il déclenche un des 
 * méthodes qui modifient la position du passager.
 */
 interface Passager {
  /**
   * fournit le nom de du passager.
   */
   String nom();
  /**
   * Le passager est-il en dehors d'un véhicule ?
   * @return vrai si la position du passager est dehors.
   */
   boolean estDehors();
  
  /**
   * Le passager est-il assis dans un véhicule ?
   * @return vrai si la position du passager est assis.
   */
     boolean estAssis();
  
  /**
   * Le passager est-il debout dans un véhicule?
   * @return vrai si la position du passager est debout.
   */
     boolean estDebout();
  
  /**
   * Change la position du passager en dehors.
   * Cette méthode est appélee par un véhicule.
   */
     void changerEnDehors();
  
  /**
   * Change la position du passager en assis. 
   * Cette méthode est appélee par un véhicule.
   */
     void changerEnAssis();
  
  /**
   * Change la position du passager en debout.
   * Cette méthode est appélee par un véhicule.
   */
     void changerEnDebout();

  /**
   * Cette méthode réalise le caractère à un arrêt du passager. 
   * Elle est appelée par le véhicule dans lequel est monté le passager. 
   *
   * @param v le vehicule dans lequel se trouve le passager.
   * @param numeroArret numéro de l'arrêt courant.
   */
    void nouvelArret(Vehicule v, int numeroArret);
}

