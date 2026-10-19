import java.util.Scanner;

public class ConsoleInput {
    private final Scanner scanner = new Scanner(System.in);

    public char readLetter() {
        while (true) {
            String input = scanner.nextLine().trim().toLowerCase();

            if (input.length() == 1) {
                char ch = input.charAt(0);
                if ((ch >= 'а' && ch <= 'я') || ch == 'ё') {
                    return ch;
                }
            }
            System.out.println("Введите одну русскую букву!");

        }
    }
}
