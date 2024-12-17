
import tec.Usager;
import tec.FabriqueTec;
import tec.Transport;
import tec.GreffonEstUn;
import tec.TecException;
import collecte.CollecteArrayList;
import collecte.CollecteFile;
import tec.GreffonTransportPlein;
class TestGreffonTransportPlein {

  /*
   * Affiche l'etat des deux instances passees en parametre.
   * La methode println(Object x) de la classe PrintWriter 
   * declenche la methode toString() sur l'objet passe 
   * en parametre (x.toString()) et affiche la chaine 
   * de caracteres obtenue..
   */
  static private void deboguerEtat (Transport t, Usager p) {
    System.out.println(p);
    System.out.println(t);
  }
  

  static public void main (String[] args) throws TecException {
    GreffonTransportPlein serenity = FabriqueTec.GreffonTransportPlein(1, 1,new CollecteArrayList());

    Usager kaylee = FabriqueTec.fairePassagerStandard("Kaylee", 4);  
    Usager jayne = FabriqueTec.fairePassagerStandard("Jayne", 4);
    Usager inara = FabriqueTec.fairePassagerStandard("Inara", 5);

    //0
    System.out.println(serenity);
    serenity.allerArretSuivant();
    
    //1
     kaylee.monterDans(serenity);
     GreffonTransportPlein.getCollecte().toString();
     System.out.println(serenity);
     System.out.println(kaylee);

    serenity.allerArretSuivant();
    //2
    jayne.monterDans(serenity);
    GreffonTransportPlein.getCollecte().toString();
  
    
    System.out.println(serenity);
    System.out.println(kaylee);
    System.out.println(jayne);

    serenity.allerArretSuivant();
    //3
    inara.monterDans(serenity);
    GreffonTransportPlein.getCollecte().toString();
    System.out.println(serenity);
    System.out.println(kaylee);
    System.out.println(jayne);
    System.out.println(inara);

    serenity.allerArretSuivant();
    //4
    System.out.println(serenity);
    System.out.println(kaylee);
    System.out.println(jayne);
    System.out.println(inara);
    GreffonTransportPlein.getCollecte().toString();
    serenity.allerArretSuivant();
    //5
    System.out.println(serenity);
    System.out.println(kaylee);
    System.out.println(jayne);
    System.out.println(inara);
  }
}
