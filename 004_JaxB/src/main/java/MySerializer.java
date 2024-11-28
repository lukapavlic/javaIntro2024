import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Marshaller;
import jakarta.xml.bind.Unmarshaller;
import java.io.*;
import java.util.logging.Logger;

/**
 * Kontrolni razred, ki poskrbi za serializacijo in deserializacijo podatkov
 * @author Viktor
 *
 */
public class MySerializer {

    private static final String charSet= "UTF-8";

    Logger log = Logger.getLogger(MySerializer.class.getSimpleName());

    /**
     * Unmarshaling
     * @return String, ki predstavlja vsebino datoteke XML
     * @throws JAXBException
     * @throws IOException
     */
    public String deserializiraj() throws JAXBException, IOException {
        JAXBContext jaxbContext = JAXBContext.newInstance(Oseba.class);
        Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();

        // Unmarshal from InputStream
        log.info("Unmarshaling");
        InputStream inStream = MySerializer.class.getResourceAsStream("/oseba.xml");
        Oseba oseba = (Oseba) jaxbUnmarshaller.unmarshal(inStream);

        inStream.close();

        return oseba.toString();
    }

    /**
     * Marshaling
     * @param o, ki predstavlja osebo
     * @throws JAXBException
     * @throws IOException
     */
    public void serializiraj(Oseba o) throws JAXBException, IOException {
        JAXBContext jaxbContext = JAXBContext.newInstance(Oseba.class);
        Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
        jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
        jaxbMarshaller.setProperty(Marshaller.JAXB_ENCODING, charSet);

        log.info("Marshaling");
        // Marshal to file
        File output = new File("C://Users/Viktor/Desktop/osebaExport.xml");
        OutputStream os = new FileOutputStream(output);
        jaxbMarshaller.marshal(o, os);

        os.close();
    }
}
