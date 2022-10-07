package sem;

public class SemaforoMainAssert {

	public static void main(String[] args) {
		Semaforo s1 = new Semaforo();
		System.out.println(s1.toString());
		s1.changecolor(0, 0);
		System.out.println(s1.toString());
		s1.changecolor(0, 1);
		System.out.println(s1.toString());
		s1.changecolor(0, 2);
		System.out.println(s1.toString());
		s1.changecolor(1, 0);
		System.out.println(s1.toString());
		s1.changecolor(1, 1);
		System.out.println(s1.toString());
		s1.changecolor(1, 2);
		System.out.println(s1.toString());

//		Questi due sono i casi per generare l'eccezione, cioè la violazione dell'assert
//		s1.changecolor(-1, -1);
//		s1.changecolor(0, -3);
		

	}

}
