package ELSE.Day21.Reflect;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Method;

public class Test08_DemoClass {
    public static void main(String[] args) {
        try (
                BufferedReader br = new BufferedReader(
                        new InputStreamReader(
                                new FileInputStream("C:\\Users\\DroidEye\\Desktop\\Programme\\IdeaProjects\\JavaClassicalExamplesBookStudy\\src\\ELSE\\Day21\\Reflect\\DemoClass.properties")
                        )
                )
        ) {
            String className = br.readLine();
            Class<DemoClass> aClass = (Class<DemoClass>) Class.forName(className);
            Method run = aClass.getDeclaredMethod("run");

            DemoClass demoClass = aClass.newInstance();
            run.invoke(demoClass);

        } catch (Exception e) {
            e.printStackTrace();
        }


    }
}
