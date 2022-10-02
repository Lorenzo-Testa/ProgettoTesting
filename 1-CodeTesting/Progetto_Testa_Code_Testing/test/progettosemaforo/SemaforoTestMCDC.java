package progettosemaforo;

import static org.junit.Assert.*;

import org.junit.Test;

public class SemaforoTestMCDC {
	
	@Test
	public void testMCDC() {
		//0 verde
		//1 giallo
		//2 rosso
		
		//relativo al solo change color -- vedi file pdf allegato
		Semaforo s = new Semaforo();
		
		//METODO (SEM , COLOR)
		
		//t1
		assertEquals(true, s.changecolor(0, 0));
		//t2
		assertEquals(false, s.changecolor(-1, 0));
		//t3
		assertEquals(false, s.changecolor(3, 0));
		//t4
		assertEquals(false, s.changecolor(1, -1));
		//t5
		assertEquals(false, s.changecolor(1, 3));
		
		//t6
		assertEquals(true, s.changecolor(0, 1));
		//t7 è racchiuso in t1
		//t8
		assertEquals(false, s.changecolor(0, 1));
		
		//t9
		assertEquals(true, s.changecolor(0, 2));
		//t10 è racchiuso in t1
		//t11
		assertEquals(false, s.changecolor(0, 2));
		
		//t12
		assertEquals(true, s.changecolor(1, 0));
		//t13
		assertEquals(false, s.changecolor(1, 2));
		//t14
		assertEquals(false, s.changecolor(1, 0));
		
		//t19 approfitto di fare qua il t19 cosi da non dover ricambiare gli stati dopo
		assertEquals(false, s.changecolor(0, 0));
		
		//t15
		//devo mandare a verde l'altro semaforo
		s.changecolor(1, 1);
		s.changecolor(1, 2);
		s.changecolor(0, 0);
		assertEquals(false, s.changecolor(1, 0));
		
		//t16 è racchiuso in t1
		//t17 è racchiuso in t6
		//t18 è racchiuso in t8
		
	}
}
