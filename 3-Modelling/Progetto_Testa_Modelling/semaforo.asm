asm semaforo

import StandardLibrary

signature:
	enum domain Colori = {ROSSO, GIALLO, VERDE}
	enum domain Semafori = {DX, SX}
	controlled stato: Semafori -> Colori
	monitored semSelezionato : Semafori
	monitored colSelezionato : Colori

definitions:

	macro rule r_verde($t in Semafori) =
		stato($t) := VERDE
	
	macro rule r_giallo($t in Semafori) =
		stato($t) := GIALLO
		
	macro rule r_rosso($t in Semafori) =
		stato($t) := ROSSO
		
		
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