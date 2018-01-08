package assementeByDarma;



	import java.util.Random;

	public class RandomData {
	public String randomName() {
	Random r =new Random();

	String alphabet="jwkwokwwpslpslwplplplplppppppp";

	final int N=10;

	StringBuilder sb= new StringBuilder();
	for(int i=0; i<N;i++) {
	sb.append(alphabet.charAt(r.nextInt(alphabet.length())));
	}
	return sb.toString();

	}


	}


