package Sem.date221121.HW2;

import java.util.Scanner;

public class HW_t2 {
    // 2. Напишите программу на Java, чтобы проверить, являются ли две данные строки вращением друг друга.
    public static void main(String[] args) {
                       
        Scanner iScanner = new Scanner(System.in);
        System.out.printf("Введите строку: ");
        String one_string = iScanner.nextLine();
        System.out.printf("Введите вторую строку: ");
        String two_string = iScanner.nextLine();
        
        boolean spin = true;
        if (one_string.length() != two_string.length()) spin = false;
        else { 
            for (int i = 0; i < one_string.length(); i++) {
            if (one_string.charAt(i) != two_string.charAt(two_string.length()-i-1)) spin = false;
            }
        }
        System.out.printf("Первая и вторая строка ");
        String result = "не являются вращением друг друга ";
        if (spin) result = "являются вращением друг друга";
        System.out.printf(result);

        iScanner.close();
    }
}
