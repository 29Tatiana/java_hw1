package sem5;
import java.util.*;

public class ex2 {
    public static void main(String[] args) {
        Map<String, Integer> db = new HashMap<>();
        int count = 0;
        String spisok = "Иван Иванов, Светлана Петрова, Кристина Белова, Анна Мусина, Анна Крутова, Иван Юрин, Петр Лыков, Павел Чернов, Петр Чернышов, Мария Федорова, Марина Светлова, Мария Савина, Мария Рыкова, Марина Лугова, Анна Владимирова, Иван Мечников, Петр Петин, Иван Ежов";
        String[] persons = spisok.split(", ");
        for (String person : persons) {
            String[] people = person.split(" ");
            if (db.containsKey(people[0])) {
                count = db.get(people[0]) + 1;
                db.put(people[0], count);
            } else {
                db.put(people[0], 1);
            }
        }
        System.out.printf("Имена и количество повторов %s \n", db);
        ArrayList<Integer> numOfRepeat = new ArrayList<>();
        Map<String, Integer> dbSorted = new LinkedHashMap<>();
        for (String name : db.keySet()) {
            numOfRepeat.add(db.get(name));
        }
        numOfRepeat.sort(Collections.reverseOrder());
        for (Integer num : numOfRepeat) {
            for (String name : db.keySet()) {
                if (db.get(name) == num) {
                    dbSorted.put(name, db.get(name));
                }
            }
        }
        System.out.printf("Имена в порядке убывания популярности %s\n", dbSorted);


    }

}
