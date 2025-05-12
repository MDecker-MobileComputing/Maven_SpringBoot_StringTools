package de.eldecker.dhbw.spring.stringtools.model;


/**
 * Ergebnistyp für REST-Methode zur Bestimmung der Länge eines Strings.
 * 
 * @param stringTrimmed Der Input-String nach Trimming, d.h. Entfernung von Leerzeichen
 *                      am Anfang und/oder Ende
 *                      
 * @param laenge Anzahl der Zeichen von {@code stringTrimmed}; ist {@code -1} im Fehlerfall
 * 
 * @param nachricht Nachricht für Erfolgs- oder Fehlerfall
 */
public record StringLaengeErgebnis( String stringTrimmed, 
		                            int laenge,
		                            String nachricht		                            
		                          ) {
}
