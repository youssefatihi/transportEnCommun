package tec;
class PassagerStandard extends MonteeRepos  {
	 PassagerStandard(String name, int destination){
		super(name, destination, new ArretCalme());
	}
}
