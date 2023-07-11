import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;

public class Main {

    public static void main(String[] args) throws IOException {
        ClientsLIst clientsLIst = new ClientsLIst();
        String names = "names.txt";

        FileReader fileReader;
            fileReader = new FileReader(names);
            HashMap<String, Integer> names1 = new HashMap<>(clientsLIst.namesToArray(fileReader));
            fileReader.close();

            fileReader = new FileReader(clientsLIst.getFile());
            System.out.println(clientsLIst.uniqueWords(fileReader, names1));
            fileReader.close();


        String statisticsFile = clientsLIst.getFile() + "_statistic.txt";
        FileWriter fileWriter;

            fileWriter = new FileWriter(statisticsFile, false);

            fileReader = new FileReader(clientsLIst.getFile());
            fileWriter.write(clientsLIst.uniqueWords(fileReader, names1));
            fileWriter.close();
    }
}