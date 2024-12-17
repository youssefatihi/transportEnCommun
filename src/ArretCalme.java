package tec;
class ArretCalme implements ComportementArret{


	ArretCalme( ){


		
	}

	public void choixPlaceArret(Passager p, Vehicule v, int distanceDestination){

	if (distanceDestination ==  1){
				v.arretDemanderSortie(p);
			}
	}

}