package tec;

class MonteeFatigue extends PassagerAbstrait{


    MonteeFatigue(String name,int destination, ComportementArret comportement ){
        super(name,destination, comportement);
    } 

    protected  void choixPlaceMontee(Vehicule v){
       	if(v.aPlaceAssise()){
			this.position=position.assis();
			v.monteeDemanderAssis(this);
			return;
		}
		else ;
    }

}