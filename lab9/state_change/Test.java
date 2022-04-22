package state_change;

class Weather {
    public void now() {
    }
}

class SunnyWeather extends Weather {
    public void now() {
        System.out.println("soare");
    }
}

class CloudyWeather extends Weather {
    public void now() {
        System.out.println("innorat");
    }
}

class RainyWeather extends Weather {
    public void now() {
        System.out.println("ploua");
    }
}

class Forecast {
    private Weather vreme = new SunnyWeather();

    void changeToCloudy() {
        vreme = new CloudyWeather();
    }

    void changeToRainy() {
        vreme = new RainyWeather();
    }

    void now() {
        vreme.now();
    }
}

public class Test {
    public static void main(String[] args) {
        Forecast prognoza = new Forecast();

        prognoza.now();

        prognoza.changeToCloudy();
        prognoza.now();

        prognoza.changeToRainy();
        prognoza.now();
    }
}