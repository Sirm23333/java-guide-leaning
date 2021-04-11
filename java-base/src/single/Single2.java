package single;

/**
 * 利用JVM
 */
public class Single2 {
    private static class SingleHandler{
        private final static Single2 instance = new Single2();
    }
    public static Single2 getInstance(){
        return SingleHandler.instance;
    }

    public static void main(String[] args) {
        Single2 instance = Single2.getInstance();
    }
}
