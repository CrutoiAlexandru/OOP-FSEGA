import java.util.Scanner;

interface Operatie {
    float calculeaza(float x, float y);
}

abstract class OperatieAritmetica implements Operatie {
    @Override
    public abstract float calculeaza(float x, float y);
}

class OperatieAdunare extends OperatieAritmetica {
    @Override
    public float calculeaza(float x, float y) {
        return x + y;
    }
}

class OperatieScadere extends OperatieAritmetica {
    @Override
    public float calculeaza(float x, float y) {
        return x - y;
    }
}

class OperatieInmultire extends OperatieAritmetica {
    @Override
    public float calculeaza(float x, float y) {
        return x * y;
    }
}

class Calculator {
    void executaOperatie(float x, float y, Operatie op) {
        System.out.println(op.calculeaza(x, y));
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Calculator calculator = new Calculator();

        String c = in.nextLine();

        float x = in.nextFloat();
        float y = in.nextFloat();

        switch (c) {
            case "+":
                calculator.executaOperatie(x, y, new OperatieAdunare());
                break;
            case "-":
                calculator.executaOperatie(x, y, new OperatieScadere());
                break;
            case "*":
                calculator.executaOperatie(x, y, new OperatieInmultire());
                break;
            default:
                System.out.println("Operatie gresita!");
                c = in.nextLine();
        }

        in.close();
    }
}