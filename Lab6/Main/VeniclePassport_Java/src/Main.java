import java.util.*;

public class Main {
    public static void main(String[] args) {
        List<VehiclePassport> m = new ArrayList<>();
        VehiclePassport u1 = new VehiclePassport("John", "AG", "897609", "14.05.2020");
        VehiclePassport u2 = new VehiclePassport("Vanya", "FK", "125456", "01.12.2021");
        VehiclePassport u3 = new VehiclePassport("Max", "BN", "124905", "30.06.2020");
        VehiclePassport u4 = new VehiclePassport("Tailer", "QA", "567842", "01.01.2020");
        VehiclePassport u5 = new VehiclePassport("Jho", "QA", "567842", "01.01.2020");

        m.add(u1);
        m.add(u2);
        m.add(u3);
        m.add(u4);

        for (VehiclePassport i : m) i.write();

        System.out.println("Сортировка:");
        Collections.sort(m);
        for (VehiclePassport i : m) i.write();

        System.out.println("HashSet:");
        Set<VehiclePassport> h = new HashSet<>();
        h.add(u1);
        h.add(u2);
        h.add(u3);
        h.add(u4);
        h.add(u5);

        for (VehiclePassport i : h) i.write();

        System.out.println(h.contains(new VehiclePassport("Smite", "AB", "123456", "01.01.2020")));
        System.out.println(h.contains(new VehiclePassport("Kling", "EF", "789012", "01.01.2021")));

        TreeSet<VehiclePassport> dateSortedSet = new TreeSet<>(Comparator.comparing(VehiclePassport::getIssueDate));
        dateSortedSet.addAll(m);
        System.out.println("Сортировка по дате:");
        for (VehiclePassport i : dateSortedSet) {
            i.write();
        }

        TreeSet<VehiclePassport> seriesNumberSortedSet = new TreeSet<>(Comparator.comparing(VehiclePassport::getSeries)
                .thenComparing(VehiclePassport::getNumber));
        seriesNumberSortedSet.addAll(m);
        System.out.println("Сортировка по серии и номеру:");
        for (VehiclePassport i : seriesNumberSortedSet) {
            i.write();
        }
    }
}