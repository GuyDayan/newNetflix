import java.util.Calendar;
import java.util.GregorianCalendar;

public class Date implements Printable {
    private int year;
    private int month;
    private int day;

    public Date(int day, int month,int year) {
        this.year = year;
        this.day = day;
        this.month = month;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public static Date getCurrentDate() {
        Calendar calendar = new GregorianCalendar();
        java.util.Date curr_date = new java.util.Date();
        calendar.setTime(curr_date);
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH) + 1;
        int day = calendar.get(Calendar.DAY_OF_MONTH);
        return new Date(day, month, year);
    }

    public String toString() {
        return this.day + "/" + this.month +"/" + this.year;
    }

    public void print() {
        System.out.println(this);
    }
}
