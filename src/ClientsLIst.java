import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
public class ClientsLIst {
    private final String clientsList = "clients.txt";
    private final String file;

    public ClientsLIst() {
//        String filePath = "src";
        this.file = new File("").getAbsolutePath() + "/" + clientsList;
    }

    public String getClientsList() {
        return clientsList;
    }
    public String getFile() {
        return file;
    }

    public String uniqueWords (FileReader bookName) throws IOException {
        ArrayList <String> unique = new ArrayList<>();
        int c;
        StringBuilder wordBuilder = new StringBuilder();
        while ((c = bookName.read()) != -1) {
            wordBuilder.append((char) c);
            if (c == 32) {
                unique.add(wordBuilder.toString());
                wordBuilder = new StringBuilder();
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
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .forEach(w -> mostPopularOrder.put(w.getKey(), w.getValue()));

        return mostPopularOrder.toString();
    }
}
