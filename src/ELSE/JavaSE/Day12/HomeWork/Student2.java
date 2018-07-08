package ELSE.JavaSE.Day12.HomeWork;

public class Student2 {
    private String name;
    private int cGrade;
    private int mathGrade;
    private int engGrade;
    private int totalGrade;

    public Student2() {
    }

    public Student2(String name, int cGrade, int mathGrade, int engGrade, int totalGrade) {
        this.name = name;
        this.cGrade = cGrade;
        this.mathGrade = mathGrade;
        this.engGrade = engGrade;
        this.totalGrade = totalGrade;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getcGrade() {
        return cGrade;
    }

    public void setcGrade(int cGrade) {
        this.cGrade = cGrade;
    }

    public int getMathGrade() {
        return mathGrade;
    }

    public void setMathGrade(int mathGrade) {
        this.mathGrade = mathGrade;
    }

    public int getEngGrade() {
        return engGrade;
    }

    public void setEngGrade(int engGrade) {
        this.engGrade = engGrade;
    }

    public int getTotalGrade() {
        return totalGrade;
    }

    public void setTotalGrade(int totalGrade) {
        this.totalGrade = totalGrade;
    }

    @Override
    public String toString() {
        return "Student2{" +
                "name='" + name + '\'' +
                ", cGrade=" + cGrade +
                ", mathGrade=" + mathGrade +
                ", engGrade=" + engGrade +
                ", totalGrade=" + totalGrade +
                '}';
    }
}
