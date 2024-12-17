
package tec;

class MonteeSportif extends PassagerAbstrait{


    MonteeSportif(String name,int destination, ComportementArret comportement ){
        super(name,destination, comportement);

    } 



    protected  void choixPlaceMontee(Vehicule v){
       	if(v.aPlaceDebout()){
			this.position=position.debout();
			v.monteeDemanderDebout(this);
			return;
		}
		else ;

    }
}