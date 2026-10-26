import java.util.HashSet;
import java.util.Set;

public class GameRound {

    public enum GuessResult {
        ALREADY_NAMED,
        HIT,
        MISS
    }

    public enum GameState {
        PLAYING,
        WON,
        LOST,
    }

    private static final int MAX_ERRORS = GallowsState.values().length - 1;
    private int errorsCounter = 0;
    private final Set<Character> listedLetters = new HashSet<>();
    private final String word;

    public GameRound(String word) {
        this.word = word;
    }

    public GuessResult checkLetter(char ch) {
        if (listedLetters.contains(ch)) {
            return GuessResult.ALREADY_NAMED;
        }

        listedLetters.add(ch);

        if (word.indexOf(ch) == -1) {
            errorsCounter++;
            return GuessResult.MISS;
        }

        return GuessResult.HIT;
    }

    public String getMask() {

        char[] arrayWord = word.toCharArray();
        char[] maskedWord = new char[arrayWord.length];

        for (int i = 0; i < arrayWord.length; i++) {
            if (listedLetters.contains(arrayWord[i])) {
                maskedWord[i] = arrayWord[i];
            } else {
                maskedWord[i] = '_';
            }
        }

        return String.valueOf(maskedWord);
    }

    private boolean isWordGuessed() {
        for (char c : word.toCharArray()) {
            if (!listedLetters.contains(c)) {
                return false;
            }
        }
        return true;
    }

    public GameState getGameState() {

        if (isWordGuessed()) {
            return GameState.WON;
        }

        if (errorsCounter >= MAX_ERRORS) {
            return GameState.LOST;
        }

        return GameState.PLAYING;
    }

    public int getErrorsCounter() {
        return errorsCounter;
    }

    public Set<Character> getListedLetters() {
        return listedLetters;
    }
}
