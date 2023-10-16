package no.hvl.dat100.prosjekt.modell;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

import no.hvl.dat100.prosjekt.TODO;

public class KortUtils {

	/**
	 * Sorterer en samling. Rekkefølgen er bestemt av compareTo() i Kort-klassen.
	 * 
	 * @see Kort
	 * 
	 * @param samling
	 * 			samling av kort som skal sorteres. 
	 */
	
	public static void sorter(KortSamling samling) {
		
		// TODO - START
		
		Kort[] temp_samling = samling.getAllekort();			
		
		int switched;
		
		do {
			switched = 0;
			
			
			for(int i = 0; i < samling.getAntalKort() - 1; i++) {
				if(temp_samling[i].compareTo(temp_samling[i+1]) > 0) {
					Kort temp_kort = new Kort(temp_samling[i].getFarge(), temp_samling[i].getVerdi());	
					
					temp_samling[i] = temp_samling[i+1];
					temp_samling[i + 1] = temp_kort;
					
					switched++;
				}
			}
			
		} while(switched > 0);
		
		samling.fjernAlle();
		
		for(int i = 0; i < temp_samling.length; i++) {
			samling.leggTil(temp_samling[i]);
		}


		// TODO - END
	}
	
	/**
	 * Stokkar en kortsamling. 
	 * 
	 * @param samling
	 * 			samling av kort som skal stokkes. 
	 */
	public static void stokk(KortSamling samling) {
		
		// TODO - START
		int size = samling.getAntalKort();
		
		Set<Integer> index = new HashSet<Integer>();
		for(int i = 0; i < size; i++) {
			index.add(i);
		}
		
		Kort[] temp_samling = samling.getAllekort();
		Kort[] stokket_samling = new Kort[size];
		
		for (int i = 0; i < size; i++) {
			
			Random random = new Random();
			int int_random;
			
			do {
				int_random = random.nextInt(size);
			}
			while(!index.contains(int_random));
			
			stokket_samling[i] = temp_samling[int_random];
			
			index.remove(int_random);
		}
		
		samling.fjernAlle();
		
		for(int i = 0; i < stokket_samling.length; i++) {
			samling.leggTil(stokket_samling[i]);
		}
		
		
		// TODO - END
	}

}
