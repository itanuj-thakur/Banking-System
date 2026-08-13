package utility;

import java.util.Scanner;

public class inputHelper {
    static Scanner scanner = new Scanner(System.in);

    public static double readDouble() {
        return scanner.nextDouble();
    }

    public static long readLong() {
        return scanner.nextLong();
    }

    public static String readString() {
        return scanner.next();
    }
}
