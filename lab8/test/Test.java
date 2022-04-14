package test;

import companie.*;
import java.util.Random;
import exc.*;
import iterator.*;

public class Test {

    public static void main(String[] args) {
        Companie companie = new Companie(20);
        Random random = new Random();
        int nivel_competenta = 0;

        for(int i = 0; i < 20; i++) {
            nivel_competenta = random.nextInt(11);

            try {
                if(nivel_competenta < 5) {
                    throw new NivelCompetentaInvalid();
                }

                companie.add(random.nextInt(2), i, nivel_competenta);
            } catch (NivelCompetentaInvalid e) {
                e.printError();
            }
        }

        Iterator iterator = companie.iterator();

        while(!iterator.end()) {
            System.out.println(iterator.current() + " ");
            iterator.next();
        }
    }
}