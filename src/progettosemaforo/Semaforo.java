package progettosemaforo;
public class Semaforo {

	int[] colore;
	// 0 verde
	// 1 giallo
	// 2 rosso

	public Semaforo() {
		// nel costruttore li inizializzo entrambi rossi
		colore = new int[2];
		colore[0] = 2;
		colore[1] = 2;
	}

	public boolean changecolor(int sem, int color) {
		if (sem >= 0 && sem <= 2 && color >= 0 && color <= 2) {
			// da verde passo a giallo
			if (color == 1 && colore[sem] == 0) {
				colore[sem] = 1;
				return true;
			}
			// da giallo passo a rosso
			if (color == 2 && colore[sem] == 1) {
				colore[sem] = 2;
				return true;
			}
			// da rosso passo a verde, ma per questo caso devo verificare anche l'altro
			// semaforo
			// se sem = 1 allora l'altro è il sem 0
			if (sem == 1) {
				if (color == 0 && colore[sem] == 2 && colore[0] == 2) {
					colore[sem] = 0;
					return true;
				}
			} 
			else {
				if (color == 0 && colore[sem] == 2 && colore[1] == 2) {
					colore[sem] = 0;
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
		return "" + sem1 + sem2;
	}
}
