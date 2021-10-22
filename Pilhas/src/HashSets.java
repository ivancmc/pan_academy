import java.util.HashSet;

public class HashSets {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		HashSet<String> cars = new HashSet<>();
		cars.add("Gol");
		cars.add("Fox");
		cars.add("Civic");
		cars.add("Corolla");
		cars.add("BMW");
		cars.add("Fox");
		//HashSet mais rapido mas sem ordem
		//treeset ordena
		
//		cars.forEach(System.out::println);

		for (String c : cars) {
			System.out.println(c);
		}
		
		System.out.println();
		for (String c: cars) {
			if (c.contains("ol")) {
				System.out.println(c);
			}
		}
	}

}
