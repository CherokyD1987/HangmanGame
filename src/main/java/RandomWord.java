import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.*;
import java.util.*;

public class RandomWord {

    private final List<String> wordsList = new ArrayList<>();
    private final Random rand = new Random();
    private static final int MIN_WORD_LENGTH = 7;

    public RandomWord(String path) {
        Path filePath = Paths.get(path);
        try (BufferedReader reader = Files.newBufferedReader(filePath)) {
            String line, word;
            while ((line = reader.readLine()) != null) {
                word = line.trim().toLowerCase();
                if (word.length() >= MIN_WORD_LENGTH) {
                    wordsList.add(word);
                }
            }
        } catch (IOException e) {
            throw new IllegalStateException("Не удалось загрузить словарь: " + filePath, e);
        }
        if (wordsList.isEmpty()) {
            throw new IllegalStateException("Словарь пуст или в нём нет подходящих слов: " + filePath);
        }
    }

        public String getWord () {
            return wordsList.get(rand.nextInt(wordsList.size()));
        }
}
