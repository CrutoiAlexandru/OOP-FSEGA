package package3;

import package2.*;
import package1.*;

public class Masina extends Vehicul {
    public static void main(String[] args) {
        Masina masina = new Masina();

        Functii functiiMasina = masina.functii();

        functiiMasina.accelereaza();
    }
}