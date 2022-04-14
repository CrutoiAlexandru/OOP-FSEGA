package exc;

public class NivelCompetentaInvalid extends Exception {
    public void printError() {
        System.out.println("Nivel sub 5");
    }
}