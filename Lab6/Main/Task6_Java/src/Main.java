import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        int[] test7 = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int a = 3;
        int b = 7;
        int count = countInRange(test7, a, b);
        System.out.println(count);

        int[] test8 = {1,1,5,3,1,6,3,7,1};
        int result8 = countMinElements(test8);
        System.out.println(result8);

        List<Integer> test9 = Arrays.asList(1,2,3,4,5,6,7,8,9,10);
        List<Integer> result9 = filterList(test9);
        System.out.println(result9);

        List<Integer> numbers = Arrays.asList(2, 3, 5, 8, 11, 12, 15, 17);
        List<Integer> test10 = Arrays.asList(2,3,5,8,11,12,15,17);
        double averagePrimes = calculateAveragePrimes(numbers);
        double result10 = calculateAverageNonPrimes(numbers, averagePrimes);
        System.out.println(result10);
    }

    //5.38 Дан целочисленный массив и отрезок a..b. Необходимо найти количество
    //элементов, значение которых принадлежит этому отрезку.
    public static int countInRange(int[] array, int a, int b) {
        return (int) Arrays.stream(array).filter(x -> x >= a && x <= b).count();
    }

    //5.43 Дан целочисленный массив. Необходимо найти количество минимальных
    //элементов.
    public static int countMinElements(int[] array) {
        int minElement = Arrays.stream(array).min().orElse(Integer.MAX_VALUE);
        return (int) Arrays.stream(array).filter(x -> x == minElement).count();
    }

    //5.53 Для введенного списка построить новый с элементами, большими, чем среднее
    //арифметическое списка, но меньшими, чем его максимальное значение.
    public static List<Integer> filterList(List<Integer> numbers) {
        Double average = numbers.stream().mapToInt(Integer::intValue).average().orElse(0.0);
        Integer max = numbers.stream().max(Integer::compareTo).orElse(0);
        return numbers.stream().filter(x -> x > average && x < max).collect(Collectors.toList());
    }

    //5.56 Для введенного списка посчитать среднее арифметическое непростых элементов,
    //которые больше, чем среднее арифметическое простых.
    public static double calculateAveragePrimes(List<Integer> numbers) {
        return numbers.stream()
                .filter(num -> isPrime(num, 2))
                .mapToInt(Integer::intValue)
                .average()
                .orElse(0.0);
    }
    public static double calculateAverageNonPrimes(List<Integer> numbers, double averagePrimes) {
        return numbers.stream()
                .filter(num -> !isPrime(num, 2))
                .filter(num -> num > averagePrimes)
                .mapToInt(Integer::intValue)
                .average()
                .orElse(0.0);
    }
    public static boolean isPrime(int n, int k) {
        if (n <= 1) {
            return false;
        } else if (n == k) {
            return true;
        } else if (n % k == 0) {
            return false;
        } else {
            return isPrime(n, k + 1);
        }
    }
}