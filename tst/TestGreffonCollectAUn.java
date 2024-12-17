
import tec.Usager;
import tec.FabriqueTec;
import tec.Transport;
import tec.GreffonAUn;
import tec.TecException;
import collecte.CollecteArrayList;
import collecte.CollecteFile;
import collecte.Collecte;

class TestGreffonCollectAUn{
    TestGreffonCollectAUn(){
        
    }

  static public void main (String[] args) throws TecException {
    Collecte c = new CollecteArrayList();
    GreffonAUn serenity = FabriqueTec.faireGreffonAUn(9, 9, c);

    Usager kaylee = FabriqueTec.fairePassagerStandard("Kaylee", 4);  
    Usager jayne = FabriqueTec.fairePassagerStandard("Jayne", 4);
    Usager inara = FabriqueTec.fairePassagerStandard("Inara", 5);
    Usager majid = FabriqueTec.fairePassagerStandard("Majid", 15);
    Usager abderahim = FabriqueTec.fairePassagerStandard("Abderahim", 10);

    //0
    System.out.println(serenity);
    serenity.allerArretSuivant();
    serenity.printCollect();

    //1
     kaylee.monterDans(serenity);

     System.out.println(serenity);
     System.out.println(kaylee);

    serenity.allerArretSuivant();
    serenity.printCollect();

    //2
    jayne.monterDans(serenity);


    System.out.println(serenity);
    System.out.println(kaylee);
    System.out.println(jayne);

    serenity.allerArretSuivant();
    serenity.printCollect();

    //3
    inara.monterDans(serenity);
    majid.monterDans(serenity);
    abderahim.monterDans(serenity);
    System.out.println(serenity);
    System.out.println(kaylee);
    System.out.println(jayne);
    System.out.println(inara);
    serenity.allerArretSuivant();

    serenity.printCollect();

    //4
    System.out.println(serenity);
    System.out.println(kaylee); // ce passager sort
    System.out.println(jayne); // ce passager sort
    System.out.println(inara);

    serenity.allerArretSuivant();
    serenity.printCollect();
    //5
    System.out.println(serenity);
    System.out.println(kaylee);
    System.out.println(jayne);
    System.out.println(inara);
     serenity.printCollect();

  }
}
