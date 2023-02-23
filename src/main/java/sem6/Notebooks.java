package sem6;

public class Notebooks {
    Double diagonal;
    String os;
    Integer ozu;
    Integer ssd;
    String color;
    Integer price;
    public Notebooks(Double diagonal, String os, Integer ozu, Integer ssd, String color, Integer price) {
        this.diagonal = diagonal;
        this.os = os;
        this.ozu = ozu;
        this.ssd = ssd;
        this.color = color;
        this.price = price;
    }

    public String toString() {
        return String.format("%.1f, %s, %d, %d, %s, %d",diagonal, os, ozu, ssd, color, price);
    }
}



