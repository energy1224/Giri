import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        String fname = "input.txt";
        int[] mas1 = new int[7];
        int[] mas2 = new int[6];

        try {
            Scanner sc = new Scanner(new File(fname));
            for (int i = 0; i < mas1.length; i++)
                mas1[i] = sc.nextInt();
            for (int k = 0; k < mas2.length; k++)
                mas2[k] = sc.nextInt();
            System.out.print("Первый набор гирь: ");
            printMassiv(mas1);
            System.out.print("Второй набор гирь: ");
            printMassiv(mas2);

            int res = findLooseGiria(mas1, mas2);
            System.out.println("Во втором наборе не хватает гири весом " + res + " грамм");

        } catch (FileNotFoundException e) {
            System.out.println("Не найден файл input.txt");
        }
    }
    public static void printMassiv(int[] mas) {
        for (int i : mas) {
            System.out.print(i);
        }
        System.out.println();
    }
    public static int summMas(int[] mas) {
        int result = 0;
        for (int ma : mas) {
            result = result + ma;
        }
        return result;
    }
    public static int findLooseGiria(int[] mas1, int[] mas2){
        int summaMas2 = summMas(mas2);
        int summaMas1 = summMas(mas1);
        int left = 0;
        int right = mas1.length - 1;
        while (left <= right) {
            int middle = (left + right) / 2;
            int current = mas1[middle];
            if (summaMas2 == summaMas1 - current) {
                return current;
            }
            if (summaMas2 < summaMas1 - current) {
                left = middle + 1;
            } else {
                right = middle - 1;
            }
        }
        return -1;
    }
}
