import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Main {
    public static void main(String[] args) {
        ArrayList<Integer> U = new ArrayList<>();
        ArrayList<Integer> V = new ArrayList<>();

        U.add(1);
        U.add(2);
        U.add(3);
        V.add(4);
        V.add(5);
        V.add(6);

        ThreadProdottoScalare thProdottoScalare = new ThreadProdottoScalare(U, V);
        ThreadModulo thModU = new ThreadModulo(U);
        ThreadModulo thModV = new ThreadModulo(V);

        ExecutorService esecutore = Executors.newFixedThreadPool(3);

        try {
            Future<Integer> futureProdScalare = esecutore.submit(thProdottoScalare);
            Future<Double> futureModU = esecutore.submit(thModU);
            Future<Double> futureModV = esecutore.submit(thModV);

            //Prendo i risultati dei task
            int prodottoScalare = futureProdScalare.get();
            double modU = futureModU.get();
            double modV = futureModV.get();

            double cosAlpha = prodottoScalare / (modU * modV);


            //U*V = 32; |U| = 3.74;  |V| = 8.77;  cosAplha = 0.97;  a = 12.9
            System.out.println("Prodotto scalare (U·V): " + prodottoScalare);
            System.out.println("|U| = " + modU);
            System.out.println("|V| = " + modV);
            System.out.println("cos(a) = " + cosAlpha);
            System.out.println("a = " + Math.toDegrees(Math.acos(cosAlpha)));
        } catch (Exception e) {
            System.err.println("ERRORE: " + e.getMessage());
        } finally {
            esecutore.shutdown();
        }
    }
}