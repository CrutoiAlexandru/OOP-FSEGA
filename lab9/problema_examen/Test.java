package problema_examen;

import java.util.ArrayList;
import java.util.Random;

class Produs {
    int cod_unic;
    int pret;

    Produs(int cod_unic, int pret) {
        this.cod_unic = cod_unic;
        this.pret = pret;
    }
}

class Colet {
    private ArrayList<Produs> lista_produse = new ArrayList<Produs>();

    public void addProduct(int cod_unic, int pret) {
        lista_produse.add(new Produs(cod_unic, pret));
    }

    void state() {
    }
}

class ColetComandat extends Colet {
    void state() {
        System.out.println("Colet comandat");
    }
}

class ColetExpediat extends Colet {
    void state() {
        System.out.println("Colet expediat");
    }
}

class Comanda {
    private Colet colet = new ColetComandat();
    private int nr_comanda;

    Comanda(int nr_comanda) {
        this.nr_comanda = nr_comanda;
    }

    public void addProduct(int cod_unic, int pret) {
        colet.addProduct(cod_unic, pret);
    }

    public void process() {
        System.out.println("Procesare colet");
        colet = new ColetExpediat();
    }

    public void state() {
        colet.state();
    }
}

public class Test {
    public static void main(String[] args) {
        Random random = new Random();
        Comanda comanda = new Comanda(random.nextInt(100));

        for (int i = 0; i < 10; i++) {
            comanda.addProduct(random.nextInt(100), random.nextInt(100));
        }

        comanda.state();

        comanda.process();

        comanda.state();
    }
}
