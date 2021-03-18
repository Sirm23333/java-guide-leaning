package multhread.Volatile;

public class VolatileTest {
    public static int count = 0;
    public static volatile int count2 = 0;



    public static void main(String[] args) {

        new Thread(new Runnable() {
            @Override
            public void run() {
//                // 不就volatile 永远循环
//                while(count == 0);
                while (count2 == 0);
                System.out.println(count2);
            }
        }).start();

        try {
            Thread.sleep(5500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        count2++;
        System.out.println("count 变为" + count2);

    }

}
