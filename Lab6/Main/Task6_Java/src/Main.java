import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

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

        List<Integer> test10 = Arrays.asList(2,3,5,8,11,12,15,17);
        double averagePrimes = calculateAveragePrimes(test10);
        double result10 = calculateAverageNonPrimes(test10, averagePrimes);
        System.out.println(result10);

        List<Integer> test11 = Arrays.asList(1,2,3,4,6,8,9,12,18,24,27);
        List<List<Integer>> result11 = fiveKortez(test11);
        System.out.println(result11);

        List<Integer> test12 = Arrays.asList(12,15,8,6,14,21,18,24);
        List<Integer> result12 = calculateP(test12);
        System.out.println(result12);

        List<Integer> test13 = Arrays.asList(1,4,8,16,25,36,49,64,81,256);
        List<List<Integer>> result13 = threeKortez(test13);
        System.out.println(result13);
    }

    //6.38 Дан целочисленный массив и отрезок a..b. Необходимо найти количество
    //элементов, значение которых принадлежит этому отрезку.
    public static int countInRange(int[] array, int a, int b) {
        return (int) Arrays.stream(array).filter(x -> x >= a && x <= b).count();
    }

    //6.43 Дан целочисленный массив. Необходимо найти количество минимальных
    //элементов.
    public static int countMinElements(int[] array) {
        int minElement = Arrays.stream(array).min().orElse(Integer.MAX_VALUE);
        return (int) Arrays.stream(array).filter(x -> x == minElement).count();
    }

    //6.53 Для введенного списка построить новый с элементами, большими, чем среднее
    //арифметическое списка, но меньшими, чем его максимальное значение.
    public static List<Integer> filterList(List<Integer> numbers) {
        Double average = numbers.stream().mapToInt(Integer::intValue).average().orElse(0.0);
        Integer max = numbers.stream().max(Integer::compareTo).orElse(0);
        return numbers.stream().filter(x -> x > average && x < max).collect(Collectors.toList());
    }

    //6.56 Для введенного списка посчитать среднее арифметическое непростых элементов,
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

    public static class Tuple5<A, B, C, D, E> {
        public final A first;
        public final B second;
        public final C third;
        public final D fourth;
        public final E fifth;

        public Tuple5(A first, B second, C third, D fourth, E fifth) {
            this.first = first;
            this.second = second;
            this.third = third;
            this.fourth = fourth;
            this.fifth = fifth;
        }

        public List<List<Integer>> toList() {
            return List.of((List<Integer>) first, (List<Integer>) second, (List<Integer>) third, (List<Integer>) fourth, (List<Integer>) fifth);
        }
    }
    //7.2 Дан список, построить кортеж, содержащий пять списков
    public static List<List<Integer>> fiveKortez(List<Integer> list) {
        Tuple5<List<Integer>, List<Integer>, List<Integer>, List<Integer>, List<Integer>> result = fiveKortezz(list);
        return result.toList();
    }
    public static Tuple5<List<Integer>, List<Integer>, List<Integer>, List<Integer>, List<Integer>> fiveKortezz(List<Integer> list) {
        List<Integer> firstList = list.stream().filter(i -> i % 2 == 0).map(i -> i / 2).collect(Collectors.toList());
        List<Integer> secondList = firstList.stream().filter(i -> i % 3 == 0).map(i -> i / 3).collect(Collectors.toList());
        List<Integer> thirdList = secondList.stream().map(i -> i * i).collect(Collectors.toList());
        List<Integer> fourthList = thirdList.stream().filter(firstList::contains).collect(Collectors.toList());
        List<Integer> fifthList = Stream.concat(Stream.concat(secondList.stream(), thirdList.stream()), fourthList.stream()).collect(Collectors.toList());
        return new Tuple5<>(firstList, secondList, thirdList, fourthList, fifthList);
    }

    //7.7 для введенного списка построить новый список, который получен из начального упорядочиванием по параметру P(a)
    public static List<Integer> calculateP(List<Integer> list) {
        return list.stream().sorted(Comparator.comparingInt(a -> calculatePP(a, list))).collect(Collectors.toList());
    }
    public static int calculatePP(int a, List<Integer> list) {
        Set<Integer> evenPositionDivisors = list.stream().filter(i -> list.indexOf(i) % 2 == 1)
                .flatMap(i -> getDivisors(i).stream()).collect(Collectors.toSet());
        double average = list.stream().mapToInt(Integer::intValue).average().orElse(0);
        Set<Integer> belowAverageDivisors = list.stream().filter(i -> i < average)
                .flatMap(i -> getDivisors(i).stream()).collect(Collectors.toSet());
        return getDivisors(a).stream().filter(i -> evenPositionDivisors.contains(i) && !belowAverageDivisors.contains(i)).mapToInt(Integer::intValue).sum();
    }
    public static List<Integer> getDivisors(int number) {
        return IntStream.rangeClosed(1, number).filter(i -> number % i == 0).boxed().collect(Collectors.toList());
    }

    public static class Result {
        int number;
        int sum;
        int count;

        Result(int number, int sum, int count) {
            this.number = number;
            this.sum = sum;
            this.count = count;
        }
    }
    //7.9 Дан список, в итоговый список включить кортеж (число, сумма предыдущих, количество элементов в
    //списке больше заданного)
    public static List<List<Integer>> threeKortez(List<Integer> list) {
        List<Result> result = buildNewList(list);
        return result.stream().map(r -> List.of(r.number, r.sum, r.count)).collect(Collectors.toList());
    }
    public static List<Result> buildNewList(List<Integer> list) {
        List<Integer> cumulativeSums = new ArrayList<>();
        cumulativeSums.add(0);
        for (int i = 0; i < list.size(); i++) {
            cumulativeSums.add(cumulativeSums.get(i) + list.get(i));
        }
        cumulativeSums = cumulativeSums.subList(1, cumulativeSums.size());

        List<Integer> finalCumulativeSums = cumulativeSums;
        return IntStream.range(1, list.size()).mapToObj(index -> {
            int number = list.get(index);
            int sumPrevious = finalCumulativeSums.get(index - 1);
            List<Integer> previousElements = list.subList(0, index);
            if (number > sumPrevious && isPerfectSquare(number, list) && isDivisibleByAll(number, previousElements)) {
                int countGreaterThan = (int) list.stream().filter(i -> i > number).count();
                return new Result(number, sumPrevious, countGreaterThan);
            } else {
                return null;
            }
        }).filter(Objects::nonNull).collect(Collectors.toList());
    }
    private static boolean isPerfectSquare(int number, List<Integer> list) {
        return list.stream().anyMatch(i -> i == number * number);
    }
    private static boolean isDivisibleByAll(int number, List<Integer> previousElements) {
        return previousElements.stream().allMatch(i -> number % i == 0);
    }
}