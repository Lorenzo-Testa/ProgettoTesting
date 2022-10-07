package progettosemaforo;
public class Semaforo {

	private /*@ spec_public @*/ int[] stato;
	
	//@ public invariant (\exists int i; i>0 && i<stato.length; stato[i] == 2);
	
	//@ ensures stato != null;
	//@ ensures (\forall int i; i>0 && i<stato.length; stato[i] == 2);
	public Semaforo() {
		// nel costruttore li inizializzo entrambi rossi
		stato = new int[2];
		stato[0] = 2;
		stato[1] = 2;
	}

	//@requires sem >= 0;
	//@requires sem <= 2;
	//@requires color >=0;
	//@requires color <=2;
	//@ensures \result == true || \result == false;
	//@ensures (\forall int i; i>0 && i<stato.length && i!=sem; stato[i] == \old(stato[i]));
	public boolean changecolor(int sem, int color) {
		if (sem >= 0 && sem <= 2 && color >= 0 && color <= 2) {
			// da verde passo a giallo
			if (color == 1 && stato[sem] == 0) {
				stato[sem] = 1;
				return true;
			}
			// da giallo passo a rosso
			if (color == 2 && stato[sem] == 1) {
				stato[sem] = 2;
				return true;
			}
			// da rosso passo a verde, ma per questo caso devo verificare anche l'altro
			// semaforo
			// se sem = 1 allora l'altro è il sem 0
			if (sem == 1) {
				if (color == 0 && stato[sem] == 2 && stato[0] == 2) {
					stato[sem] = 0;
					return true;
				}
			} 
			else {
				if (color == 0 && stato[sem] == 2 && stato[1] == 2) {
					stato[sem] = 0;
					return true;
				}
			}
			return false;
		} 
		else {
			return false;
		}
	}

	//@ also
	//@ ensures (\forall int i; i>0 && i<stato.length; stato[i] == \old(stato[i]));
	@Override
	public String toString() {
		char sem1 = stato[0] == 0 ? 'V' : stato[0] == 1 ? 'G' : 'R';
		char sem2 = stato[1] == 0 ? 'V' : stato[1] == 1 ? 'G' : 'R';
		return "" + sem1 + sem2;
	}
}
