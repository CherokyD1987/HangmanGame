public enum GameMenu {
    MENU_NEW_GAME('н', "(Н)ачать новую игру"),
    MENU_EXIT('в', "(В)ыйти"),
    ;

    private char key;
    private final String menu;

    GameMenu(char key, String menu) {
        this.key = key;
        this.menu = menu;
    }

    public String getMenu() {
        return menu;
    }

    public char getKey() {
        return key;
    }

    public static GameMenu findByKey(char key) {
        for (GameMenu gameMenu : GameMenu.values()) {
            if (gameMenu.getKey() == key) {
                return gameMenu;
            }
        }

        return null;
    }
}
