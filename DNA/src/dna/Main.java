package dna;

import java.util.Scanner;
/**
 * Main class to run the DNA template strand transcription/translation.
 * Enter DNA nucleotide sequence in ALL CAPS with no spaces in between.
 * Program assumes TEMPLATE strand is being transcribed/translated,
 * not CODING STRAND.
 * 
 * Only the first reading frame will be sequenced. 
 * 
 * @author jeekang
 *
 */
public class Main {
	public static void main(String [] args) {

		Codon cod = new Codon();

		System.out.println("Enter template DNA nucleotide sequence:");
		Scanner scan = new Scanner(System.in);
		String templateStrand = scan.next();
		String mRNA = Strand.mRNA(templateStrand);
		System.out.println("Complementary Sequence: " + Strand.complementaryStrand(templateStrand));
		System.out.println("mRNA Sequence         : " + mRNA);
		String readingFrame = cod.locateStopCodon(cod.locateStartCodon(mRNA));
		System.out.println("Reading Frame         : " + readingFrame);
		System.out.println("Start Position        : " + cod.startCodonPosition);
		System.out.println("Stop Position         : " + cod.stopCodonPosition);
		System.out.println("Amino Acid Sequence   : " + cod.toCodon(readingFrame));
		System.out.println("Full sequence/Disregard Start-Stop Codon? (y/n)");
		String userInput = scan.next();
		if(userInput.equalsIgnoreCase("y")) {
			System.out.println("Amino Acid Sequence   : " + cod.toCodon(mRNA));

		}
	}
}
