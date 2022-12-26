import java.util.Scanner;

public class user {

    public static int Start=1;

    public user() {

    }

    public static boolean press() {
        //Scanner scanner = new Scanner(System.in);
        //Start = scanner.nextInt();
        // User presses the enter button to get in to settings menu.
        if (Start == 1) {
            return true;
        } else {
            return false;
        }
    }

}
