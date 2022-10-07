/**
 * Classe nella quale si verificano le pre e postcondizioni
 * con jml ed è stato utilizzato PMD come analisi statica
 */
package progettosemaforo;
/** 
 * @author Testa Lorenzo
 * Semaforo è una classe che si occupa di gestire una via a 
 * senso unico governando due semafori posti alle sue estremita'.
 */
public class Semaforo {

	/**
	 * stato indica il colore attuale dei due semafori
	 */
	private transient /*@ spec_public @*/ int[] stato;
	
	//@ public invariant (\exists int i; i>0 && i<stato.length; stato[i] == 2);
	//@ ensures stato != null;
	//@ ensures (\forall int i; i>0 && i<stato.length; stato[i] == 2);
	/**
	 * costruttore: inizializzo entrambi i semafori a rossi
	 */
	public Semaforo() {
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
	
	/**
	 * permette di cambiare il colore del semaforo selezionat solo 
	 * se il nuobo colore e' nella sequenza verde, giallo, rosso e da rosso 
	 * a verde solo se l'altro semaforo e' a rosso.
	 * @param sem: numero semaforo selezionato
	 * @param color: codice nuovo colore da assegnare
	 * @return true se cambio effettuato, false altrimenti 
	 */
	public boolean changecolor(final int sem, final int color) {
		boolean cambiato = false;
		if (sem >= 0 && sem <= 2 && color >= 0 && color <= 2 && !cambiato) {
			// da verde passo a giallo
			if (color == 1 && stato[sem] == 0 && !cambiato) {
				stato[sem] = 1;
				cambiato = true;
			}
			// da giallo passo a rosso
			if (color == 2 && stato[sem] == 1 && !cambiato) {
				stato[sem] = 2;
				cambiato = true;
			}
			// da rosso passo a verde, ma per questo caso devo verificare anche l'altro
			// semaforo
			// se sem = 1 allora l'altro è il sem 0
			if (sem == 1 && !cambiato) {
				if (color == 0 && stato[sem] == 2 && stato[0] == 2) {
					stato[sem] = 0;
					cambiato = true;
				}
			} 
			else {
				if (color == 0 && stato[sem] == 2 && stato[1] == 2) {
					stato[sem] = 0;
					cambiato = true;
				}
			}
		} 
		return cambiato;
	}

	//funzione toString: permette di restituire tramite due char il 
	//colore dei semafori al momento in cui viene chiamata
	//@ also
	//@ ensures (\forall int i; i>0 && i<stato.length; stato[i] == \old(stato[i]));
	@Override
	public String toString() {
		final char sem1 = stato[0] == 0 ? 'V' : stato[0] == 1 ? 'G' : 'R';
		final char sem2 = stato[1] == 0 ? 'V' : stato[1] == 1 ? 'G' : 'R';
		return Character.toString(sem1)+Character.toString(sem2);
	}
}
