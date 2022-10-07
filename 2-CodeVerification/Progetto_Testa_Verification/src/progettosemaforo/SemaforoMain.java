package progettosemaforo;

public class SemaforoMain {

	public static void main(String[] args) {
		Semaforo s1 = new Semaforo();
		System.out.println(s1.toString());
		System.out.print(s1.changecolor(0, 0) + " ");
		System.out.println(s1.toString());
		System.out.print(s1.changecolor(0, 1) + " ");
		System.out.println(s1.toString());
		System.out.print(s1.changecolor(0, 2) + " ");
		System.out.println(s1.toString());
		System.out.print(s1.changecolor(1, 0) + " ");
		System.out.println(s1.toString());
		System.out.print(s1.changecolor(1, 1) + " ");
		System.out.println(s1.toString());
		System.out.print(s1.changecolor(1, 2) + " ");
		System.out.println(s1.toString());
		
		
//		s1.changecolor(3, 0);
//		System.out.println(s1.toString());
//		s1.changecolor(0, 3);
		

	}

}
