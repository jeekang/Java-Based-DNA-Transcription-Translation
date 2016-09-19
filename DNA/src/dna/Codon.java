package dna;

/**
 * Codon class contains necessary information to convert a DNA nucleotide sequence to
 * an amino acid sequence (translation).
 * @author jeekang
 *
 */
public class Codon {
	Boolean startCodon;
	Boolean stopCodon;
	int startCodonPosition = 0;
	int stopCodonPosition = 0;
	
	public Codon() {
		startCodon = false;
		stopCodon = false;
	}
	
	/**
	 * Locates the start codon, "AUG"
	 * Returns sequence starting with the start codon.
	 * @param s
	 * @return
	 */
	public String locateStartCodon(String s) {
		String result = "";
		for(int i = 0; i < s.length() - 3; i++) {
			if(s.charAt(i) == 'A' && s.charAt(i+1) == 'U' && s.charAt(i+2) == 'G' ) {
				result = s.substring(i, s.length());
				startCodonPosition = i;
				startCodon = true;
				return result;
			} 
		}
		System.out.println("No Start Codon Found, Stop Codon Search Aborted.");
		return s;
	}
	
	/**
	 * Locates the stop codon in sequence.
	 * Returns sequence ending with stop codon.
	 * @param s
	 * @return
	 */
	public String locateStopCodon(String s) {
		if(this.startCodon) {
			String result = "";
			for(int i = 3; i < s.length() - 2; i += 3) {
				if(s.charAt(i) == 'U' && s.charAt(i+1) == 'A' && s.charAt(i+2) == 'A' 
						|| s.charAt(i) == 'U' && s.charAt(i+1) == 'G' && s.charAt(i+2) == 'A'
						||s.charAt(i) == 'U' && s.charAt(i+1) == 'A' && s.charAt(i+2) == 'G') {
					result = s.substring(0, i+3);
					stopCodon = true;
					stopCodonPosition = i+2;
					return result;
				}  
			}
			System.out.println("No Stop Codon Found");
			return "N/A";
		} else {;
			return "N/A";
		}
	}
	
	/**
	 * Converts nucleotide sequence to matching amino acids.
	 * 
	 * @param s
	 * @return
	 */
	public String toCodon(String s) {
		StringBuilder codons = new StringBuilder();
		for(int i = 0; i < s.length() - 2; i += 3) {
			codons.append(codonConvert(s.substring(i, i+3)));
		}
		return codons.toString();
	}
	
	/**
	 * Takes a 3-nucleotide sequence and converts it to matching amino acid.
	 * @param s
	 * @return
	 */
	public static String codonConvert(String s) {
		if(s.equals("GCA") ||s.equals("GCC") || s.equals("GCG") || s.equals("GCU")) {
			return "ALA ";
		}
		if(s.equals("AAC") ||s.equals("AAU") || s.equals("GAC") || s.equals("GAU")) {
			return "ASX ";
		}
		if(s.equals("GAC") ||s.equals("GAU")) {
			return "ASP ";
		}
		if(s.equals("GAA") ||s.equals("GAG")) {
			return "GLU ";
		}
		if(s.equals("UUC") ||s.equals("UUU")) {
			return "PHE ";
		}
		if(s.equals("GGA") ||s.equals("GGC") || s.equals("GGG") || s.equals("GGU")) {
			return "GLY ";
		}
		if(s.equals("CAC") ||s.equals("CAU")) {
			return "HIS ";
		}
		if(s.equals("AUA") ||s.equals("AUC") || s.equals("AUU")) {
			return "ILE ";
		}
		if(s.equals("AAA") ||s.equals("AAG")) {
			return "LYS ";
		}
		if(s.equals("CUA") ||s.equals("CUC") || s.equals("CUG") || s.equals("CUU")
				|| s.equals("UUA") || s.equals("UUG")) {
			return "LEU ";
		}
		if(s.equals("AUG")) {
			return "MET ";
		}
		if(s.equals("AAC") ||s.equals("AAU")) {
			return "ASN ";
		}
		if(s.equals("CCA") ||s.equals("CCC") || s.equals("CCG") || s.equals("CCU")) {
			return "PRO ";
		}
		if(s.equals("CAA") ||s.equals("CAG")) {
			return "GLN ";
		}
		if(s.equals("AGA") ||s.equals("AGG") || s.equals("CGA") || s.equals("CGC")
				|| s.equals("CGG") || s.equals("CGU")) {
			return "ARG ";
		}
		if(s.equals("AGC") ||s.equals("AGU") || s.equals("UCA") || s.equals("UCC")
				|| s.equals("UCG") || s.equals("UCU")) {
			return "SER ";
		}
		if(s.equals("ACA") ||s.equals("ACC") || s.equals("ACG") || s.equals("ACU")) {
			return "THR ";
		}
		if(s.equals("GUA") ||s.equals("GUC") || s.equals("GUG") || s.equals("GUU")) {
			return "VAL ";
		}
		if(s.equals("UGG")) {
			return "TRP ";
		}
		if(s.equals("UAC") || s.equals("UAU")) {
			return "TYR ";
		}
		if(s.equals("CAA") || s.equals("CAG") || s.equals("GAA") || s.equals("GAG")) {
			return "GLX ";
		}
		if(s.equals("UAA") || s.equals("UAG") || s.equals("UGA")) {
			return "STOP ";
		}
		return "";
		
		
	}
}

