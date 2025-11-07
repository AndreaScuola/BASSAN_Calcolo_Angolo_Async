import java.util.ArrayList;
import java.util.concurrent.Callable;

public class ThreadModulo implements Callable<Double> {
    ArrayList<Integer> vettore;

    public ThreadModulo(ArrayList<Integer> vettore) {
        this.vettore = vettore;
    }

    public Double call(){
        double ris = 0;

        for (Integer integer : vettore)
            ris += Math.pow(integer, 2);

        return (double)Math.sqrt(ris);
    }
}
