import javax.json.Json;
import javax.json.JsonObject;
import javax.json.bind.adapter.JsonbAdapter;

public class OsebaAdapter implements JsonbAdapter<Oseba, JsonObject> {
    @Override
    public JsonObject adaptToJson(Oseba oseba) throws Exception {
        return Json.createObjectBuilder()
                .add("ime", oseba.getIme())
                .add("priimek", oseba.getPriimek())
                .build();
    }
    @Override
    public Oseba adaptFromJson(JsonObject jsonObject) throws Exception {
        Oseba oseba = new Oseba() ;
        oseba.setIme(jsonObject.getString("ime"));
        oseba.setPriimek(jsonObject.getString("priimek"));
        return oseba;
    }
}