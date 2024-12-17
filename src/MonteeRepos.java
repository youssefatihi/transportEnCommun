package tec;

class MonteeRepos extends PassagerAbstrait{


    MonteeRepos(String name,int destination, ComportementArret comportement ){
        super(name,destination, comportement);

    } 


    protected  void choixPlaceMontee(Vehicule v){
		  	if(v.aPlaceAssise()){
			this.position=position.assis();
			v.monteeDemanderAssis(this);
			return;
		}
		else if(v.aPlaceDebout()) {
			this.position=position.debout();
			v.monteeDemanderDebout(this);
            return ;
		}
        else 
        return ;
    }

}