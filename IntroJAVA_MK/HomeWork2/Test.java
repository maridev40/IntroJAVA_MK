import java.io.BufferedOutputStream;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;

public class Test {

    public static void main(String[] args) throws IOException {
        
        String str = "шалаш";
        if (isPalindrome(str))
            System.out.println(str + " - это Палиндром");
        else 
            System.out.println(str + " - это не Палиндром");

        setTest();

    }

    // 1. Создать метод, который проверяет, является ли строка палиндромом.
    // Палиндром - шалаш
    private static boolean isPalindrome(String source) {
        if (source.length() == 0) {
            return false;
        }
        
        boolean palindrom = true;

        String[] arr = source.split("");
        for (int i = 0; i < arr.length - 1 && !palindrom; ++i) {
            if (!arr[i].equals(arr[arr.length - 1 - i])) {
                palindrom = false;
            }
        }

        return palindrom;
    }

    // 2. С помощью Java создать файл file.txt, и записать в него слово TEST 100 раз.
    // Если уже файл создан, то перезаписываем его.
    private static void setTest() {
        
        StringBuilder text = new StringBuilder();

        int count = 0;
        while (count < 100) {
            text.append("TEXT");
            count++;
        }
        Path file = Path.of("file.txt");
        try (BufferedOutputStream stream = new BufferedOutputStream(Files.newOutputStream(file))) {
            Charset utf8 = StandardCharsets.UTF_8;
            byte[] buffer = text.toString().getBytes(utf8);
            stream.write(buffer, 0, buffer.length);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}