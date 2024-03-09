package sandwich.typesOfSandwiches;

import sandwich.components.Cheese;
import sandwich.components.Ham;
import sandwich.components.Salami;
import sandwich.components.Sous;

public class BMT {
    private final Salami salami;
    private Cheese cheese;
    private Ham ham;
    private Sous sous;

    public BMT(Salami salami, Cheese cheese, Ham ham, Sous sous) {
        this.salami = salami;
        this.cheese = cheese;
        this.ham = ham;
        this.sous = sous;
        System.out.println("Сэндвич приготовлен");
    }
}
