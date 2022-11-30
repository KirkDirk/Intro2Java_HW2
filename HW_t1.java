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
    static final int no_of_chars = 256;
    
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
        // Отбрасываем варианты когда хотя бы одного искомого символа нет в строке 
        // или длина начальной строки меньше искомой 
        if (cond == false | input_string.length()<pattern_str.length()) {
            System.out.println("Решения не найдено");
        } else {
            int start_wndw = 0;
            int start_index = -1;
            int size_wndw = input_string.length();
            
            int arr_str[] = new int[no_of_chars];
            int arr_pat[] = new int[no_of_chars];
            
            for (int i = 0; i < pattern_str.length(); i++) arr_pat[pattern_str.charAt(i)]++;

            // Начальное значение счетчика совпадений символов в строке
            int count = 0;
            for (int j = 0; j < input_string.length(); j++) {
                // Считаем вхождение символов из строки
                arr_str[input_string.charAt(j)]++;
                
                // Если символ строки совпадает с шаблоном, увеличиваем счетчик
                if (arr_str[input_string.charAt(j)] <= arr_pat[input_string.charAt(j)]) count++;
                
                // Если все символы совпадают
                if (count == pattern_str.length()) {
                    // Пробуем минимизировать окно
                    while (arr_str[input_string.charAt(start_wndw)] > arr_pat[input_string.charAt(start_wndw)]
                       || arr_pat[input_string.charAt(start_wndw)] == 0) {
 
                        if (arr_str[input_string.charAt(start_wndw)] > arr_pat[input_string.charAt(start_wndw)])
                            arr_str[input_string.charAt(start_wndw)]--;
                        start_wndw++;
                    }
 
                    // Обновляем размер окна
                    int len_wndw = j - start_wndw + 1;
                    if (size_wndw > len_wndw) {
                        size_wndw = len_wndw;
                        start_index = start_wndw;
                    }
                }
            }
                            
            String res_str = input_string.substring(start_wndw-1, start_wndw+size_wndw); // return str.substring(start_index, start_index + min_len);
            System.out.printf("Окно <");
            System.out.printf(res_str);
            System.out.printf("> содержит все символы искомого набора: ");
            System.out.printf(pattern_str);    
        }        
        iScanner.close();
    }
} 

