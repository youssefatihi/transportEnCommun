package tec;
class ArretNerveux implements ComportementArret{

	ArretNerveux(){

	}

	public void choixPlaceArret(Passager p, Vehicule v, int distanceDestination){

		if(distanceDestination >  1 ){
				if(p.estAssis()) p.changerEnDebout();
				else if (p.estDebout()) p.changerEnAssis();
				else;
			}


		if (distanceDestination ==  1){
				v.arretDemanderSortie(p);
			}


		}
}