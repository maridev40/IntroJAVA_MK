import java.util.Arrays;

public class Main {

public static void main(String[] args) {
    System.out.println(isSumBetween10And20(5, 15)); // true
    System.out.println(isSumBetween10And20(7, 15)); // false

    System.out.println(isPositive(5));

    printString("abcd", 5); // abcdabcdabcdabcdabcd

    System.out.println(isLeapYear(2020));

    System.out.println(Arrays.toString(createArray(10, 7)));

    int[][] array = new int[][] {{1, 0, 0, 0}, {0, 1, 0, 0}, {0, 0, 1, 0}, {0, 0, 0, 1}};
    int x = array[2][3];
    System.out.println(x);

    String[] stringArray = {"aaa", "aab", "aa"};
    System.out.println(findCommonPrefix(stringArray)); // aa
    String[] stringArray2 = {"abc", "bca", "cda"};
    System.out.println(findCommonPrefix(stringArray2)); // ""

    int[] arr = new int[] {1, 1, 0, 0, 1, 0, 1, 1, 0, 0};
    changeIntArray(arr);
    System.out.println(Arrays.toString(arr));
}

/**
 * 1. Написать метод, принимающий на вход два целых числа и проверяющий,
 * что их сумма лежит в пределах от 10 до 20 (включительно), если да – вернуть true, в противном случае – false.
 */
private static boolean isSumBetween10And20(int a, int b) {
    // проверить, что сумма a и b лежит между 10 и 20
    int sum = a + b;
    return sum >= 10 && sum <= 20;
}

private static boolean isPositive(int x) {
    // проверить, что х положительное
    return x > 0;
}

private static void printString(String source, int repeat) {
    // напечатать строку source repeat раз
    System.out.println(source.repeat(repeat));
}

private static boolean isLeapYear(int year) {
    // проверить, является ли год високосным. если да - return true
    return year % 4 == 0;
}

private static int[] createArray(int len, int initalValue) {
    // должен вернуть массив длины len, каждое значение которого равно initialValue
    int[] arr = new int[len];
    for (int i = 0; i < arr.length; i++) {
        arr[i] = initalValue;
    }
    return arr;
}

private static String findCommonPrefix(String[] source) {
    /** Найти общий префикс среди слов из одного массива.
     * ["aaa", "aab", "aa"] -> "aa", ["abc", "bca", "cda"] -> ""
     */
    int len = source[0].length();
    String pref = "";
    boolean stop = false;
    for (int i = 0; i < len; i++) {
        int tmp = 0;
        for (int j = 1; j < source.length; j++) {

            if (i < source[j].length())
                if (source[0].charAt(i) == source[j].charAt(i)) {
                    tmp++;
                } 
                else {
                    stop = true; 
                    break;
                }
                
            if (tmp == source.length - 1) {
                pref += source[0].charAt(i);
            }   
        }
        if (stop) {
            break;
        }
    }

    return pref;
}


private static void changeIntArray(int[] source) {
    // 1. Задать целочисленный массив, состоящий из элементов 0 и 1.
    // Например: [ 1, 1, 0, 0, 1, 0, 1, 1, 0, 0 ]. С помощью цикла и условия заменить 0 на 1, 1 на 0;
    for (int i = 0; i < source.length; i++) {
        source[i] = 1 - source[i];
        }  
}

 /** 2. Задать массив [ 1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1 ] пройти по нему циклом, и числа меньшие 6 умножить на 2;
 * 3. Создать квадратный двумерный целочисленный массив (количество строк и столбцов одинаковое),
 * и с помощью цикла(-ов) заполнить его диагональные элементы единицами (можно только одну из диагоналей, если обе сложно). 
 * Определить элементы одной из диагоналей можно по следующему принципу: индексы таких элементов равны, то есть [0][0], [1][1], [2][2], …, [n][n];
 * 4. Задать одномерный массив и найти в нем минимальный и максимальный элементы ;
 */
}