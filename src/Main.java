/*
Для решения задач в этом модуле нужно обязательно использовать Stream API.
Задание 1
Для набора случайно сгенерированных целых чисел нужно:
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
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        //task1();
        //task2();
        //task3();
        task4();
    }

    public static List<TVSet> factory(){
        List<TVSet> tvs = new ArrayList<TVSet>();
        tvs.add(new TVSet("P24",2020,24499.99,24,"PHILIPS"));
        tvs.add(new TVSet("S26",2021,28499.99,26,"SONY"));
        tvs.add(new TVSet("L24",2022,25499.99,24,"LG"));
        tvs.add(new TVSet("SM26",2023,29499.99,26,"SAMSUNG"));
        tvs.add(new TVSet("PN28",2026,34499.99,28,"PANASONIC"));
        return tvs;
    }

    public static void task4() {
        List<TVSet> tvs = factory();

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