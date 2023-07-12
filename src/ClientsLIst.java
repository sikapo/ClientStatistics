import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
public class ClientsLIst {
    private final String file;

    public ClientsLIst() {
        String clientsList = "clients.txt";
        this.file = new File("").getAbsolutePath() + "/" + clientsList;
    }
    public String getFile() {
        return file;
    }

    public HashMap <String, Integer> namesToArray (FileReader namesFile) throws IOException {
        int c;
        HashMap <String, Integer> names = new HashMap<>();
        StringBuilder wordBuilder = new StringBuilder();
        while ((c = namesFile.read()) != -1) {
            if (c == 13) {
                names.put(wordBuilder.toString().toLowerCase(), 0);
                wordBuilder = new StringBuilder();
            }
            if (!(c == 13 || c == 10)) {
                wordBuilder.append((char) c);
            }
        }
        return names;
    }
    public String uniqueWords (FileReader bookName, HashMap<String, Integer> names1) throws IOException {
        ArrayList <String> unique = new ArrayList<>();
        int c;
        StringBuilder wordBuilder = new StringBuilder();
        while ((c = bookName.read()) != -1) {

            if (c == 32) {
                unique.add(wordBuilder.toString().toLowerCase());
                wordBuilder = new StringBuilder();
            }
            if (!(c==32)){
                wordBuilder.append((char) c);
            }
        }
        HashMap<String, Integer> mostPopular = new HashMap<>();
        for (String word : unique) {
            if (!mostPopular.isEmpty()) {
                if (mostPopular.containsKey(word)) {
                    mostPopular.replace(word, mostPopular.get(word), mostPopular.get(word) + 1);
                }
                else mostPopular.put(word, 1);
            }
            else mostPopular.put(word, 1);
        }

        LinkedHashMap<String, Integer> mostPopularOrder = new LinkedHashMap<>();


        mostPopular.entrySet().stream()
                .filter(v -> v.getValue() > 1)
                .filter(v -> !names1.containsKey(v.getKey()))
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .forEach(v -> mostPopularOrder.put(v.getKey(), v.getValue()));

        StringBuilder outputBuilder = new StringBuilder();
        for (Map.Entry<String, Integer> entry : mostPopularOrder.entrySet()) {
            outputBuilder.append(entry.getKey()).append(": ").append(entry.getValue()).append("\n");
        }
        return outputBuilder.toString();
    }
}
