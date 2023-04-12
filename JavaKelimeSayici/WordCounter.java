import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class WordCounter {
    public static void main(String[] args) throws IOException {
        File file = new File("alice_in_wonderland.txt");
        BufferedReader reader = new BufferedReader(new FileReader(file));
        String line = reader.readLine();
        Map<String, Integer> wordCountMap = new HashMap<>();

        // Kelime öbekleri
        String[] wordsToFind = {"upon", "sigh", "Dormouse", "jury-box", "swim"};

        while (line != null) {
            // Satırdaki kelimelerin sayımlarının yapılması
            String[] words = line.split("\\W+");
            for (String word : words) {
                if (wordCountMap.containsKey(word)) {
                    wordCountMap.put(word, wordCountMap.get(word) + 1);
                } else {
                    wordCountMap.put(word, 1);
                }
            }
            line = reader.readLine();
        }
        reader.close();

        // Aranan kelimelerin sayılarının yazdırılması
        for (String word : wordsToFind) {
            System.out.println(word + " : " + wordCountMap.getOrDefault(word, 0));
        }
    }
}
