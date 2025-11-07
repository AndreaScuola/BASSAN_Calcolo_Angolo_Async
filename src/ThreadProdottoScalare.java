import java.util.ArrayList;
import java.util.concurrent.Callable;

public class ThreadProdottoScalare implements Callable<Integer> {
    ArrayList<Integer> U;
    ArrayList<Integer> V;

    ThreadProdottoScalare(ArrayList<Integer> U, ArrayList<Integer> V) {
        this.U = U;
        this.V = V;
    }

    @Override
    public Integer call() throws Exception {
        int ris = 0;

        for (int i = 0; i < U.size(); i++)
            ris += U.get(i) * V.get(i);

        return ris;
    }
}
