import java.util.HashSet;
import java.util.Set;

public class Main {
    static void main(String[] args) {
//        RandomWord randomWord = new RandomWord("src\\main\\resources\\words_5000.txt");
//        String word = randomWord.getWord();
//        System.out.println(word);
//
//            GallowsState[] states = GallowsState.values();
//            System.out.println(states[1].getPicture());
//            System.out.println("__ __ A __ __");
//
//            ConsoleInput consoleInput = new ConsoleInput();
//            char letter = consoleInput.readLetter();
//            System.out.println(letter);

        GameRound gameRound = new GameRound(new RandomWord().getWord());

        gameRound.setListedLetters('а');
        gameRound.setListedLetters('о');
        gameRound.setListedLetters('и');
        gameRound.getMask();
    }

}
