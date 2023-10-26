package Controllers;

import Models.Beverage;
import Models.CoffeeMachineModel;
import Services.CoffeeMachineService;
import Views.CoffeeMachineView;

import java.util.HashMap;
import java.util.Map;

import com.google.gson.Gson;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Main {
    public static void main(String[] args) {
        // Simulate JSON input (replace with actual JSON input from the user)
        String jsonInput = "{\n" +
                "  \"machine\": {\n" +
                "    \"outlets\": {\n" +
                "      \"count_n\": 3\n" +
                "    },\n" +
                "    \"total_items_quantity\": {\n" +
                "      \"hot_water\": 500,\n" +
                "      \"hot_milk\": 500,\n" +
                "      \"ginger_syrup\": 100,\n" +
                "      \"sugar_syrup\": 100,\n" +
                "      \"tea_leaves_syrup\": 100\n" +
                "    },\n" +
                "    \"beverages\": {\n" +
                "      \"hot_tea\": {\n" +
                "        \"hot_water\": 200,\n" +
                "        \"hot_milk\": 100,\n" +
                "        \"ginger_syrup\": 10,\n" +
                "        \"sugar_syrup\": 10,\n" +
                "        \"tea_leaves_syrup\": 30\n" +
                "      },\n" +
                "      \"hot_coffee\": {\n" +
                "        \"hot_water\": 100,\n" +
                "        \"ginger_syrup\": 30,\n" +
                "        \"hot_milk\": 400,\n" +
                "        \"sugar_syrup\": 50,\n" +
                "        \"tea_leaves_syrup\": 30\n" +
                "      },\n" +
                "      \"black_tea\": {\n" +
                "        \"hot_water\": 300,\n" +
                "        \"ginger_syrup\": 30,\n" +
                "        \"sugar_syrup\": 50,\n" +
                "        \"tea_leaves_syrup\": 30\n" +
                "      },\n" +
                "      \"green_tea\": {\n" +
                "        \"hot_water\": 100,\n" +
                "        \"ginger_syrup\": 30,\n" +
                "        \"sugar_syrup\": 50,\n" +
                "        \"green_mixture\": 30\n" +
                "      }\n" +
                "    }\n" +
                "  }\n" +
                "}";

        // Use Gson to parse JSON input
        Gson gson = new Gson();
        CoffeeMachineModel model = gson.fromJson(jsonInput, CoffeeMachineModel.class);

        Beverage[] beverages = {
                new Beverage("hot_tea", createIngredientMap(200, 100, 10, 10, 30)),
                new Beverage("hot_coffee", createIngredientMap(100, 400, 30, 50, 30)),
                new Beverage("black_tea", createIngredientMap(300, 0, 30, 50, 30)),
                new Beverage("green_tea", createIngredientMap(100, 0, 30, 50, 30)),
                // Add more beverages as needed
        };

        CoffeeMachineView view = new CoffeeMachineView();

        String result = CoffeeMachineService.serveBeverages(model, beverages);
        view.displayMessage(result);
    }
    private static Map<String, Integer> createIngredientMap(int hotWater, int hotMilk, int gingerSyrup, int sugarSyrup, int teaLeavesSyrup) {
        Map<String, Integer> ingredients = new HashMap<>();
        ingredients.put("hot_water", hotWater);
        ingredients.put("hot_milk", hotMilk);
        ingredients.put("ginger_syrup", gingerSyrup);
        ingredients.put("sugar_syrup", sugarSyrup);
        ingredients.put("tea_leaves_syrup", teaLeavesSyrup);
        return ingredients;
    }
}
