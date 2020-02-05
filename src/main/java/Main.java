import java.util.Arrays;
import java.util.Scanner;
/**
 * @author Krasyuk Vladimir Andreevich Cheliabins 2020
 */
public class Main {
    public static void main(String[] args){
        ConundrumSolver solver = new ConundrumSolveAlgorithm();
        System.out.println("Введите массив через пробел");
        Scanner console = new Scanner(System.in);
        String str = console.nextLine();
        System.out.println("Решение");
        System.out.println(Arrays.toString(
                           solver.resolve(
                           strToArrayParse(str))));
    }
    static private int[] strToArrayParse(String str){
        String strArr[] = str.split(" ");
        int numArr[] = new int[strArr.length];
        for (int i = 0; i < strArr.length; i++) {
            numArr[i] = Integer.parseInt(strArr[i]);

        }
        return  numArr;
    }
}
