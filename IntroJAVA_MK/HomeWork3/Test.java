import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;

public class Test{
    public static void main(String[] args){

        ArrayList<Integer> list = getIntList(10);
        System.out.println(list.toString());
        setOddList(list);
        System.out.println(list.toString());

        list = getIntList(5);
        System.out.println(list.toString());
        ArrayList<String> info = getInfoArray(list);
        System.out.println(info.toString());
    }

    // Метод возвращает произвольный список целых чисел
    private static ArrayList<Integer> getIntList(int lenght){
        ArrayList<Integer> list = new ArrayList<>();
        int count = 0;
        Random random = new Random();
        while (count < lenght){
            list.add(random.nextInt(lenght));
            count++;
        }
        return list;
    }

    // 1. Пусть дан произвольный список целых чисел, удалить из него четные числа 
    private static void setOddList(ArrayList<Integer> source) {
        Iterator<Integer> iterator = source.iterator();
        while (iterator.hasNext()){
            Integer tmp = (Integer) iterator.next();
            if (tmp % 2 == 0) {
                iterator.remove();
            }
        }
    }

    // 2. Задан целочисленный список ArrayList. 
    // Найти минимальное, максимальное и среднее арифметическое из этого списка.
    private static ArrayList<String> getInfoArray(ArrayList<Integer> source) {
        ArrayList<String> list = new ArrayList<>();   //[0] - min; [1] - max; [2] - avg     

        if (source == null || source.size() == 0){
            return list;
        }

        int min = source.get(0);
        int max = source.get(0);
        float avg = 0;

        for (Integer item: source) {
            if (min > item) {
                min = item;
            }
            if (max < item) {
                max = item;
            }
            avg += item;
        }

        list.add(String.format("%s - мин.", min));
        list.add(String.format("%s - макс.", max));
        list.add(String.format("%s - сред. арифм.", avg / source.size()));

        return list;
    }
}