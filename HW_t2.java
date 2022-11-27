// Второй семинар
// 1. Напишите программу на Java, чтобы найти наименьшее окно в строке, содержащей все символы другой строки.
// 2. Напишите программу на Java, чтобы проверить, являются ли две данные строки вращением друг друга.
// 3. *Напишите программу на Java, чтобы перевернуть строку с помощью рекурсии.
// 4. Дано два числа, например 3 и 56, необходимо составить следующие строки: 3 + 56 = 59 3 – 56 = -53 3 * 56 = 168 Используем метод StringBuilder.append().
// 5. Замените символ “=” на слово “равно”. Используйте методы StringBuilder.insert(),StringBuilder.deleteCharAt().
// 6. *Замените символ “=” на слово “равно”. Используйте методы StringBuilder.replace().
// 7. **Сравнить время выполнения пунка 6 со строкой содержащей 10000 символов "=" средствами String и StringBuilder.

package Sem.date221121.HW2;

import java.util.Scanner;

public class HW_t2 {
    
    public static void main(String[] args) {
        
        // 1. Напишите программу на Java, чтобы найти наименьшее окно в строке, содержащей все символы другой строки.
        Scanner iScanner = new Scanner(System.in);
        System.out.printf("Введите строку: ");
        String input_string = iScanner.nextLine();
        System.out.printf("Введите искомый набор симоволов: ");
        String pattern_str = iScanner.nextLine();
        String[] input_pattern = pattern_str.split("");
        
        int min_char = input_string.length();
        int max_char = 0;

        for (int j = 0; j < input_pattern.length; j++) {
            int temp = input_string.indexOf(input_pattern[j])+1;
            if (temp < min_char) min_char = temp;
            if (temp > max_char) max_char = temp;
            //System.out.printf("символ temp %d мин %d и мах %d\n", temp, min_char, max_char);
            }
        
        if (min_char == 0 | max_char == 0) {
            System.out.println("Какого-то символа не хватает");
        } else {
            String res_str = input_string.substring(min_char-1, max_char);
            System.out.printf("Окно <");
            System.out.printf(res_str);
            System.out.printf("> содержит все символы искомого набора: ");
            System.out.printf(pattern_str);    
        }
        iScanner.close();
    }



}
