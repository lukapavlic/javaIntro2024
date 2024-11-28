import jakarta.xml.bind.JAXBException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class JAXB {
    public void serialize() {
        MySerializer serializer = new MySerializer();
        String izXML = "";

        Oseba o = new Oseba();
        o.setIme("Viktor");
        o.setPriimek("Taneski");
        o.setStarost(31);
        o.setNaslov("Kardeljeva cesta 57");
        o.setKomitent(false);
        List<String> iBan = new ArrayList<String>();
        iBan.add("SI56-0000-0000-1111");
        iBan.add("SI56-0000-0000-2222");
        o.setiBan(iBan);
        try {
            serializer.serializiraj(o);
        } catch (IOException | JAXBException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public void deserialize() {
        MySerializer serializer = new MySerializer();
        String izXML = "";
        try {
            izXML = serializer.deserializiraj();
        } catch (IOException | JAXBException e) {
            e.printStackTrace();
        }

        System.out.println(izXML);
    }
}
