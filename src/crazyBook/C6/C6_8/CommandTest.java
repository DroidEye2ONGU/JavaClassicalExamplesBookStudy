package crazyBook.C6.C6_8;

public class CommandTest {
    public static void main(String[] args) {
        ProcessArray pa = new ProcessArray();
        int[] array = {3, -4, 6, 4};
        //处理数组,具体处理行为取决于匿名内部类
        /*pa.process(array, new Command() {
            @Override
            public void process(int[] target) {
                int sum = 0;
                for (int tmp :
                        target) {
                    sum += tmp;
                }
                System.out.println("数组元素的总和是:" + sum);
            }
        });*/
        
        //使用Lambda表达式
        pa.process(array, target2 ->{
            int sum = 0;
                    for (int tmp :
                            target2) {
                        sum += tmp;
                    }
                    System.out.println("数组元素的总和是:" + sum);
                });
    }
}
