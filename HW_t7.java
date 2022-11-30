package Sem.date221121.HW2;

public class HW_t7 {
    public static void main(String[] args) throws InterruptedException {
        // 7. **Сравнить время выполнения пунка 6 со строкой содержащей 10000 символов "=" средствами String и StringBuilder.

        String equal1 = new String();
        StringBuilder equal2 = new StringBuilder();
        for (int i = 0; i < 10000; i++) {
            equal1 += "=";
            equal2.append("=");
        }
        System.out.println("equal1 & equal2 ready");

        long start1 = System.nanoTime();
        // выполнение String
        for (int i = 0; i < equal1.length(); i++) {
            equal1.replace("=", "равно");
        }
        // подсчет времени
        //Thread.sleep(1000);
        long finish1 = System.nanoTime();
        long elapsed1 = finish1 - start1;
        System.out.println("Прошло времени String, нс: " + elapsed1);

        long start2 = System.nanoTime();
        // выполнение StringBuilder
            for (int j = 0; j < equal2.length(); j++) {
                equal2.replace(0, 9999, "равно");
            }
        // подсчет времени
        //Thread.sleep(1000);
        long finish2 = System.nanoTime();
        long elapsed2 = finish2 - start2;
        System.out.println("Прошло времени StringBuilder, нс: " + elapsed2);

    }
}
