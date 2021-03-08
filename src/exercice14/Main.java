package exercice14;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		List<String> strings = List.of(
				"one", "two", "three", "four", "five", "six", "seven", "eight", "nine", "ten", "eleven", "twelve");
		
		
		
		//Question 1 
		System.out.println("******* Affichage des éléments du stream *******");
		
		Stream<String> listStream = strings.stream();
		listStream.forEach(System.out::println);
		
		//Question 2
		System.out.println("\n******* Affichage des éléments du stream en majuscule *******\n");
		
		List<String>streamOfUppercase = 
				strings.stream().map(s -> s.toUpperCase()).collect(Collectors.toList());
		System.out.println(streamOfUppercase);
		
		//Question 3
		System.out.println("\n******* Premieres lettre des éléments sans doublon *******\n");
		
		Stream<String> streamLetter = 
				strings.stream().map(s -> s.substring(0, 1).toUpperCase()).distinct();
		streamLetter.forEach(System.out::println);
		
		//Question 4 
		System.out.println("\n******* Longueur d'éléments dans le stream *******");
		Stream<Integer> streamLength = 
				strings.stream().map(String::length).distinct();
		streamLength.forEach(s -> System.out.println(s));
		
		//Question 5
		System.out.println("******* Nombre d'éléments dans le stream *******");
		
		long streamCount = 
				strings.stream().collect(Collectors.counting());
		//OU
		//long count = list.stream().count();
		System.out.println(streamCount);
		
		//Question 6 
		System.out.println("\n******* Eléments de longueur paire *******");
		
		Stream<String> streamPaire = 
				strings.stream().filter(s -> s.length() % 2 == 0);
		streamPaire.forEach(s -> System.out.println(s));
		
		//Question 7 
		System.out.println("\n******* Longueur de la chaine la plus longue *******");
		
		int maxLongueur = 
				strings.stream()
				      .mapToInt(String::length).max().getAsInt();
		System.out.println(maxLongueur);
		
		
		//Question 8
		System.out.println("\n******* liste de chaînes de longueur impaire en majuscules *******");
		
		Stream<String> streamImpaire = 
				strings.stream().map(s -> s.toUpperCase()).filter(s -> s.length() % 2 != 0);
		streamImpaire.forEach(s -> System.out.println(s));
		
		
		//Question 9
		System.out.println("\n******* Concaténation *******");
		
		String streamConcat =
				strings.stream().filter(s -> s.length() <= 5).sorted().collect(Collectors.joining(", ", "{", "}"));
		System.out.println(streamConcat);
		
		//Question 10
		System.out.println("\n******* Table de Hashage map *******\n");
		
		Map<Integer, List<String>> map = 
				strings.stream()
					  .collect(
							  Collectors.groupingBy(String::length) 
					  );
		map.forEach((key, value) -> System.out.println(key + " = " + value));
		
		//Question 11
		System.out.println("\n******* Table de Hashage map2 *******\n");
		
		Map<Character, String> map2 = 
				strings.stream()
				.collect( Collectors.groupingBy(s -> s.charAt(0), Collectors.joining(",")));
					  
					  
		map2.forEach((key, value) -> System.out.println(key + " = " + value));
	}

}
