package threadSignal.java8;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import java.util.Optional;

public class JsonObjectTest {
    static Gson gson = new Gson();
    static String userJson = "{\"data\":{\"node\":true}}";
    private static final String DATA = "data";


    public static void main(String[] args) {
        String deleteEntityStr = "node";
        JsonObject jsonObject = gson.fromJson(userJson, JsonObject.class);
        boolean isSuccess = Optional.ofNullable(jsonObject)
                .map(o -> o.get(DATA))
                .map(JsonElement::getAsJsonObject)
                .map(o -> o.get(deleteEntityStr))
                .filter(r -> !r.isJsonNull() && r.getAsBoolean())
                .isPresent();
        System.out.println(isSuccess);
    }
}
