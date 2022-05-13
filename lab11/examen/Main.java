package examen;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

interface Aeronava {
    String getDestination();

    String getClassName();
}

interface AvionFactory {
    Aeronava createAvion(String destinatie);
}

class AvionPersoane implements Aeronava {
    String destinatie;

    AvionPersoane(String destinatie) {
        this.destinatie = destinatie;
    }

    public String getDestination() {
        return destinatie;
    }

    public String getClassName() {
        return "AvionPersoane";
    }
}

class AvionCargo implements Aeronava {
    String destinatie;

    AvionCargo(String destinatie) {
        this.destinatie = destinatie;
    }

    public String getDestination() {
        return destinatie;
    }

    public String getClassName() {
        return "AvionCargo";
    }
}

class AvionPersoaneFactory implements AvionFactory {
    public Aeronava createAvion(String destinatie) {
        return new AvionPersoane(destinatie);
    }
}

class AvionCargoFactory implements AvionFactory {
    public Aeronava createAvion(String destinatie) {
        return new AvionCargo(destinatie);
    }
}

class Aeroport {
    private ArrayList<Aeronava> listaAvioane = new ArrayList<Aeronava>();

    public Aeronava getAvion(int i) {
        return listaAvioane.get(i);
    }

    public void adaugaAvion(Aeronava avion) {
        listaAvioane.add(avion);
    }

    public int nrAvioane() {
        return listaAvioane.size();
    }
}

class Client {
    Aeroport aeroport;
    boolean found = false;
    int nrDestinatii = 0;

    Client(Aeroport aeroport) {
        this.aeroport = aeroport;
    }

    public void search(String destinatie) {
        for (int i = 0; i < aeroport.nrAvioane(); i++) {
            if (destinatie.compareToIgnoreCase(aeroport.getAvion(i).getDestination()) == 0) {
                found = true;
                nrDestinatii++;
            }
        }

        try {
            if (!found) {
                throw new NoDestinationFound();
            }
            System.out.println("Nr destinatii gasite:" + nrDestinatii);
        } catch (NoDestinationFound e) {
            e.printStackTrace();
        }

    }
}

class NoDestinationFound extends Exception {
    public void printStackTrace() {
        System.out.println("No destination found!");
    }
}

public class Main {

    public static void main(String[] args) {
        Aeroport aeroport = new Aeroport();
        Client client = new Client(aeroport);
        Random rand = new Random();
        Scanner scanner = new Scanner(System.in);
        String wantedDestination;
        ArrayList<String> listaDestinatii = new ArrayList<>() {
            {
                add("Franta");
                add("Italia");
                add("Germania");
            }
        };

        System.out.println("Enter your wanted destination:");
        wantedDestination = scanner.nextLine();

        for (int i = 0; i < 20; i++) {
            if (rand.nextInt(2) == 1) {
                aeroport.adaugaAvion(new AvionCargo(listaDestinatii.get(rand.nextInt(listaDestinatii.size()))));
            } else {
                aeroport.adaugaAvion(new AvionPersoane(listaDestinatii.get(rand.nextInt(listaDestinatii.size()))));
            }
        }

        client.search(wantedDestination);

        System.out.println();

        for (int i = 0; i < aeroport.nrAvioane(); i++) {
            System.out.println(
                    i + 1 + ". " + aeroport.getAvion(i).getDestination() + "\t" + aeroport.getAvion(i).getClassName());
        }

        scanner.close();
    }
}
