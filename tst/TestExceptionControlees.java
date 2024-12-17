package tec;
class TestExceptionControlees{

  public static void main (String[] args) {
    boolean estMisAssertion = false;
    assert estMisAssertion = true;

    if (!estMisAssertion) {
      System.out.println("Execution impossible sans l'option -ea");
      return;
    }

    int nbTest = 0;
    System.out.print('.'); nbTest++;
 

  //   //********* Verifier changement d'etat **************

     System.out.print('.'); nbTest++;
 

     System.out.println("(" + nbTest + "):OK: " + "tec.TestArret"); 
  // }
  }
    
  public void testConversionVehicule() throws TecException {
    Transport serenity = (Transport) FabriqueTec.faireAutobus(1, 2);

    Usager kaylee = FabriqueTec.fairePassagerStandard("Kaylee", 4);  
    Usager jayne = FabriqueTec.fairePassagerStandard("Jayne", 4);
    Usager inara = FabriqueTec.fairePassagerStandard("Inara", 5);

    //0
//    try{
//         kaylee.monterDans(jayne);
//    }catch ( TecException e){

//    }
    
  }

}