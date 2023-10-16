package no.hvl.dat100.prosjekt.modell;

import no.hvl.dat100.prosjekt.TODO;
import no.hvl.dat100.prosjekt.kontroll.dommer.Regler;

/**
 * Struktur for å lagre ei samling kort. Kan lagre hele kortstokken. Det finnes
 * en konstant i klassen Regler som angir antall kort i hver av de 4 fargene. Når
 * programmet er ferdig settes denne til 13, men under utvikling / testing kan
 * det være praktisk å ha denne mindre.
 * 
 */
public class KortSamling {

	private final int MAKS_KORT = 4 * Regler.MAKS_KORT_FARGE;

	private Kort[] samling;
	private int antall;

	/**
	 * Oppretter en tom Kortsamling med plass til MAKS_KORT (hele kortstokken).
	 */
	public KortSamling() {
		
		// TODO - START
		samling = new Kort[MAKS_KORT];
		antall = 0; 
		// TODO - END
	}

	/**
	 * Returnerer en tabell med kortene i samlinga. Tabellen trenger ikke være
	 * full. Kortene ligger sammenhengende fra starten av tabellen. Kan få
	 * tilgang til antallet ved å bruke metoden getAntallKort(). Metoden er
	 * først og fremst ment å brukes i testklasser. Om man trenger
	 * kortene utenfor, anbefales metoden getAlleKort().
	 * 
	 * @return tabell av kort.
	 */
	public Kort[] getSamling() {
		
		return samling;
		
	}
	
	/**
	 * Antall kort i samlingen.
	 * 
	 * @return antall kort i samlinga.
	 */
	public int getAntalKort() {
		
		// TODO - START
		return antall;
		// TODO - END
	}
	
	/**
	 * Sjekker om samlinga er tom.
	 * 
	 * @return true om samlinga er tom, false ellers.
	 */
	public boolean erTom() {
		
		// TODO - START
		return (antall == 0);		
		
		// TODO - END
	}

	/**
	 * Legg et kort til samlinga.
	 * 
	 * @param kort
	 *            er kortet som skal leggast til.
	 */
	public void leggTil(Kort kort) {
		
		// TODO - START 
		if(antall < MAKS_KORT) {
			
			Kort tempKort = new Kort(kort.getFarge(), kort.getVerdi());
					
			this.samling[antall] = tempKort;
			
			this.antall++;
		}
		// TODO - END
		
		// ..................................... DONE TESTED .....................................
		
	}
	
	/**
	 * Legger alle korta (hele kortstokken) til samlinga. Korta vil være sortert
	 * slik at de normalt må stokkes før bruk.
	 */
	public void leggTilAlle() {
		
		// TODO - START
		// Husk: bruk Regler.MAKS_KORT_FARGE for å få antall kort per farge
		
		int index = 0;
		
		for(Kortfarge f : Kortfarge.values()) {
			for (int i = 1; i <= Regler.MAKS_KORT_FARGE; i++) {
				Kort temp_kort = new Kort(f, i);
				this.samling[index] = temp_kort;
				index++;
			}
		}
		
		this.antall = index;
		
		// TODO - END
		
		// ..................................... DONE TESTED .....................................
	}

	/**
	 * Fjerner alle korta fra samlinga slik at den blir tom.
	 * @return 
	 */
	public void fjernAlle() {
		
		// TODO - START
		this.samling = new Kort[MAKS_KORT];
		this.antall = 0;
		
		// TODO - END
		
		// ..................................... DONE TESTED .....................................
	}
	
	/**
	 * Ser på siste kortet i samlinga.
	 * 
	 * @return siste kortet i samlinga, men det blir ikke fjernet. Dersom samalinga er tom, returneres
	 *         null.
	 */
	public Kort seSiste() {
		
		// TODO - START
		
		if(antall != 0) {
			return this.samling[antall - 1];
		}
		else {
			return null;
		}
		
		// TODO - END
		
		// ..................................... DONE TESTED.....................................
		
	}

	/**
	 * Tek ut siste kort fra samlinga.
	 * 
	 * @return siste kortet i samlinga. Dersom samalinga er tom, returneres
	 *         null.
	 */
	public Kort taSiste() {
		
		// TODO - START
		
		if(antall != 0) {
			
			this.antall--;
			
			Kort temp_kort = samling[antall];
			
			Kort[] temp_samling = new Kort[MAKS_KORT];
			
			for(int i = 0; i < antall; i++) {
				temp_samling[i] = samling[i];
			}
			
			this.samling = temp_samling;
			
			return temp_kort;
			
 			
		}
		else {
			return null;
		}
		
		
		// TODO - END
		
		// ..................................... DONE TESTED .....................................
		
	}
	
	/**
	 * Undersøker om et kort finst i samlinga.
	 * 
	 * @param kort.
	 * 
	 * @return true om kortet finst i samlinga, false ellers.
	 */
	public boolean har(Kort kort) {
		
		// TODO - START
		
		if (kort == null) {
			return false;
		}
		
		Kort temp_kort = new Kort(kort.getFarge(), kort.getVerdi());
		
		for (int i = 0; i < antall; i++) {
			if (samling[i].lik(temp_kort)) {
				return true;
			}
		}
		return false;
		// TODO - END
		
		// ..................................... DONE TESTED .....................................
		
	}

	/**
	 * Fjernar et kort frå samlinga. Dersom kortet ikke finnest i samlinga,
	 * skjer ingenting med samilingen
	 * 
	 * @param kort
	 *            kortet som skal fjernast. Dersom kortet ikke finnes, skjer
	 *            ingenting.
	 * @return true om kortet blev fjernet fra samlinga, false ellers.
	 */
			 
	public boolean fjern(Kort kort) {
		
		// TODO - START
		
		if (kort == null) {
			return false;
		}
		
		Kort temp_kort = new Kort(kort.getFarge(), kort.getVerdi());
		
		Kort[] temp_samling = new Kort[MAKS_KORT];
		boolean removed = false;

		int index = 0;
		
		for	(int i = 0; i < antall; i++) {
			if(!samling[i].lik(temp_kort)) {
				
				temp_samling[index] = samling[i];
				index++;
			}
			else {
				removed = true;
			}
		}
		
		if (removed == true) {
			this.antall--;
		}
		
		this.samling = temp_samling;
		
		return removed;

		// TODO - END
		
		// ..................................... DONE TESTED .....................................
	}

	/**
	 * Gir kortene som en tabell av samme lengde som antall kort i samlingen
	 * 
	 * @return tabell av kort som er i samlingen, der kort skal ha samme rekkefølge
	 *         som i kortsamlinga.
	 */
	public Kort[] getAllekort() {
	
		Kort[] allekort= new Kort[antall];
		
		for (int i = 0; i < antall; i++) {
			allekort[i] = samling[i];
		}
		
		return allekort;

		// TODO - END
		
		// ..................................... DONE TESTED .....................................
	
	}
	
}
