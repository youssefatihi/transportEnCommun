package tec;

class MonteeTetu extends PassagerAbstrait{
    

    MonteeTetu(String name,int destination, ComportementArret comportement ){
        super(name,destination, comportement);

    } 


    protected void choixPlaceMontee(Vehicule v){
			this.position=position.debout();
			v.monteeDemanderDebout(this);
			return;
		 

    }

}