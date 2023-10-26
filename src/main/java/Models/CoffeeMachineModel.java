package Models;

import java.util.Map;

public class CoffeeMachineModel {
    private int numOutlets;
    private Map<String, Integer> availableIngredients;

    public CoffeeMachineModel(int numOutlets, Map<String, Integer> availableIngredients) {
        this.numOutlets = numOutlets;
        this.availableIngredients = availableIngredients;
    }

    public int getNumOutlets() {
        return numOutlets;
    }

    public Map<String, Integer> getAvailableIngredients() {
        return availableIngredients;
    }
}

