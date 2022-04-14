package companie;

import om.*;
import selector.*;

public class Companie {
    private Persoana[] persoane;
    private int next = 0;

    public Companie(int size) {
        persoane = new Persoana[size];
    }

    public void add(int tip, int i, int nivel_competenta) {
        if (tip == 0) {
            persoane[next++] = new Muncitor("N" + i, "P" + i, nivel_competenta);
        } else {
            persoane[next++] = new Vanzator("N" + i, "P" + i, nivel_competenta);
        }
    }

    private class CompanieSelector implements Selector {
        private int i = 0;

        public boolean end() {
            return i == persoane.length;
        }

        public Object current() {
            return persoane[i];
        }

        public void next() {
            if (i < persoane.length)
                i++;
        }
    }

    public Selector selector() {
        return new CompanieSelector();
    }
}