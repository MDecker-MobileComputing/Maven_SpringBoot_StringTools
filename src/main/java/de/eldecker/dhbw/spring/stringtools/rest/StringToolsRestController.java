package de.eldecker.dhbw.spring.stringtools.rest;

import static java.lang.String.format;

import static org.springframework.http.HttpStatus.BAD_REQUEST;
import static org.springframework.http.HttpStatus.OK;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import de.eldecker.dhbw.spring.stringtools.model.StringLaengeErgebnis;


/**
 * Klasse mit REST-Endpunkten für String-Operationen.
 */
@RestController
@RequestMapping("/stringtools/v1")
public class StringToolsRestController {

	
	/**
	 * Methode für REST-Endpunkt, die Länge eines als Pfadparameters übergebenen Strings zurückgibt.
	 * Der String darf nicht nur aus Leerzeichen bestehen.
	 * 
	 * @param inputString Als Pfadparameter übergebener String, dessen Länge bestimmt werden soll;
	 *                    darf nicht leer sein!
	 * 
	 * @return Im Erfolgsfall: Ergebnisobjekt mit Länge des Strings und HTTP-Status-Code 200 (OK);
	 *         im Fehlerfall: HTTP-Status-Code 400 (Bad Request) und Ergebnisobjekt mit Fehlertext 
	 *                        im Attribut {@code nachricht}.
	 */
	@GetMapping( "/laenge/{inputString}" ) 
	public ResponseEntity<StringLaengeErgebnis> stringLaenge( @PathVariable String inputString ) {
		
		final String inputStringTrimmed = inputString.trim();
		final int    laenge             = inputStringTrimmed.length();
		
		StringLaengeErgebnis ergebnis = null;
				
		if ( laenge > 0 ) {
		
			final String nachricht = 
					format( "Der String besteht aus %d Zeichen.", laenge );
			
			ergebnis = new StringLaengeErgebnis( 
								inputStringTrimmed, 
								laenge, 
								nachricht 
							);
			
			return ResponseEntity.status( OK ).body( ergebnis ); 
			
		} else {
			
			ergebnis = new StringLaengeErgebnis( 
								inputStringTrimmed, 
								-1, 
								"FEHLER: String darf nicht leer sein." 
							);
			
			return ResponseEntity.status( BAD_REQUEST ).body( ergebnis );
		}
	}
	
}
