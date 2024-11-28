package si.um.feri.simpleStream;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Stream {

    public static void main(String[] args) {

        List<String> besede = List.of("to", "je", "samo", "test", "to", "je", "samo", "preprost", "test", "konec");

        //S kolekcijami
        Set<String> besedeSet = new HashSet<>(besede);
        List<String> izbor = new ArrayList<>();
        for (String s : besedeSet)
            if (s.length() >= 4)
                izbor.add(s);
        System.out.println(String.format("Kolekcija ima %d različne besede, ki imajo 4 ali več znakov.", izbor.size()));

        //Stream
        long count = besede.stream().distinct().filter(word -> word.length() >= 4).count();
        System.out.println(String.format("Kolekcija ima %d različne besede, ki imajo 4 ali več znakov.", count));
    }

} 