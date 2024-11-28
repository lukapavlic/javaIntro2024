import javax.json.bind.Jsonb;
import javax.json.bind.JsonbBuilder;
import javax.json.bind.JsonbConfig;
import javax.json.bind.config.BinaryDataStrategy;
import javax.json.bind.config.PropertyNamingStrategy;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;

public class JSONB {
    public void defaultMapping() {
        System.out.println("\nDefault mapping:");
        Oseba oseba = new Oseba("janez.novak@gmail.com",
                "Janez",
                "Novak",
                25);
        Jsonb jsonb = JsonbBuilder.create();

        // serializacija objekta
        String result = jsonb.toJson(oseba);
        System.out.println(result);

        // deserializacija objekta
        Oseba novaOseba = jsonb.fromJson("{" +
                "\"email\":\"nova.oseb@gmail.com\"," +
                "\"ime\": \"Nova\"," +
                "\"priimek\" : \"Oseba\"," +
                "\"starost\" : 30 }", Oseba.class);
        System.out.println(novaOseba.toString());
    }

    public void collectionsMapping(){
        System.out.println("\nSerializacija kolekcije:");
        Jsonb jsonb = JsonbBuilder.create();

        Oseba oseba1 = new Oseba("janez.novak@gmail.com", "Janez", "Novak", 18);
        Oseba oseba2 = new Oseba("john.doe@gmail.com", "John", "Doe", 20);
        Oseba oseba3 = new Oseba("jan.jansen@gmail.com", "Jan", "Jansen", 25);

        List osebe = new ArrayList();
        osebe.add(oseba1);
        osebe.add(oseba2);
        osebe.add(oseba3);

        // serializacija kolekcije
        String kolekcija = jsonb.toJson(osebe);
        System.out.println(kolekcija);

        // deserializacija kolekcije
        osebe = jsonb.fromJson(kolekcija, ArrayList.class);
        System.out.println(osebe);
    }

    public void genericCollectionsMapping(){
        System.out.println("\nSerializacija generične kolekcije:");
        Jsonb jsonb = JsonbBuilder.create();

        Oseba oseba1 = new Oseba("janez.novak@gmail.com", "Janez", "Novak", 18);
        Oseba oseba2 = new Oseba("john.doe@gmail.com", "John", "Doe", 20);
        Oseba oseba3 = new Oseba("jan.jansen@gmail.com", "Jan", "Jansen", 25);

        List<Oseba> osebe = new ArrayList<Oseba>();
        osebe.add(oseba1);
        osebe.add(oseba2);
        osebe.add(oseba3);

        // serializacija kolekcije
        String kolekcija = jsonb.toJson(osebe);
        System.out.println(kolekcija);

        // deserializacija kolekcije
        osebe = jsonb.fromJson(kolekcija, ArrayList.class);
        System.out.println(osebe);
        osebe = jsonb.fromJson(kolekcija,
                new ArrayList<Oseba>(){}.getClass().getGenericSuperclass());
        System.out.println(osebe);
    }

    public void customMapping() {
        System.out.println("\nSerializacija custom mapping:");

        JsonbConfig config = new JsonbConfig().withPropertyNamingStrategy(PropertyNamingStrategy.LOWER_CASE_WITH_DASHES);
        Jsonb jsonb = JsonbBuilder.create(config);

        OsebaCustom oseba1 = new OsebaCustom("janez.novak@gmail.com", "Janez", "Novak", 18);

        // serializacija objekta
        String result = jsonb.toJson(oseba1);
        System.out.println(result);

        // deserializacija objekta
        OsebaCustom novaOseba = jsonb.fromJson("{" +
                "\"email\":\"nova.oseb@gmail.com\"," +
                "\"ime-osebe-read\" : \"Nova\"," +
                "\"priimek-osebe\" : \"Oseba\"," +
                "\"starost\" : 30 }", OsebaCustom.class);
        System.out.println(novaOseba + "\n");

        JsonbConfig config1 = new JsonbConfig().withNullValues(true);
        Jsonb jsonb1 = JsonbBuilder.create(config1);

        RacunCustom racun1 = new RacunCustom("SI56-0000-0000-2222", new GregorianCalendar(), null);

        // serializacija objekta
        String result1 = jsonb1.toJson(racun1);
        System.out.println(result1);

        RacunCustom racun2 = new RacunCustom("SI56-0000-0000-2222", new GregorianCalendar());
        // serializacija objekta
        String result2 = jsonb1.toJson(racun2);
        System.out.println(result2);

        //konfiguracija za encoding
        JsonbConfig encodingConfig = new JsonbConfig().withBinaryDataStrategy(BinaryDataStrategy.BASE_64);
    }

    public void adapters() {
        System.out.print("\nSerializacija z adapterjem");
        JsonbConfig config_adapter = new JsonbConfig()
                .withAdapters(new OsebaAdapter())
                .withFormatting(true);
        Jsonb jsonb_adapter = JsonbBuilder.create(config_adapter);

        Oseba oseba1 = new Oseba("janez.novak@gmail.com", "Janez", "Novak", 18);

        String result = jsonb_adapter.toJson(oseba1);
        System.out.println(result);
    }

    public void SerializeDeserialize() {
        System.out.print("\nSerializacija / Deserializacija");
        JsonbConfig config = new JsonbConfig()
                .withFormatting(true)
                .withSerializers(new OsebaSerializer())
                .withDeserializers(new OsebaDeserializer());

        Jsonb jsonb = JsonbBuilder.create(config);

        Oseba oseba1 = new Oseba("janez.novak@gmail.com", "Janez", "Novak", 18);

        String result = jsonb.toJson(oseba1);
        System.out.println(result);

        Oseba novaOseba = jsonb.fromJson("{" +
                "\"email\":\"nova.oseb@gmail.com\"," +
                "\"ime\": \"Nova\"," +
                "\"priimek\" : \"Oseba\"," +
                "\"starost\" : 30 }", Oseba.class);
        System.out.println(novaOseba);
    }
}
