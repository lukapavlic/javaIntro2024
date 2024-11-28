import javax.json.bind.serializer.DeserializationContext;
import javax.json.bind.serializer.JsonbDeserializer;
import javax.json.stream.JsonParser;
import java.lang.reflect.Type;

public class OsebaDeserializer implements JsonbDeserializer<Oseba> {
    @Override
    public Oseba deserialize(JsonParser jsonParser,
                             DeserializationContext deserializationContext, Type type) {
        Oseba oseba = new Oseba();
        while (jsonParser.hasNext()) {
            JsonParser.Event event = jsonParser.next();
            if (event == JsonParser.Event.KEY_NAME) {
                String keyName = jsonParser.getString();
                if (keyName.equals("email")) {
                    oseba.setEmail(deserializationContext.deserialize(String.class, jsonParser));
                }
                jsonParser.next();
            }
        }
        return oseba;
    }
}