
package tec;
import collecte.Collecte;
public final class FabriqueTec{

    private FabriqueTec(){

    }  

    // pour l instant on ajoute un constructeur pour chaque type de passager
    // sinon il faut passer une classe intermediare
    public static Usager fairePassagerStandard(String nom,int destination){
        if(destination < 0) 
        throw new IllegalArgumentException("valeur negative pour la destination");
        return new PassagerStandard(nom, destination);
    }
    public static Usager fairePassagerStresse(String nom,int destination){
        if(destination < 0) 
        throw new IllegalArgumentException("valeur negative pour la destination");
        return new PassagerStresse(nom, destination);
    }
    public static Usager fairePassagerIndecis(String nom,int destination){
        if(destination < 0) 
        throw new IllegalArgumentException("valeur negative pour la destination");
        return new PassagerIndecis(nom, destination);
    }
    
    public static Transport faireAutobus(int nbPlaceAssise, int nbPlaceDebout){
        return new Autobus(nbPlaceAssise, nbPlaceDebout);

    }
    public static Transport faireTramway(int nbPlaceAssise, int nbPlaceDebout){
        return new Tramway(new Autobus(nbPlaceAssise, nbPlaceDebout));
    }

    public static GreffonEstUn faireGreffonEstUn(int nbPlaceAssise, int nbPlaceDebout, Collecte c) {
        return new GreffonEstUn(nbPlaceAssise, nbPlaceDebout, c);
    }
    public static GreffonAUn faireGreffonAUn(int nbPlaceAssise, int nbPlaceDebout, Collecte c) {
        return new GreffonAUn(c, new Autobus(nbPlaceAssise, nbPlaceDebout));
    }
    public static GreffonTransportPlein GreffonTransportPlein(int nbPlaceAssise, int nbPlaceDebout, Collecte type) {
        return new GreffonTransportPlein(nbPlaceAssise, nbPlaceDebout, type);
    }
}
