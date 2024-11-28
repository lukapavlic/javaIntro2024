package si.um.feri.create;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CreateStream {

	public static void main(String[] args) {

		/*
		 * Ustvarjanje streamov: - najpogosteje iz kolekcij -> collection interface
		 * ponuja metodo stream() - stream() ustvari in vrne tok, ki je v navezi s
		 * kolekcijo
		 * 
		 * - razred Array ima metodo za ustvarjanje toka iz polja
		 * 
		 * - razred Stream ima več načino kako ustvariti tok
		 */

		// tok iz kolekcije
		System.out.println("Tok iz kolekcije");

		List<Widget> objekti = getWidgets();

		objekti.stream() // uporaba metode stream()
				.filter(w -> w.isReady()).forEach(w -> w.execute());

		System.out.println();

		// tok iz polja
		System.out.println("Tok iz polja");

		String[] besede = new String[] { "to", "je", "test", "tok", "iz", "polja" };

		List<String> upper = Arrays.stream(besede) // stream() iz razreda Array
				.map(b -> b.toUpperCase()) // vmesna operacija, ki spremeni obstoječe stringe v same velike črke
				.collect(Collectors.toList()); // končna operacija -> zberemo vse stringe v cevovodu v novo kolekcijo
												// upper

		System.out.println("Same velike črke: " + upper);

		System.out.println();

		// kadar nimamo obstoječe kolekcije ali polja uporabimo metode iz razreda Stream
		// Stream.of
		System.out.println("Tok iz Stream.of");

		Stream<Integer> intStream = Stream.of(0, 1, 1, 2, 3, 5, 8, 13, 21, 34); // uporaba Stream.of
		intStream.limit(5).forEach(System.out::println);

		System.out.println();

		// Stream.builder()
		System.out.println("Tok iz Stream.builder");

		Stream.Builder<Double> builder = Stream.<Double>builder();

		Stream<Double> decimals = builder.add(2.1).add(4.9).add(8.5).build(); // z add dodamo vse item-e, ki jih želimo
																				// v toku -> build() - zgradimo tok

		int sum = decimals.mapToInt(d -> (int) Math.round(d)) // vmesna operacija
				.sum(); // končna operacija
		System.out.println("Seštevek: " + sum);

		System.out.println();

		// gradnja posebnega neskončnega toka -> Stream.iterate()
		System.out.println("Tok iz Stream.iterate");

		Stream<Integer> infiniteStream = Stream.iterate(10, n -> n + 1); // dva vhodna parametra -> začetek in lambda
																			// (kako nadaljevati zaporedje)

		int sumInfinite = infiniteStream // seštejemo števila od 10 do 19
				.limit(10).mapToInt(i -> i).sum();
		System.out.println("Seštevek iz neskončnega toka: " + sumInfinite);

		System.out.println();

		// gradnja posebnega neskončnega toka -> Stream.generate()
		System.out.println("Tok iz Stream.generate");

		Stream<Integer> infiniteStreamGenerate = Stream.generate(new Random()::nextInt); // en vhodni parameter ->
																							// lambda kako generirati
																							// podatke za tok

		int sumStreamGenerate = infiniteStreamGenerate // seštejemo števila od 10 do 19
				.limit(10).mapToInt(i -> i).sum();
		System.out.println("Seštevek iz neskončnega toka: " + sumStreamGenerate);

		System.out.println();
		
		// prazen tok empty()
		System.out.println("Prazen tok empty()");
		System.out.println(getMyStream(null));
	}

	// prazen tok empty()
	public static Stream<String> getMyStream(List<String> myData) {
		if (myData == null)
			return Stream.empty(); //vrne prazen tok, kadar ni podatkov
		return myData.stream();
	}

	public static List<Widget> getWidgets() {
		return List.of(new Widget("Miška", false), new Widget("Tipkovnica", true));
	}

}
