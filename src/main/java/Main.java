public class Main {
    static void main(String[] args) {
//        RandomWord randomWord = new RandomWord("src\\main\\resources\\words_5000.txt");
//        String word = randomWord.getWord();
//        System.out.println(word);

            GallowsState[] states = GallowsState.values();
            for (GallowsState state : states) {
                System.out.println(state.getPicture());
            }
    }
}
