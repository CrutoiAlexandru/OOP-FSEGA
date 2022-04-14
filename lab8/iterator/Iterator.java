package iterator;

public interface Iterator {
    boolean end();
    Object current();
    void next();
}