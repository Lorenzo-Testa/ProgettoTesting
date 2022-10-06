package sem;
public class Semaforo {

	int[] colore;
	
	public Semaforo() {
		// nel costruttore li inizializzo entrambi rossi
		colore = new int[2];
		colore[0] = 2;
		colore[1] = 2;
		
		assert colore != null;
		assert colore[0] == 2;
		assert colore[1] == 2;
	}

	public boolean changecolor(int sem, int color) {
		
		assert (sem>=0 && sem <=2);
		assert (color>=0 && color <= 2);
		assert (colore[0] == 2 || colore [1] == 2);
		
		if (sem >= 0 && sem <= 2 && color >= 0 && color <= 2) {
			
			// da verde a giallo
			if (color == 1 && colore[sem] == 0) {
				colore[sem] = 1;
				return true;
			}
			
			assert color != 1 || colore[sem] != 0;
			// da giallo a rosso
			if (color == 2 && colore[sem] == 1) {
				colore[sem] = 2;
				return true;
			}
			
			assert color != 1 || color != 2 || colore[sem] != 0 || colore[sem] != 1; //se non è valida almeno una di queste, non posso essere qui
			//da rosso a verde
			if (sem == 1) {
				if (color == 0 && colore[sem] == 2 && colore[0] == 2) {
					colore[sem] = 0;
					assert colore[0] == 2 || colore [1] == 2; //invariant
					return true;
				}
			} 
			else {
				if (color == 0 && colore[sem] == 2 && colore[1] == 2) {
					colore[sem] = 0;
					assert colore[0] == 2 || colore [1] == 2; //invariant
					return true;
				}
			}
			return false;
		} 
		else {
			return false;
		}
	}

	
	@Override
	public String toString() {
		char sem1 = colore[0] == 0 ? 'V' : colore[0] == 1 ? 'G' : 'R';
		char sem2 = colore[1] == 0 ? 'V' : colore[1] == 1 ? 'G' : 'R';
		assert sem1 == 'R' || sem2 == 'R';
		return "" + sem1 + sem2;
	}
}
