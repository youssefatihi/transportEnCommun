package tec;
class PassagerStresse extends MonteeFatigue {
     PassagerStresse(String name, int destination){
        super(name, destination, new ArretPrudent());
        }
}