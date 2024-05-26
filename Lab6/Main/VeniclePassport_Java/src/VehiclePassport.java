import java.util.*;
import java.util.regex.Pattern;

public class VehiclePassport implements Comparable<VehiclePassport> {
    private final String name;
    private final String series;
    private final String number;
    private final String issueDate;

    public VehiclePassport(String name, String series, String number, String issueDate) {
        if (!validateSeriesNumber(series, number)) {
            throw new IllegalArgumentException("Invalid series or number format");
        }
        if (!validateDate(issueDate)) {
            throw new IllegalArgumentException("Invalid date format");
        }
        this.name = name;
        this.series = series;
        this.number = number;
        this.issueDate = issueDate;
    }

    public void write() {
        System.out.println("Паспорт транспортного средства\n" +
                "Владелец : " + name + "\n" +
                "Серия : " + series + "\n" +
                "Номер : " + number + "\n" +
                "Дата: " + issueDate + "\n"
        );
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        if (other == null || getClass() != other.getClass()) return false;
        VehiclePassport that = (VehiclePassport) other;
        return series.equals(that.series) &&
                number.equals(that.number) &&
                issueDate.equals(that.issueDate);
    }

    @Override
    public int compareTo(VehiclePassport other) {
        int result = name.compareTo(other.name);
        if (result != 0) return result;
        result = series.compareTo(other.series);
        if (result != 0) return result;
        result = number.compareTo(other.number);
        if (result != 0) return result;
        return issueDate.compareTo(other.issueDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, series, number, issueDate);
    }

    private static final String NUMBER_PATTERN = "[A-Z]{2}\\d{6}";
    private static final String DATE_PATTERN = "\\d{2}\\.\\d{2}\\.\\d{4}";

    private static boolean validateSeriesNumber(String series, String number) {
        Pattern pattern = Pattern.compile(NUMBER_PATTERN);
        return pattern.matcher(series + number).matches();
    }

    private static boolean validateDate(String date) {
        Pattern pattern = Pattern.compile(DATE_PATTERN);
        return pattern.matcher(date).matches();
    }

    public String getIssueDate() {
        return issueDate;
    }

    public String getSeries() {
        return series;
    }

    public String getNumber() {
        return number;
    }
}