import java.util.Random;
import java.util.Scanner;

public class Main {
    private static final Scanner INPUT = new Scanner(System.in);            // Для ввода слов
    private static final Random random = new Random();                      // Для работы с рандомными значениями

    public static void main(String[] args) {
        String inp = INPUT.nextLine().trim();                               // Переменная input с методом trim для удаления пробелов в начале и в конце строки
        System.out.println(inp);                                            // Вывод содержимого ввода input
        String duplicateString = safeGuard(inp);                            // Переменную duplicateString приравниваем к методу по тройному дубликату строк
        System.out.println(duplicateString);                                // Вывод содержимого метода переменной duplicateString
        String outputRandom = getText(duplicateString);                     // Переменную outputRandom приравниваем к методу рандомных строк
        System.out.println(outputRandom);                                   // Вывод содержимого метода переменной duplicateString
        String right = setRight(outputRandom);                              // Переменную right приравниваем к методу расшифровки строк
        System.out.println(right);                                          // Вывод содержимого метода переменной right
    }

    static String setRight(String txt) {
        StringBuilder str = new StringBuilder();                            // Создаем строку типа StringBuilder для добавления тройных дубликатов
        for (int i = 0; i < txt.length(); i += 3) {                         // Проходим каждые 3 итерации
            if (txt.charAt(i) == txt.charAt(i + 1)) {                        // Если в начаде секции первый элемент равен соседнему, то
                str.append(txt.charAt(i));                                  // Прибавляем первый элемент секции к новой строке
            } else {                                                          // Если он не равен соседнему эелементу, то
                str.append(txt.charAt(i + 2));                              // Прибавляем третий элемент секции к новой строке
            }
        }
        return str.toString();                                              // Возвращаем строку которую преобразовали со StringBuilder к String
    }

    static String getText(String text) {
        StringBuilder str = new StringBuilder(text);                            // Создаем строку типа StringBuilder для добавления тройных дубликатов
        for (int i = 0; i < text.length(); i += 3) {                            // Создаем цикл который проходит каждые 3 шага
            int r = random.nextInt(3);                                    // Выводит рандомное число 0,1,2
            str.replace(i + r, i + r + 1, getRandomString());          // Через каждые 3 итерации выбирается рандомная позиция в диапозоне от начала рандома и до конца
        }
        return str.toString();                                                  // Возвращаем строку которую преобразовали со StringBuilder к String
    }

    static String getRandomString() {                                  // Метод для назначения маленькой и заглавной буквы
        int ul = random.nextInt(3);                              // Создаем переменную которая генерирует рандомные числа 0,1
        if (ul == 0)                                                   // ul - позиция буквы в строке
            return "" + (char) (random.nextInt(26) + 65);        // Возвращаем рандомный char с заглавными буквами
        else if (ul == 1)
            return "" + (char) (random.nextInt(26) + 97);        // Дальше возвращаем char с маленькими буквами
        else
            return "" + (char) (random.nextInt(10) + 48);       // Тут мы возвращаем char с цифрами
    }

    static String safeGuard(String str) {                                               // Метод для тройного дубликата строки
        StringBuilder output = new StringBuilder();                                     // Создаем строку типа StringBuilder для добавления тройных дубликатов
        for (int i = 0; i < str.length(); i++)                                          // Создаем цикл до длины переданной в аргумент строки
            output.append(str.charAt(i)).append(str.charAt(i)).append(str.charAt(i));   // К этой строке добавляем переданную в аргумент строку
        return output.toString();                                                       // Возвращаем строку которую преобразовали со
        // StringBuilder к String
    }
}
