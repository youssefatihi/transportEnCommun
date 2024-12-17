package tec;

class PassagerGreffon implements Passager  {

    private Vehicule Greffon;
    private Passager passager; 

    public PassagerGreffon(Passager p, Vehicule type ){
            passager=p;
            Greffon=type;
    }

    public String nom(){
        return passager.nom();
    }

    public boolean estDehors(){
    return passager.estDehors();
    }

    public boolean estAssis(){
        return passager.estAssis();
    }

    public boolean estDebout(){
        return passager.estDebout();
    }

    public void changerEnDehors(){
        passager.changerEnDebout();
    }

    public void changerEnAssis(){
        passager.changerEnAssis();
    }


    public void changerEnDebout(){
        passager.changerEnDebout();
    }


    public void nouvelArret(Vehicule v, int numeroArret){
            PassagerAbstrait pa = (PassagerAbstrait) passager; 
            if (pa.distanceDestination( numeroArret)==0) {
                ((Vehicule) Greffon).arretDemanderSortie(this);
            }
        
        else{
        passager.nouvelArret(Greffon,numeroArret);
        }
    }


}


