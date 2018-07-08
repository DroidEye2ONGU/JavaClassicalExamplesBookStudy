package ELSE.JavaSE.Day14;

public class OwnException extends Exception {
    @Override
    public void printStackTrace() {
        super.printStackTrace();
        System.out.println("Own Exception");
    }
}
