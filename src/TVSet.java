public class TVSet {

    private String model;
    private int year;
    private double price;
    private int diagonal;
    private String manufacturer;

    public TVSet(String model, int year, double price, int diagonal, String manufacturer) {
        this.model = model;
        this.year = year;
        this.price = price;
        this.diagonal = diagonal;
        this.manufacturer = manufacturer;
    }

    public String getModel() { return model; }
    public int getYear() { return year; }
    public double getPrice() { return price; }
    public double getDiagonal() { return diagonal; }
    public String getManufacturer() { return manufacturer; }

    @Override
    public String toString() {
        return "Телевизор> " +
                "модель: " + model +
                ", год выпуска: " + year +
                ", цена: " + price +
                ", диагональ: " + diagonal +
                ", производитель: " + manufacturer;
    }
}
