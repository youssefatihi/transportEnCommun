
package collecte;
import java.io.*;

public class CollecteFile implements Collecte {

    private int[] counter = {0, 0, 0};
    private String fileName;
    public CollecteFile(String fileName) {
        this.fileName = fileName;

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, true))) {
            // true en tant que deuxième argument pour FileWriter indique d'append (ajouter) au fichier existant
            writer.write("NombrePersonnesEntrees,NombrePersonnesSorties,NumeroArret\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void uneEntree() {
        counter[0]++;
    }

    public void uneSortie() {
        counter[1]++;
    }

    public void changerArret() {
        counter[2]++;
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, true))) {
            writer.write("[ nb_montee: " + counter[0] + ", nb_sortis: " + counter[1] + ", numero_arret: "+ counter[0] +"]"+"\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
        counter = generateCounter();
    }

    private int[] generateCounter() {
        int [] t=new int[3];
        t[2]=counter[2];
        return t;
    }
    public String toString(){
        String s = "";
        try (BufferedReader br = new BufferedReader(new FileReader(this.fileName))) {
            String ligne;
            while ((ligne = br.readLine()) != null) {
                s+= (String) ligne + "\n";
            }
        } catch (IOException e) {
            e.printStackTrace();
    }
        return s;     
    }
}
