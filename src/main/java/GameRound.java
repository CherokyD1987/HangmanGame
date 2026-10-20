import java.util.HashSet;
import java.util.Set;

public class GameRound {

    private int errorsCounter = 0;
    private final Set<Character> listedLetters = new HashSet<>();
    private final String word;

    public GameRound(String word) {
        this.word = word;
    }

    public void getMask() {

        char[] arrayWord = word.toCharArray();
        char[] maskedWord = new char[arrayWord.length];

        for (int i = 0; i < arrayWord.length; i++) {
            if (listedLetters.contains(arrayWord[i])) {
                maskedWord[i] = arrayWord[i];
            } else {
                maskedWord[i] = '_';
            }
        }

        for (Character character : maskedWord) {
            System.out.print(character);
        }


    }

    public Set<Character> getListedLetters() {
        return listedLetters;
    }

    public void setListedLetters(Character symbol) {
        listedLetters.add(symbol);
    }
}
