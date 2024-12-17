package tec;
class Tramway implements Transport, Vehicule {
    private Autobus tram;
    public Tramway( Autobus t)  {
       tram = t;
    }
    
    public void allerArretSuivant() {
        tram.allerArretSuivant();
    }

    public boolean aPlaceAssise() {
        return tram.aPlaceAssise();
    }

    public boolean aPlaceDebout() {
        return tram.aPlaceDebout();
    }

    public void monteeDemanderAssis(Passager p) {
       tram.monteeDemanderAssis(p);
    }

    public void monteeDemanderDebout(Passager p) {
       tram.monteeDemanderDebout(p);
    }

    public void arretDemanderDebout(Passager p) {
       tram.arretDemanderDebout(p);
    }

    public void arretDemanderAssis(Passager p) {
       tram.arretDemanderAssis(p);
    }

    public void arretDemanderSortie(Passager p) {
        tram.arretDemanderSortie(p);
    }

    public String toString(){
        return tram.toString(); 
    }
}


