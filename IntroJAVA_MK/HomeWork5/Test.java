import java.util.LinkedList;

public class Test {

    public static void main(String[] args) {

        // String term = "[]{}((<>))";
        String term = "( <{8 + 6} - [7 * 4] + 78> % 44)";
        System.out.println(term);
        System.out.println(isCorrectParentheses(term));
    }

    /*
     * Написать метод, определяющую правильность расстановки скобок в выражении.
     * Могут содержаться следующие скобки: ()[]{}<>
     * () -> true
     * []{}((<>)) -> true
     * ) -> false
     * [) -> false
     * []{}(<)> -> false
     */
    private static boolean isCorrectParentheses(String parentheses) {

        String[] array = parentheses.split("");

        LinkedList<String> list = new LinkedList<>();
        for (String item : array) {
            if (item.matches("[{}()<>\\[\\]]")) {
                if (list.size() > 0
                        && (item.equals("}") && list.getLast().equals("{")
                                || item.equals(")") && list.getLast().equals("(")
                                || item.equals(">") && list.getLast().equals("<")
                                || item.equals("]") && list.getLast().equals("["))) {
                    list.removeLast();
                } else {
                    list.addLast(item);
                }
            }

        }

        return list.size() == 0;

    }

}