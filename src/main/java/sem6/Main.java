package sem6;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Map<Integer, LinkedHashMap> database = new HashMap<>();
        Integer id = 1;
        Notebooks notebook1 = new Notebooks(15.6, "Windows 10", 8, 256, "black", 65999);
        Notebooks notebook2 = new Notebooks(14.6, "Linux 11", 16, 1024, "silver", 85666);
        Notebooks notebook3 = new Notebooks(14.0, "MacOs",
                16, 512, "gold", 101888);
        Notebooks notebook4 = new Notebooks(15.0, "Windows 10", 4, 256, "white", 61780);
        Notebooks notebook5 = new Notebooks(15.6, "MacOs", 8, 256, "silver", 95890);
        Notebooks notebook6 = new Notebooks(14.6, "Windows 8", 8, 128, "black", 45890);
        addNotebookInDataBase(database, notebook1, id);
        id++;
        addNotebookInDataBase(database, notebook2, id);
        id++;
        addNotebookInDataBase(database, notebook3, id);
        id++;
        addNotebookInDataBase(database, notebook4, id);
        id++;
        addNotebookInDataBase(database, notebook5, id);
        id++;
        addNotebookInDataBase(database, notebook6, id);
        System.out.println(database);
        System.out.println();

        searchNb(database);
    }

    public static Map addNotebookInDataBase(Map spisok, Notebooks nb, Integer newId) {
        ArrayList<String> newNb = new ArrayList<>(Arrays.asList(nb.toString().split(", ")));
        Map<String, String> info = new LinkedHashMap<String, String>();
        String[] infoName = {"diagonal", "os", "ozu", "ssd", "color", "price"};
        Integer i = 0;
        for (String str : newNb) {
            info.put(infoName[i], str);
            i++;
        }
        spisok.put(newId, info);
        return spisok;
    }

    public static void searchNb(Map spisok) {
        Double findDiag = 0.0;
        Integer findOzu = 0;
        Integer findSsd = 0;
        String findColor = "none";
        Integer findPrice = 0;
        Map searchCriterii = new HashMap<>();
        searchCriterii.put("diagonal", findDiag);
        searchCriterii.put("ozu", findOzu);
        searchCriterii.put("ssd", findSsd);
        searchCriterii.put("color", findColor);
        searchCriterii.put("price", findPrice);
        Map searchCriteriiZero = new HashMap<>();
        searchCriteriiZero.putAll(searchCriterii);

        Scanner input = new Scanner(System.in, "cp866");

        while (true) {
            System.out.print("???????????????? ????????????: ");
            System.out.println(searchCriterii);
            System.out.println("???????????????? ???????????????? ?????? ????????????:\n" +
                    "1 - ?????????????????? (?????????????????????? ????????????????)\n" +
                    "2 - ozu (?????????????????????? ????????????????)\n" +
                    "3 - ssd (?????????????????????? ????????????????)\n" +
                    "4 - ????????\n" +
                    "5 - ???????? (?????????????????????? ????????????????)\n" +
                    "result - ?????????????? ???????????? ???????????????? ??????????????\n" +
                    "clear - ???????????????? ????????????\n" +
                    "close - ?????? ???????????? ???? ????????????");
            String comand = input.next();
            switch (comand) {
                case "close":
                    input.close();
                    System.exit(1);
                case "1":
                    System.out.println("?????????????? ??????????????????");
                    findDiag = input.nextDouble();
                    searchCriterii.put("diagonal", findDiag);
                    break;
                case "2":
                    System.out.println("?????????????? ozu");
                    findOzu = input.nextInt();
                    searchCriterii.put("ozu", findOzu);
                    break;
                case "3":
                    System.out.println("?????????????? ssd");
                    findSsd = input.nextInt();
                    searchCriterii.put("ssd", findSsd);
                    break;
                case "4":
                    System.out.println("?????????????? ????????");
                    findColor = input.next();
                    searchCriterii.put("color", findColor);
                    break;
                case "5":
                    System.out.println("?????????????? ??????????????????");
                    findPrice = input.nextInt();
                    searchCriterii.put("price", findPrice);
                    break;
                case "result":
                    boolean temp = false;
                    for (int index = 1; index <= spisok.size(); index++) {
                        if (Double.parseDouble(((String) ((Map) spisok.get(index)).get("diagonal")).replace(",", ".")) >= findDiag || findDiag == 0.0) {
                            if (Integer.parseInt(((String) ((Map) spisok.get(index)).get("ozu"))) >= findOzu || findOzu == 0) {
                                if (Integer.parseInt(((String) ((Map) spisok.get(index)).get("ssd"))) >= findSsd || findSsd == 0) {
                                    if ((((Map) spisok.get(index)).get("color").equals(findColor)) || findColor == "none") {
                                        if (Integer.parseInt(((String) ((Map) spisok.get(index)).get("price"))) >= findOzu || findOzu == 0) {
                                            System.out.println(spisok.get(index));
                                            temp = true;
                                        }
                                    }
                                }
                            }
                        }
                    }
                    if (!temp) {
                        System.out.println("?????? ?????????????????? ?????????????????????????????? ??????????????????");
                    }
                    break;
                case "clear":
                    searchCriterii.putAll(searchCriteriiZero);
                default:
                    System.out.println("?????????????? ?????????????? ????????????");
                    break;
            }
        }
    }
}