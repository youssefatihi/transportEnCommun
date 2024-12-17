package tec;
import java.lang.reflect.Method;
public class LancerTests {

    static private void lancer(Class<?> c) throws Exception {
        int testsValides = 0;

        for (Method method : c.getMethods()) {
            if (method.getName().startsWith("test")) {
                try {
                    Object instance = c.getDeclaredConstructor().newInstance();
                    method.invoke(instance);
                    System.out.print(".");
                    testsValides++;
                } catch (Exception e) {
                    // Gérer l'exception (peut-être logguer ou compter les erreurs)
                }
            }
        }

        System.out.println("\nOK avec " + testsValides + " tests valides.");
    }

    static public void main(String[] args) throws Exception {
        assert args.length > 0 : "Aucune classe de test spécifiée.";
        int testsValidesTotal = 0;

        for (String className : args) {
            // System.out.println(className);
            try {
                Class<?> c = Class.forName(className);
                Method mainMethod = c.getMethod("main", String[].class);
                mainMethod.invoke(null, (Object) new String[0]);
                // Exécuter les tests
                lancer(c);
            } catch (ClassNotFoundException e) {
                System.err.println("La classe de test '" + className + "' n'a pas pu être trouvée.");
            } catch (Exception e) {
                System.err.println("Une exception s'est produite lors de l'exécution des tests : " + e);
            }
        }
    }
}
