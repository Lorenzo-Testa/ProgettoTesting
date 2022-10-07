asm semaforo

import StandardLibrary
import CTLlibrary
signature:
	enum domain Colori = {ROSSO, GIALLO, VERDE}
	enum domain Semafori = {DX, SX}
	controlled stato: Semafori -> Colori
	monitored semSelezionato : Semafori
	monitored colSelezionato : Colori
	
	derived almenounrosso : Boolean
	derived tuttirossi : Boolean

definitions:
	
	function almenounrosso = (exist $c in Semafori with stato($c) = ROSSO)
	function tuttirossi = (forall $c in Semafori with stato($c) = ROSSO)

	macro rule r_verde($t in Semafori) =
		stato($t) := VERDE
	
	macro rule r_giallo($t in Semafori) =
		stato($t) := GIALLO
		
	macro rule r_rosso($t in Semafori) =
		stato($t) := ROSSO
		
	//proprietà temporali
	//c'è sempre almeno un semaforo rosso
	CTLSPEC ag(almenounrosso)
	//non ce ne sono mai due verdi all'unisono
	CTLSPEC ag(not(stato(DX) = VERDE and stato(SX) = VERDE))
	//se uno è verde allora l'altro è rosso
	CTLSPEC ag((stato(DX) = VERDE implies stato(SX) = ROSSO) and (stato(SX) = VERDE implies stato(DX) = ROSSO))
	//esiste uno stato in cui sono entrambi rossi
	CTLSPEC ef(stato(DX) = ROSSO and stato(SX) = GIALLO)
	//se un semaforo diventa verde, successivamente può diventare giallo (non af perchè potrei interrompere l'esecuzione prima)
	CTLSPEC ag(stato(DX) = VERDE implies ef(stato(DX) = GIALLO))
	
		
	main rule r_main =
		par
			if(semSelezionato = DX) then
				par
					if(colSelezionato = VERDE and stato(SX)=ROSSO) then
						r_verde[semSelezionato]
					endif
					if(colSelezionato = GIALLO and stato(DX)=VERDE) then
						r_giallo[semSelezionato]
					endif
					if(colSelezionato = ROSSO and stato(DX)=GIALLO) then
						r_rosso[semSelezionato]
					endif
				endpar
	endif
			if(semSelezionato = SX) then
				par
					if(colSelezionato = VERDE and stato(DX)=ROSSO) then
						r_verde[semSelezionato]
					endif
					if(colSelezionato = GIALLO and stato(SX)=VERDE) then
						r_giallo[semSelezionato]
					endif
					if(colSelezionato = ROSSO and stato(SX)=GIALLO) then
						r_rosso[semSelezionato]
					endif
				endpar
	endif
		endpar
default init s0:
	function stato($t in Semafori) = ROSSO