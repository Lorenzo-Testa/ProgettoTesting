package progettosemaforo;

import static org.junit.Assert.*;

import org.junit.Test;

public class SemaforoTest {
	
	@Test
	public void testSemaforo() {
		Semaforo s1 = new Semaforo();
		assertNotNull(s1);
		assertEquals(2, s1.colore[0]);
		assertEquals(2, s1.colore[1]);
	}
	
	@Test
	public void testChangeColor() {
		//0 verde
		//1 giallo
		//2 rosso
		Semaforo s2 = new Semaforo();
		assertNotNull(s2);
		//inizio con entrambi rossi
		assertEquals(2, s2.colore[0]);
		assertEquals(2, s2.colore[1]);
		//primo a verde
		assertEquals(true, s2.changecolor(0, 0));
		assertEquals(0, s2.colore[0]);
		assertEquals(2, s2.colore[1]);
		//primo a giallo
		assertEquals(true, s2.changecolor(0, 1));
		assertEquals(1, s2.colore[0]);
		assertEquals(2, s2.colore[1]);
		//primo a rosso
		assertEquals(true, s2.changecolor(0, 2));
		assertEquals(2, s2.colore[0]);
		assertEquals(2, s2.colore[1]);
		//secondo a verde
		assertEquals(true, s2.changecolor(1, 0));
		assertEquals(2, s2.colore[0]);
		assertEquals(0, s2.colore[1]);
		//secondo a giallo
		assertEquals(true, s2.changecolor(1, 1));
		assertEquals(2, s2.colore[0]);
		assertEquals(1, s2.colore[1]);
		//secondo a rosso
		assertEquals(true, s2.changecolor(1, 2));
		assertEquals(2, s2.colore[0]);
		assertEquals(2, s2.colore[1]);
		//metto il primo a verde e verifico che non venga il secondo
		assertEquals(true, s2.changecolor(0, 0));
		assertEquals(0, s2.colore[0]);
		assertEquals(2, s2.colore[1]);
		assertEquals(false, s2.changecolor(1, 0));
		//caso in cue il metodo è chiamato errato
		assertEquals(false, s2.changecolor(-3, -3));
	}
	
	@Test
	public void testString() {
		Semaforo s2 = new Semaforo();
		
		assertNotNull(s2);
		assertEquals("RR", s2.toString());
		
		s2.changecolor(0, 0);
		assertEquals("VR", s2.toString());
		
		s2.changecolor(0, 1);
		assertEquals("GR", s2.toString());
		
		s2.changecolor(0, 2);
		assertEquals("RR", s2.toString());

		s2.changecolor(1, 0);
		assertEquals("RV", s2.toString());
		
		s2.changecolor(1, 1);
		assertEquals("RG", s2.toString());
		
		s2.changecolor(1, 2);
		assertEquals("RR", s2.toString());
	}
	
	@Test
	public void testMCDC() {
		//relativo al solo change color
		
	}
}
