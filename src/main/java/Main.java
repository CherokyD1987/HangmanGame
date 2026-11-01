public class Main {

    private static final String WELCOME = """
            
                    Добро пожаловать в игру «Виселица»!
            
            Правила:
            - компьютер загадывает слово, вы называете буквы по одной;
            - если буква есть в слове, она открывается;
            - если нет, на виселице рисуется новая часть;
            - после 6 ошибок вы проиграли.
            """;

    public static void main(String[] args) {

        RandomWord randomWord = new RandomWord();
        ConsoleInput tecladoLetra = new ConsoleInput();

        System.out.println(WELCOME);

        boolean running = true;
        while (running) {
            for (GameMenu item : GameMenu.values()) {
                System.out.println(" - " + item.getMenu());
            }

            GameMenu choiceLetter = GameMenu.findByKey(tecladoLetra.readLetter());

            if (choiceLetter == null) {
                System.out.println("Такого пункта меню нету!");
                System.out.println();
                continue;
            }

            switch (choiceLetter) {
                case MENU_NEW_GAME -> playRound(randomWord, tecladoLetra);
                case MENU_EXIT -> running = false;
            }

        }

    }

    private static void playRound(RandomWord randomWorld, ConsoleInput input) {
        GameRound round = new GameRound(randomWorld.getWord());

        while (round.getGameState() == GameRound.GameState.PLAYING) {
            System.out.println(GallowsState.values()[round.getErrorsCounter()].getPicture());
            System.out.println("Загаданное слово: " + round.getMask());
            System.out.println("Ошибки: " + " (" + round.getErrorsCounter() + "), Названные буквы : " + round.getListedLetters());
            System.out.print("Введите букву: ");

            char letter = input.readLetter();
            GameRound.GuessResult checkResult = round.checkLetter(letter);

            switch (checkResult) {
                case HIT -> System.out.println("Есть такая буква!");
                case MISS -> System.out.println("Такой буквы нет.");
                case ALREADY_NAMED -> System.out.println("Эта буква уже была.");
            }
        }

        System.out.println();
        System.out.println(GallowsState.values()[round.getErrorsCounter()].getPicture());
        if (round.getGameState() == GameRound.GameState.WON) {
            System.out.println("Победа! Вы угадали слово: " + round.getWord());
        } else {
            System.out.println("Вы проиграли. Загаданное слово: " + round.getWord());
        }
        System.out.println();
    }
}
