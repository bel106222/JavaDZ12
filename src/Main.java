/*
Для решения задач в этом модуле нужно обязательно использовать Stream API.
Задание 1
Для набора случайно сгенерированных целых чисел нужно посчитать:
- Количество четных;
- Количество нечетных;
- Количество равных 0;
- Количество равных значению, введенному пользователем.
Задание 2
Для набора названий городов (города могут повторяться) нужно:
- Показать все города;
- Показать все города с названием длиннее шесть символов;
- Посчитать сколько раз встречается город, чье название ввёл пользователь;
- Показать все города, которые начинаются на заданную букву.
Задание 3
Создайте класс «Автомобиля». Он должен хранить информацию о названии
автомобиля, год выпуска, цена, цвет, объем двигателя. Нужно создать
набор автомобилей и выполнить следующие задачи:
Показать все автомобили;
Показать все автомобили заданного цвета;
Показать все автомобили заданного объёма;
Показать все автомобили дороже заданной цены;
Показать все автомобили чей год выпуска находится в указанном диапазоне.
Задание 4
Создайте класс «Телевизор». Он должен хранить информацию о названии модели,
год выпуска, цена, диагональ, производитель. Нужно создать набор телевизоров
и выполнить следующие задачи:
Показать все телевизоры;
Показать телевизоры с заданной диагональю;
Показать все телевизоры одного производителя;
Показать все телевизоры текущего года;
Показать все телевизоры дороже заданной цены;
Показать все телевизоры, отсортированные по цене по возрастанию;
Показать все телевизоры, отсортированные по цене по убыванию;
Показать все телевизоры, отсортированные по диагонали по возрастанию;
Показать все телевизоры, отсортированные по диагонали по убыванию.
*/

