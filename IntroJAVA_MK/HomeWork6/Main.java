import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        // Кот (имя, аппетит, сытность)
        // Тарелка (содержит какое-то количество еды)
        // Кот ест из тарелки. Если в тарелке недостаточно еды - кот ее не трогает

        // ДЗ:
        // while (true) -> while (!plate.isEmpty())
        // 1. Создать массив котов. Пусть все коты из массива по очереди едят из одной тарелки.
        // В конце каждого цикла мы досыпаем в тарелку еду.
        // Для досыпания еды сделать метод increaseFood в классе Plate.
        // 2. Поменять поле satiety у кота с boolean на int.
        // Допустим у кота апптит 10, сыт	ность 3. Значит кот захочет поесть 7 единиц.
        // 3. * Доработать поток thread в классе Cat, чтобы он каждую секунду УВЕЛИЧИВАЛ сытость кота на 1.

        Cat murzik = new Cat("Murzik", 15, 5);
        Cat barsik = new Cat("Barsik"); // appetite = 10; satiety = 3

        Plate plate = new Plate(500);  // 200

        List<Cat> cats = new ArrayList<>();
        cats.add(murzik);
        cats.add(barsik);
 
       while (!plate.isEmpty() && !IsAllSatiety(cats)) {
            plate.increaseFood(2);

            for (Cat cat: cats) {
                cat.eat(plate);
            }

            System.out.println(plate);

            for (Cat cat: cats) {
                System.out.println(cat);
            }

            Thread.sleep(1000);

       }
    }

    public static boolean IsAllSatiety(List<Cat> list) { 
        for (Cat cat: list) {
            if (cat.isHungry()) {
                return false;
            }
        }

        return true;
    }

}