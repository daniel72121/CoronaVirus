package symboltable;
//Author: Daniel Steed
import algs4.BST;
import algs4.StdIn;
import algs4.StdOut;


public class AAStatistics {

    public static void main(String[] args) {
        BST<String, String> aminoTable = new BST<>();
        StdIn.fromFile("src/data/codontranslation.txt");

        while (!StdIn.isEmpty()) {
            String line = StdIn.readLine();
            String[] fields = line.split("\\t");
            aminoTable.put(fields[0], fields[1]);
        }

        BST<String, Integer> frequencies = new BST<>();

        StdIn.fromFile("src/data/SARSCoV2-S-gene-CA.txt");
        String dnaSequenceCalifornia = StdIn.readAll();

        double count=0;
        for (int i = 0; i < dnaSequenceCalifornia.length() - 2; i += 3) {
            count++;
            String codon = dnaSequenceCalifornia.substring(i, i + 3);
            String abbreviation = aminoTable.get(codon);
            Integer frequency = frequencies.get(abbreviation);

            if(frequency==null){
                frequencies.put(abbreviation,1);
            }else{
                frequencies.put(abbreviation,frequency+1);
            }
        }

        for(String key:frequencies.keys()){
            double percentage = (double)(frequencies.get(key) / count)*100;

            StdOut.printf("%s : %d : %.4f \n",key,frequencies.get(key),percentage);

        }
    }
}


