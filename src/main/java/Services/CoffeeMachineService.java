package Services;

import Models.Beverage;
import Models.CoffeeMachineModel;

import java.util.Map;

public class CoffeeMachineService {
    public static String serveBeverages(CoffeeMachineModel model, Beverage[] beverages) {
        int numOutlets = model.getNumOutlets();
        Map<String, Integer> availableIngredients = model.getAvailableIngredients();
        StringBuilder result = new StringBuilder();

        if (beverages.length == 0) {
            result.append("No beverages available.");
        } else {
            for (int i = 0; i < Math.min(numOutlets, beverages.length); i++) {
                String preparationResult = makeBeverage(beverages[i], availableIngredients);
                result.append("Outlet ").append(i + 1).append(": ").append(preparationResult).append("\n");
            }
        }

        return result.toString();
    }

    private static String makeBeverage(Beverage beverage, Map<String, Integer> availableIngredients) {
        Map<String, Integer> requiredIngredients = beverage.getIngredients();
        StringBuilder message = new StringBuilder(beverage.getName() + ": ");

        for (Map.Entry<String, Integer> entry : requiredIngredients.entrySet()) {
            String ingredientName = entry.getKey();
            int requiredQuantity = entry.getValue();

            if (!availableIngredients.containsKey(ingredientName) || availableIngredients.get(ingredientName) < requiredQuantity) {
                return "Ingredient insufficient: " + ingredientName;
            }

            availableIngredients.put(ingredientName, availableIngredients.get(ingredientName) - requiredQuantity);
            message.append(ingredientName).append(" used, ");
        }

        return message.toString() + "prepared.";
    }
}

