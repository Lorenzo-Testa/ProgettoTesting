package progettosemaforo;

import static org.junit.Assert.*;
import java.util.Arrays;
import java.util.Collection;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class SemaforoTest_Parametrized {

	@Parameters
	public static Collection<Object[]> data() {
		return Arrays.asList(new Object[][] {
			//chiamo 7 volte il changecolor, ma lo fa in sessioni di test diverse, quindi
			//le uniche volte in cui il risultato ritornato da changecolor e' true e' quando
			//lo faccio cambiare dall'inizializzazione, cioè faccio variare un semaforo da rosso a verde
			{0,0,true},	//0
			{0,1,false},//1
			{0,2,false},//2
			{1,0,true},	//3
			{1,1,false},//4
			{1,2,false},//5
			{0,0,true},	//6
		});
	}
	
	private Semaforo semaforo;
	private int semSelected;
	private int coloreSelected;
	private boolean expected;
	
	public SemaforoTest_Parametrized(int s, int c, boolean r) {
		this.semaforo = new Semaforo();
		this.semSelected=s;
		this.coloreSelected=c;
		this.expected=r;
		
	}
	
	@Test
	public void test() {
		assertEquals(expected, semaforo.changecolor(semSelected, coloreSelected));
	}
}
