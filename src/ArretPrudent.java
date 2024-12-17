package tec;

class ArretPrudent implements ComportementArret{

    ArretPrudent(){
    }

    public void choixPlaceArret(Passager p, Vehicule v, int distanceDestination){
        if(distanceDestination>=4)
            p.changerEnAssis();
        else if(distanceDestination<=3)
            p.changerEnDebout();
        if(distanceDestination==1)
            v.arretDemanderSortie(p);    
    }


}