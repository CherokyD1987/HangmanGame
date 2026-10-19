public class Main {
    static void main(String[] args) {
        RandomWord randomWord = new RandomWord("src\\main\\resources\\words_5000.txt");
        String word = randomWord.getWord();
        System.out.println(word);

            GallowsState[] states = GallowsState.values();
            System.out.println(states[1].getPicture());
            System.out.println("__ __ A __ __");

            ConsoleInput consoleInput = new ConsoleInput();
            char letter = consoleInput.readLetter();
            System.out.println(letter);
    }
}
