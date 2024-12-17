package tec;
class TestPosition {
    
    public static void main (String[] args){
        boolean estMisAssertion = false;
        assert estMisAssertion = true;

        if (!estMisAssertion) {
        System.out.println("Execution impossible sans l'option -ea");
        return;
        }
        TestPosition testAssis =new TestPosition();
        testAssis.testEstAssis();
        TestPosition testDebout =new TestPosition();
        testDebout.testEstDebout();
        TestPosition testDehors = new TestPosition();
    	testDehors.TestEstDehors();
    	TestPosition testInterieur = new TestPosition();
    	testInterieur.TestEstinterieur();
        TestPosition debout = new TestPosition();
        debout.TestDebout();
        TestPosition Dehors = new TestPosition();
        Dehors.TestDehors();
        TestPosition Assis = new TestPosition();
        Assis.TestAssis();
        System.out.println("(7) ok : tec.TestPosition");

    }


    public void testEstAssis(){
         Position instance = Position.createPosition();
         assert  (instance.estAssis() == false) : "le test estAssis est passé pour le cas de la position dehors";
    }
    public void testEstDebout(){
         Position instance = Position.createPosition();
         assert (instance.estDebout() == false) : "le test estDebout est passé pour le cas de la position dehors";
    }

     public void TestEstDehors(){
        Position instance = Position.createPosition();
        assert ( instance.estDehors() == true ) : "le test estDehors est passé pour le cas de la position dehors"; 
    }
    public void TestEstinterieur(){
        Position instance = Position.createPosition();
        assert ( instance.estInterieur() == false ) : "le test estInterieur est passé pour le cas de la position dehors";
    }

    public void TestDebout(){
        Position pos1 = Position.createPosition();
        assert(pos1.debout().estInterieur() == true );
        assert(pos1.debout().estAssis() == false );
      //  assert(pos1.debout().estDebout() == true );
        assert (pos1.debout().estDehors() == false ) : "le test estDebout sur sur l'instance envoyée par debout est faux ";
    }
    public void TestDehors(){
        Position pos1 = Position.createPosition();
       // assert(pos1.dehors().estInterieur() == false );
        assert (pos1.dehors().estAssis() == false );
        assert (pos1.dehors().estDebout() == false ) : "les deux tests estDehors et estInterieur sur l'instance envoyée par debhors sont faux";
       // assert(pos1.dehors().estDehors() == true );
    }   

     public void TestAssis(){
        Position pos1 = Position.createPosition();
        assert(pos1.assis().estInterieur() == true );
        assert(pos1.assis().estAssis() == true );
        //assert(pos1.assis().estDebout() == false );
        assert (pos1.assis().estDehors() == false ) : "le test estDebout sur l'instance envoyée par assis() est faux  ";
    }



}
