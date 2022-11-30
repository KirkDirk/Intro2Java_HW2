package Sem.date221121.HW2;

public class HW_t4 {
    public static void main(String[] args) {

// 4. Дано два числа, например 3 и 56, 
// необходимо составить следующие строки: 3 + 56 = 59 3 – 56 = -53 3 * 56 = 168 Используем метод StringBuilder.append().        

        int num1 = 3; int num2 = 56;
        StringBuilder result = new StringBuilder("");
        result.append(num1);
        result.append(" + ");
        result.append(num2);
        result.append(" = ");
        result.append(num1 + num2);
        System.out.println(result);
        result.setLength(0);
        result.append(num1 + " - " + num2 + " = " + (num1-num2));
        System.out.println(result);
        StringBuilder result1 = new StringBuilder("");
        result1.append(num1 + " * " + num2 + " = " + (num1*num2));
        System.out.println(result1);
        
// 5. Замените символ “=” на слово “равно”. Используйте методы StringBuilder.insert(),StringBuilder.deleteCharAt().

        result.deleteCharAt(7);
        result.insert(7, " равно");
        System.out.println(result);  

// 6. *Замените символ “=” на слово “равно”. Используйте методы StringBuilder.replace().

        result1.replace(6, 8, " равно ");
        System.out.println(result1);

    }
}
