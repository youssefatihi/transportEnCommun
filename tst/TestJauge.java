package tec;
class TestJauge {
    public  void testDansIntervalle(){
        // test pour des valeurs negatives 
        Jauge j = new Jauge(40, -1);
        assert (j.estVert() == false ): "TEST  testDansIntervalle 1 FAILED";
        // test pour des valeurs dans l'intervalle
        j = new Jauge(40,6);
        assert (j.estVert() == true ): "TEST  testDansIntervalle  2 FAILED";
        // test pour des valeurs au dessus de l'intervalle, il y a une erreur 
        j = new Jauge(20,20);
        assert (j.estVert() == false ): "TEST  testDansIntervalle  3 FAILED";
    }
    public  void testHorsIntervalle(){
        // pour une valeur dans l'intervalle
        Jauge j = new Jauge(40, 5);
        assert (j.estRouge() == false) : "TEST  testHorsIntervalle 1 FAILED";
        // pour la valeurs max 
        j = new Jauge(40, 40);
        assert (j.estRouge() == true) : "TEST  testHorsIntervalle 2 FAILED";

        //pour les valeurs au dessus de max
        j = new Jauge(40, 60);
        assert (j.estRouge() == true) : "TEST  testHorsIntervalle 3 FAILED";

        //pour les valeurs negatives
        j = new Jauge(40, -2);
        assert (j.estRouge() == false) : "TEST  testHorsIntervalle  4 FAILED";
    }
    public  void testIncrementer(){
        // pour la valeur max - 1
        Jauge j = new Jauge(40, 39);
        j.incrementer();
        assert ( j.estVert() == false) : "TEST  testIncrementer  1 FAILED";
        assert ( j.estRouge() == true) : "TEST  testIncrementer  2 FAILED";
        
        //pour une valeur dans le milieu de l'intervalle
        j = new Jauge(40, 4 );
        j.incrementer();
        assert (j.estVert() == true ): "TEST  testIncrementer 3 FAILED";

        // pour la valeur extreme -1
        j = new Jauge(40,-1 );
        j.incrementer();
        assert (j.estVert() == true ): "TEST  testIncrementer 4 FAILED";

    }
    public  void testDecrementer(){
        Jauge j = new Jauge(40, 40);
        j.decrementer();
        assert (j.estVert() == true ) : "TEST  testDecrementer 1  FAILED";

        j = new Jauge(40, 0);
        j.decrementer();
        assert (j.estVert() == false) : "TEST  testDecrementer 2 FAILED";

        j = new Jauge(40, 6);
        j.decrementer();
        assert (j.estVert() == true) : "TEST  testDecrementer 2 FAILED";
    }
    public void testExceptionCasLimite () {
        try {
            Jauge inverse = new Jauge (-42 , 10) ;
            // Si aucune exception n'est levée, le test doit échouer
            assert false : "Exception non levée";
        } catch (IllegalArgumentException e) {
            // L'exception a été levée, ce qui est le comportement attendu
        }
    }
    public static void main(String[] args){
        boolean estMisAssertion = false;
        assert (estMisAssertion = true);
        if (!estMisAssertion) {
            System.out.println("Execution impossible sans l'option -ea");
            return;
        }
        TestJauge t = new TestJauge();
        t.testDansIntervalle();
        
        t = new TestJauge();
        t.testHorsIntervalle();

        t = new TestJauge();
        t.testDecrementer();

        t = new TestJauge();
        t.testIncrementer();
        t.testExceptionCasLimite();
        System.out.println(" (3):OK: tec.TestJauge");

        return;
    }
}

