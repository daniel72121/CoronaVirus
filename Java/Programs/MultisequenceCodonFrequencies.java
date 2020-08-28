package symboltable;
/////Author Daniel Steed


import algs4.AVLTreeST;
import algs4.StdIn;
import algs4.StdOut;

public class MultisequenceCodonFrequencies {

    public static void main(String[] args) {
        AVLTreeST<String, AVLTreeST<String, Integer>> frequencies = new AVLTreeST<>();
        AVLTreeST<String, Integer> textLengths = new AVLTreeST<>();
        String[] textFiles = {"src/data/SARSCoV2-S-gene-CA.txt", "src/data/SARSCoV2-S-gene-IL.txt", "src/data/SARSCoV2-S-gene-WH.txt"};
        for (String filename : textFiles) {
            StdIn.fromFile(filename);
            frequencies.put(filename, new AVLTreeST<String, Integer>());
            String text = StdIn.readAll();
            textLengths.put(filename, text.length()/3);
            for (int i = 0; i < text.length() - 2; i += 3) {
                String codon = text.substring(i, i + 3);
                Integer frequency = frequencies.get(filename).get(codon);
                if(frequency == null) frequency =0;
                frequencies.get(filename).put(codon,frequency+1);

            }
        }
        String[] codons = {"ctt","ctc","cta","ctg","tta","ttg"};
        for(String codon: codons){
            System.out.println("Frequency for : " + codon + " ");
            for(String filename:textFiles){
                Integer frequency = frequencies.get(filename).get(codon);
                double percentage = 100.0 * frequency / textLengths.get(filename);
                StdOut.printf("%-25s\t%6.2f percent\n", filename, percentage) ;

            }
        }
    }
}