import java.time.Year;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("ЗАДАНИЕ 1:");
        task1();
        System.out.println("\nЗАДАНИЕ 2:");
        task2();
        System.out.println("\nЗАДАНИЕ 3:");
        task3();
        System.out.println("\nЗАДАНИЕ 4:");
        task4();
        scanner.close();
    }

    private static String getStringInput(String prompt) {
        System.out.print(prompt);
        return scanner.nextLine().trim();
    }

    private static int getNumber(String prompt) {
        int number = 0;
        while (true) {
            System.out.print(prompt);
            if (scanner.hasNextInt()) {
                number = scanner.nextInt();
                scanner.nextLine();
                break;
            } else {
                System.out.println("Ошибка: введено не целое число, попробуйте снова...");
                scanner.next(); // Очистка неверного ввода
            }
        }
        return number;
    }

    public static int[] intFactory(){
        int size = 10;
        int min = 1;
        int max = 100;
        Random random = new Random();
        return random.ints(size, min, max + 1).toArray();
    }

    public static List<String> cityFactory(){
        List<String> cities = new ArrayList<String>();
        cities.add("Москва");
        cities.add("Ставрополь");
        cities.add("Омск");
        cities.add("Владивосток");
        return cities;
    }

    public static List<Car> carFactory(){
        List<Car> cars = new ArrayList<Car>();
        cars.add(new Car("Лада 2101",1980,244499.99,"белый",1200));
        cars.add(new Car("Ока",1999,284499.99,"красный",1000));
        cars.add(new Car("Форд Мондео",2002,544499.99,"чёрный",2000));
        cars.add(new Car("Лада 2109",1990,299499.99,"чёрный",1500));
        return cars;
    }

    public static List<TVSet> tvFactory(){
        List<TVSet> tvs = new ArrayList<TVSet>();
        tvs.add(new TVSet("P24",2020,24499.99,24,"PHILIPS"));
        tvs.add(new TVSet("S26",2021,28499.99,26,"SONY"));
        tvs.add(new TVSet("L24",2022,25499.99,24,"LG"));
        tvs.add(new TVSet("SM26",2023,29499.99,26,"SAMSUNG"));
        tvs.add(new TVSet("PN28",2026,34499.99,28,"PANASONIC"));
        return tvs;
    }

    public static void task1() {
        int find = getNumber("Введите целое число от 0 до 100:>");
        int [] intArray = intFactory();
        System.out.print("Сгенерирован массив: ");
        for (int num : intArray) {
            System.out.print(num + " ");
        }

        System.out.println("\nКоличество чётных: " +
                Arrays.stream(intArray).filter(n -> n % 2 == 0).count());
        System.out.println("Количество нечётных: " +
                Arrays.stream(intArray).filter(n -> n % 2 != 0).count());
        System.out.println("Количество нулей: " +
                Arrays.stream(intArray).filter(n -> n == 0).count());
        System.out.println("Количество чисел, равных " +
                find + ": " +Arrays.stream(intArray).filter(n -> n == find).count());
    }

    public static void task2() {
        List<String> cities = cityFactory();

        System.out.println("Все города:");
        cities.stream().forEach(System.out::println);

        System.out.println("\nГорода, где длина наименования больше 6 символов:");
        cities.stream()
                .filter(str-> str.length() > 6)
                .forEach(System.out::println);

        String currentCity = getStringInput("\nВведите название города для подсчёта: ");
        long count = cities.stream()
                .filter(city -> city.equalsIgnoreCase(currentCity))
                .count();
        System.out.println("Город '" + currentCity + "' встречается " + count + " раз.");

        char currentLetter = getStringInput("\nВведите букву для поиска городов: ").toUpperCase().charAt(0);
        System.out.println(
                "Города, начинающиеся на букву '" +
                currentLetter +
                "': " +
                cities.stream()
                    .filter(city -> !city.isEmpty() && city.toUpperCase().charAt(0) == currentLetter)
                    .distinct() // чтобы не было повторов
                    .collect(Collectors.toList())
        );
    }

    public static void task3() {
        List<Car> cars = carFactory();

        System.out.println("Все автомобили:");
        cars.stream().forEach(System.out::println);

        System.out.println("\nВсе автомобили чёрного цвета:");
        cars.stream()
                .filter(car -> car.getColor().equals("чёрный"))
                .forEach(System.out::println);

        System.out.println("\nВсе автомобили с объёом двигателя 2000:");
        cars.stream()
                .filter(car -> car.getVolume() == 2000)
                .forEach(System.out::println);

        System.out.println("\nВсе автомобили стоимостью больше 500т.р.:");
        double currentPrice = 500000;
        cars.stream()
                .filter(car -> car.getPrice() > currentPrice)
                .forEach(System.out::println);

        System.out.println("\nВсе автомобили год выпуска которых с 1980 по 2000:");
        int begin = 1980;
        int end = 2000;
        cars.stream()
                .filter(car -> car.getYear() >= begin && car.getYear() <= end)
                .forEach(System.out::println);
    }

    public static void task4() {
        List<TVSet> tvs = tvFactory();

        System.out.println("Все телевизоры:");
        tvs.stream().forEach(System.out::println);

        System.out.println("\nТелевизоры с диагональю 24:");
        tvs.stream()
                .filter(tv -> tv.getDiagonal() == 24)
                .forEach(System.out::println);

        System.out.println("\nТелевизоры SAMSUNG:");
        tvs.stream()
                .filter(tv -> tv.getManufacturer().equals("SAMSUNG"))
                .forEach(System.out::println);

        System.out.println("\nТелевизоры текущего года:");
        tvs.stream()
                .filter(tv -> tv.getYear() == Year.now().getValue())
                .forEach(System.out::println);

        double currentPrice = 25000;
        System.out.println("\nТелевизоры дороже " + currentPrice + ":");
        tvs.stream()
                .filter(tv -> tv.getPrice() > currentPrice)
                .forEach(System.out::println);

        System.out.println("\nТелевизоры по возрастанию цены:");
        tvs.stream()
                .sorted(Comparator.comparingDouble(TVSet::getPrice))
                .forEach(System.out::println);

        System.out.println("\nТелевизоры по убыванию цены:");
        tvs.stream()
                .sorted(Comparator.comparingDouble(TVSet::getPrice).reversed())
                .forEach(System.out::println);

        System.out.println("\nТелевизоры по возрастанию диагонали:");
        tvs.stream()
                .sorted(Comparator.comparingDouble(TVSet::getDiagonal))
                .forEach(System.out::println);

        System.out.println("\nТелевизоры по убыванию диагонали:");
        tvs.stream()
                .sorted(Comparator.comparingDouble(TVSet::getDiagonal).reversed())
                .forEach(System.out::println);
    }
}