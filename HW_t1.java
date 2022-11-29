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

public class HW_t1 {
    
    // 1. Напишите программу на Java, чтобы найти наименьшее окно в строке, содержащей все символы другой строки.
    public static void main(String[] args) {
        
        Scanner iScanner = new Scanner(System.in);
        System.out.printf("Введите строку: ");
        String input_string = iScanner.nextLine();
        System.out.printf("Введите искомый набор символов: ");
        String pattern_str = iScanner.nextLine();
        
        boolean cond = true;
        for (int i = 0; i < pattern_str.length(); i++) {
            if (input_string.indexOf(pattern_str.charAt(i)) == -1) cond = false;
        }
        if (cond == false) {
            System.out.println("Решения не найдено");
        } else {
            int size_wndw = 0;
            int start_wndw = input_string.length();
            int end_wndw = 0;

            for (int i = 0; i < pattern_str.length(); i++) {
                for (int j = 0; j < input_string.length(); j++) {
                    if (input_string.charAt(j)==pattern_str.charAt(i)) {
                        int min_char = j;
                        int max_char = 0;
                        for (int k = i; k < pattern_str.length(); k++) {
                            if (max_char < input_string.indexOf(pattern_str.charAt(k), j)) {
                                min_char = j;
                                max_char = input_string.indexOf(pattern_str.charAt(k));
                                if (size_wndw < max_char-min_char) {
                                    size_wndw = max_char-min_char;
                                    start_wndw = min_char;
                                    end_wndw = max_char;
                                }
                            }
                            
                        }
                        
                    }    
                }
            }

            String res_str = input_string.substring(start_wndw-1, end_wndw);
            System.out.printf("Окно <");
            System.out.printf(res_str);
            System.out.printf("> содержит все символы искомого набора: ");
            System.out.printf(pattern_str);    
            iScanner.close();
        }        
    }
} 

