public class Car {

    private String name;
    private int year;
    private double price;
    private String color;
    private int volume;

    public Car(String name, int year, double price, String color, int volume) {
        this.name = name;
        this.year = year;
        this.price = price;
        this.color = color;
        this.volume = volume;
    }

    public String getName() { return name; }
    public int getYear() { return year; }
    public double getPrice() { return price; }
    public String getColor() { return color; }
    public int getVolume() { return volume; }

    @Override
    public String toString() {
        return "Автомобиль> " +
                "наименование: " + name +
                ", год выпуска: " + year +
                ", цена: " + price +
                ", цвет: " + color +
                ", объём двигателя: " + volume;
    }
}
