package package2;

import package1.*;

public class Vehicul {
    private class VehiculFunctii implements Functii {
        private int viteza = 0;
        
        public void accelereaza() {
            viteza++;
            System.out.println(viteza);
        }
    }

    public Functii functii() {
        return new VehiculFunctii();
    }
}