import java.util.LinkedList;
import java.util.Scanner;

public class Test {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        boolean run = true;
        LinkedList<String> list = new LinkedList<>();

        while (run) {
            System.out.print("text~num: ");
            
            String str = scanner.nextLine();
            if (str.equals("exit")) {
                run = false;
            }

            String[] array = str.split("~");
            if (array.length == 2 && array[0].length() > 0
                    && array[1].length() > 0
                    && array[1].replaceAll("[0-9]", "").length() == 0) {

                int index = Integer.parseInt(array[1]);

                if (array[0].equals("print")) {
                    if (index < list.size()) {
                        System.out.println(list.get(index));
                        list.set(index, null);
                    }
                } else {

                    if (list.size() - 1 < index) {
                        int count = list.size();
                        while (count <= index) {
                            list.add(count, null);
                            count++;
                        }
                    }

                    list.set(index, array[0]);
                }
            }
        }

        scanner.close();
        System.out.println(list.toString());

    }
    
}    