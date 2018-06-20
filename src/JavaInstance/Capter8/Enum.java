package JavaInstance.Capter8;

public class Enum {
    enum State {
        ON,OFF,UNKNOWN
    }

    private String a;


    public Enum() {
        a = "aa";
    }

    public static void main(String[] args) {
        for (State i :
                State.values()) {
            System.out.println(i);
        }
        Enum enum1 = new Enum();
        System.out.println(enum1.a);
    }
}
