package Chapter4;

import java.time.DayOfWeek;
import java.time.LocalDate;

/**
 * 打印本月的日历
 */
public class LocalDateTest {
    public static void main(String[] args) {
        LocalDate today = LocalDate.now();
        int day = today.getDayOfMonth();
        int month = today.getMonthValue();
        //  设置为这个月第一天
        LocalDate date = today.minusDays(day - 1);

        // 获得这个月第一天是周几
        DayOfWeek dayOfWeek = date.getDayOfWeek();
        int weekday = dayOfWeek.getValue();

        // 打印前面空格来保持格式
        System.out.println(" Mon Tue Wes Thu Fri Sat Sun");
        for (int i = 1; i < weekday; i ++ ) {
            System.out.print("    ");
        }

        while (date.getMonthValue() == month) {    // 如果还是这个月
            System.out.printf("%3d", date.getDayOfMonth());
            if (date.getDayOfMonth() == day) {  // 在今天后面加上*
                System.out.print("*");
            } else {
                System.out.print(" ");
            }
            date = date.plusDays(1);    // 获得下一天
            if (date.getDayOfWeek().getValue() == 1) {  // 如果下一天是周一则换行
                System.out.println();
            }
        }
    }
}
