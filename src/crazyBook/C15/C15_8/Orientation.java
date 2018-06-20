package crazyBook.C15.C15_8;

import java.io.ObjectStreamException;
import java.io.Serializable;

public class Orientation implements Serializable {
    public static final Orientation HORIZONTAL = new Orientation(1);
    public static final Orientation VERTICAL = new Orientation(2);
    private int value;

    private Orientation(int value) {
        this.value = value;
    }

    //为枚举类增加readResolve()方法
    //通过重写readResolve()方法可以保证反序列化得到的依然是Orientation的
    //HORIZONTAL或VERTICAL两个枚举值之一
    private Object readResolve() throws ObjectStreamException {
        if (value == 1) {
            return HORIZONTAL;
        }
        if (value == 2) {
            return VERTICAL;
        }
        return null;
    }
}
