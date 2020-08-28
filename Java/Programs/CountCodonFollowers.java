package symboltable;
import algs4.Queue;
import algs4.StdIn;
import java.util.HashMap;

//Author Dan Steed

public class CountCodonFollowers {

    public static void main(String[] args) {

        HashMap<String, Queue<Integer>> table = new HashMap<>();

        StdIn.fromFile("src/data/codonlist.txt");
        String[] allCodons = StdIn.readAllStrings();

        StdIn.fromFile("src/data/SARSCoV2-S-gene-WH.txt");
        String WHsequence = StdIn.readAll();

        for (int i = 0; i < WHsequence.length() - 2; i += 3) {
            String individualCodon = WHsequence.substring(i, i + 3);
            if(!table.containsKey(individualCodon)) {
                table.put(individualCodon, new Queue<Integer>());
            }
            table.get(individualCodon).enqueue(i);

        }

        for(String codon: allCodons){
            if(table.containsKey(codon)){
                HashMap<String,Boolean> existsTable = new HashMap<>();
                for(int position:table.get(codon)){
                        int nextPosition = position +3;
                        if(nextPosition<WHsequence.length()-3) {
                        String follower = WHsequence.substring(nextPosition, nextPosition + 3);
                        existsTable.put(follower, true);
                    }
                }
                System.out.print(codon + ": " + existsTable.size()+ "\n");


            }else{
                System.out.println("Codon not present in sequence");
            }
        }
    }
}
