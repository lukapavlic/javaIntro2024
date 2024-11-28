import javax.json.bind.serializer.JsonbSerializer;
import javax.json.bind.serializer.SerializationContext;
import javax.json.stream.JsonGenerator;

public class OsebaSerializer implements JsonbSerializer<Oseba> {
    public void serialize(Oseba oseba, JsonGenerator jsonGenerator,
                          SerializationContext serializationContext) {
        if (oseba != null) {
            jsonGenerator.writeStartObject();
            jsonGenerator.write("ime", oseba.getIme());
            jsonGenerator.write("priimek", oseba.getPriimek());
            jsonGenerator.writeEnd();
        } else {
            serializationContext.serialize(null, jsonGenerator);
        }
    }
}
