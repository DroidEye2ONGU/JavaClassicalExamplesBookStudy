package JavaInstance.Capter6;

import sun.util.calendar.LocalGregorianCalendar;

import java.sql.SQLOutput;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Period;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class C6 {
    //获取本地时间并格式化输出
    public static void getDateAndTimeThenFormat() {
        DateTimeFormatter df = DateTimeFormatter.ofPattern("d MMMM, yyyy h:mm a");
        String format = LocalDateTime.now().format(df);
        System.out.println(format);
    }

    //将字符串解析为日期
    public static void parseStringToDate() {
        //不带格式化参数的解析
        String date = "2018-03-11";
        LocalDate parse = LocalDate.parse(date);
        System.out.println(parse);

        //带参数解析为日期
        String date2 = "08-03.11";
        DateTimeFormatter df = DateTimeFormatter.ofPattern("yy-MM.dd");
        LocalDate parse2 = LocalDate.parse(date2, df);
        System.out.println(parse2);

       /* DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yy-MM.dd");
        LocalDate parsed2 = LocalDate.parse("15-11.13", formatter);
        System.out.println(parsed2);*/
    }

    //两个日期之差
    //使用静态方法Period.between()来求取两个LocalDate日期之差
    public static void dateBetween() {
        //上世纪末的日期
        LocalDate endofCentury = LocalDate.of(2000, 12, 31);
        LocalDate now = LocalDate.now();

        Period diff = Period.between(endofCentury, LocalDate.now());

        System.out.print("世纪末到现在时间之差为:");
        System.out.println(diff.getYears() + "年" + diff.getMonths() + "个月" + diff.getDays() + "天");

        System.out.println("-----------------------------------------------------------------------");
        LocalDate any = LocalDate.of(2012, 07, 26);
        LocalDate now2 = LocalDate.now();
        Period between = Period.between(any, now2);
        System.out.print("We have benn in love in:");

        System.out.println(between.getYears() + "年" + between.getMonths()
                + "个月" + between.getDays() + "天");

    }

    //两个日期之差 旧API
    public static void dateBetweenOldAPI() throws ParseException {
        //year the year minus 1900
        Date birth = new Date(96, 4, 17);
        //Date now = new Date(2018, 16, 14);
        Date now = new Date();
        System.out.println(now);
        System.out.println(birth);

        String birthDay = "1996.4.17";

        SimpleDateFormat format =
                new SimpleDateFormat("yyyy.MM.dd");
        long bir = format.parse(birthDay).getTime();
        long period = now.getTime() - bir;


        period = period / 1000 / 60 / 60 / 24;

        System.out.println(period + "天");
        /*
        * SimpleDateFormat dateFormat = new SimpleDateFormat("格式化字符串")
        * 字符串转日期 String to Date : dateFormat.parse(String t)
        * 日期转字符串(格式化日期) Date format to String : dateFormat.format(Date date)
        * */
    }


    //日期或日历的加减
    //使用LocalDate.plus(Period.ofDays(N))实现日期的更改，从而创建一个过去或未来的日期
    public static void datePlusOrMinus() {
        LocalDate now = LocalDate.now();
        Period p = Period.ofDays(-700);
        now = now.plus(p);

        DateTimeFormatter df = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        now.format(df);
        System.out.println(now);
    }

    public static void main(String[] args) throws Exception {
        dateBetweenOldAPI();
    }
}
