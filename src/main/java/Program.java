import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {

        File file = new File("input.txt");
        wordCount(file);
        System.out.println("*****");
        longestWord(file);
        System.out.println("*****");
        wordFrequencyCount(file);


    }

    public static void wordCount(File file) {
        try {
            Scanner scanner = new Scanner(file);
            int count = 0;

            while (scanner.hasNext()) {
                scanner.next();
                count++;
            }
            System.out.println("Полное количество слов в файле: " + count);
        } catch (FileNotFoundException e) {
            System.out.println("Нет файла!");
        }
    }

    public static void longestWord(File file) {
        try {
            Scanner scanner = new Scanner(file);
            String longestWord = "";

            while (scanner.hasNext()) {
                String word = scanner.next();
                if (word.length() > longestWord.length()) {
                    longestWord = word;
                }
            }

            System.out.println("Самое длинное слово: " + longestWord);

        } catch (FileNotFoundException e) {
            System.out.println("Нет файла!");
        }
    }

    public static void wordFrequencyCount(File file) {
        try {
            Scanner scanner = new Scanner(file);
            Map<String, Integer> wordFrequencyMap = new HashMap<>();

            while (scanner.hasNext()) {
                String word = scanner.next();
                wordFrequencyMap.put(word, wordFrequencyMap.getOrDefault(word,0)+1);
            }

            wordFrequencyMap.forEach((word, frequency) -> System.out.println(word + " встречается " + frequency + " раз!"));

        } catch (FileNotFoundException e) {
            System.out.println("Нет файла!");
        }
    }
}
