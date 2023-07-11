import java.awt.print.Book;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
        ClientsLIst clientsLIst = new ClientsLIst();

        FileReader fileReader;
        try {
            fileReader = new FileReader(clientsLIst.getFile());
            System.out.println(clientsLIst.uniqueWords(fileReader));
            fileReader.close();
        } catch (IOException e) {
            System.err.println("No such file was found. Please, enter the correct title");
        }

        String statisticsFile = clientsLIst.getFile() + "_statistic.txt";
        FileWriter fileWriter;
        try {
            fileWriter = new FileWriter(statisticsFile, true);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        try {
            fileReader = new FileReader(clientsLIst.getFile());
            fileWriter.write(clientsLIst.uniqueWords(fileReader));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        try {
            fileWriter.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}