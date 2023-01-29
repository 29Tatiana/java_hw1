package sem2_hw;
import java.util.Scanner;
import java.io.*;

public class Main {
    public static void main(String[] args) {
        ex1();
        ex2();
    }

    private static void ex1() {
        Scanner input = new Scanner(System.in);
        System.out.println("Введите строку: ");
        String str = input.next();
        input.close();

        String new_str = new StringBuilder(str).reverse().toString();

        if (new_str.equals(str)) {
            System.out.printf("Строка %s является палиндромом", str);
        } else {
            System.out.printf("Строка %s не является палиндромом", str);
        }
    }

    private static void ex2() {
        writeFile();
    }

    private static void writeFile() {
        String testString = "TEST".repeat(100);
        try (PrintWriter pw = new PrintWriter("src/main/resources/text.txt")) {
            pw.write(testString);
            pw.close();
            System.out.println("Запись добавлена");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.out.println("Запись не работает");
        }

    }
}