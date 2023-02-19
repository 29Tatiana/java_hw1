package sem5;


import java.util.HashMap;
import java.util.List;

public class ex1 {
        public static HashMap<String, List<String>> phoneBook = new HashMap<>();

        public static void main(String[] args) {

            addToPhoneBook();
            findInPhoneBook("Федоров");

        }

        public static void addToPhoneBook() {
            phoneBook.put("Иванов", List.of("+7(999)667-09-00", "+7(952)466-99-73"));
            phoneBook.put("Петров", List.of("+7(961)687-09-83", "+7(904)888-91-30"));
            phoneBook.put("Смирнов", List.of("+7(999)027-71-13"));
            phoneBook.put("Федоров", List.of("+7(906)637-84-16", "+7(950)406-62-77", "+7(951)666-62-78"));
            phoneBook.put("Васин", List.of("+7(999)551-79-99"));
        }
        public static void findInPhoneBook(String surname) {
        System.out.printf("%s: %s", surname, phoneBook.get(surname));
        }
}

