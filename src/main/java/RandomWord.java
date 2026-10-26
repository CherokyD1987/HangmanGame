import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.*;
import java.util.*;

public class RandomWord {

    private final List<String> wordsList = new ArrayList<>();
    private final Random rand = new Random();
    private static final int MIN_WORD_LENGTH = 7;
    private static final Path DICCIONARIO_PATH_RU = Paths.get("src","main", "resources", "words_5000_ru.txt");

    public RandomWord() {
        try (BufferedReader reader = Files.newBufferedReader(DICCIONARIO_PATH_RU)) {
            String line, word;
            while ((line = reader.readLine()) != null) {
                word = line.trim().toLowerCase();
                if (word.length() >= MIN_WORD_LENGTH) {
                    wordsList.add(word);
                }
            }
        } catch (IOException e) {
            throw new IllegalStateException("Не удалось загрузить словарь: " + DICCIONARIO_PATH_RU, e);
        }
        if (wordsList.isEmpty()) {
            throw new IllegalStateException("Словарь пуст или в нём нет подходящих слов: " + DICCIONARIO_PATH_RU);
        }
    }

        public String getWord () {
            return wordsList.get(rand.nextInt(wordsList.size()));
        }
}
