package sem4_hw;

import java.util.*;

public class Main4 {
    public static void main(String[] args) {
        ex2();
        ex1();
    }

    private static void ex1() {
        ArrayList<String> list = new ArrayList<>();
        ArrayDeque<String> arrayDeque = new ArrayDeque<>();
        while (true) {
            String text = inputText();
            if (text.equalsIgnoreCase("print")) {
                for (String s : arrayDeque) {
                    System.out.println(s);
                }
            }
            else if (text.equalsIgnoreCase("revert")) {
                arrayDeque.removeFirst();
            } else if (text.equalsIgnoreCase("exit")) {
                break;
            } else {
                list.add(text);
                arrayDeque.addFirst(text);
            }
        }
    }
    private static String inputText() {
        String text = "";
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите запрос");
        try {
            text = scanner.nextLine();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return text;
    }
    private static void ex2() {
        LinkedList<Integer> list = new LinkedList<>();
        Random random = new Random();

        for (int i = 0; i < 10; i++) {
            list.add(random.nextInt(1, 11));
        }
        System.out.println("Заданный список: " + list);
        System.out.println("Перевёрнутый список: " + reversLinkedList(list));
    }

    public static LinkedList<Integer> reversLinkedList(LinkedList<Integer> list) {
        for (int i = 0; i < list.size() - 1; i++) {
            list.add(i, list.pollLast());
        }
        return list;
    }
    }


