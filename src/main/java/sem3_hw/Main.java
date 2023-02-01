package sem3_hw;
import java.util.*;
import java.util.stream.Collectors;



public class Main {
    public static void main(String[] args) {
        ex1();
        ex2();
        ex3();
    }

    private static void ex1() {
        ArrayList<Integer> arrayList = new ArrayList<>();
        Random random = new Random();

        int sum = 0;
        for (int i = 0; i < 10; i++) {
            arrayList.add(random.nextInt(1, 11));
            sum = sum + i;
        }

        System.out.println("Исходный список: " + arrayList);
        arrayList.removeIf(i -> i % 2 == 0);
        System.out.println("Редактированный список: " + arrayList);
    }


    private static void ex2() {
        ArrayList<Integer> arrayList = new ArrayList<>();
        Random random = new Random();
        for (int i = 0; i < 10; i++) {
            arrayList.add(random.nextInt(10));
        }
        double sum = 0;
        for (int x : arrayList) {
            sum += x;
        }
        System.out.println("Целочисленный список: " + arrayList);
        System.out.printf("Минимальное число в целочисленном списке: %d\n ", Collections.min(arrayList));
        System.out.printf("Максимальное число в целочисленном списке: %d\n ", Collections.max(arrayList));
        System.out.printf("Среднее арифметическое элементов в целочисленном списке: " + sum / arrayList.size());
        System.out.println();

    }

    public static void ex3() {
        List<String> planets = new ArrayList<>();
        HashMap<String, Integer> planetCount = new HashMap<>();
        Random rand = new Random();

        String[] solarSystemPlanets = {"Mercury", "Venus", "Earth", "Mars", "Jupiter", "Saturn", "Uranus", "Neptune"};
        for (int i = 0; i < 20; i++) {
            int randIndex = rand.nextInt(solarSystemPlanets.length);
            planets.add(solarSystemPlanets[randIndex]);
        }
        System.out.println("Список планет " + Arrays.toString(solarSystemPlanets));
        System.out.println("Наш список с названиями планет: " + planets);
        List<String> NewPlanets = planets.stream().distinct().collect(Collectors.toList());
        System.out.println("Список без повторений: " + NewPlanets);
    }
}