package utilities;

import Models.CoffeeMachineModel;
import com.google.gson.Gson;

public class JSONParser {
    private static final Gson gson = new Gson();

    public static CoffeeMachineModel parseCoffeeMachineModelFromJSON(String jsonInput) {
        return gson.fromJson(jsonInput, CoffeeMachineModel.class);
    }
}
