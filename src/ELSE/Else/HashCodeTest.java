package ELSE.Else;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class HashCodeTest {
    private String a;
    private int b;

    public HashCodeTest() {
    }

    public HashCodeTest(String a, int b) {
        this.a = a;
        this.b = b;
    }

    public String getA() {
        return a;
    }

    public void setA(String a) {
        this.a = a;
    }

    public int getB() {
        return b;
    }

    public void setB(int b) {
        this.b = b;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        HashCodeTest that = (HashCodeTest) o;
        return b == that.b &&
                Objects.equals(a, that.a);
    }

    @Override
    public int hashCode() {

        return Objects.hash(a, b);
    }
}

class HashCodeRun {
    public static void main(String[] args) {
        Set<HashCodeTest> set = new HashSet<>();

        set.add(new HashCodeTest("a", 1));
        set.add(new HashCodeTest("a", 1));
        set.add(new HashCodeTest("b", 2));
    }
}