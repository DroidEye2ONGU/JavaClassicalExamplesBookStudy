package ELSE.JavaSE.Day14;

public class OwnExceptionSource {
    public static void a() throws OwnException {
        //new OwnException().printStackTrace();
        throw new OwnException();
    }


}
