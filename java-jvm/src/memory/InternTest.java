package memory;

public class InternTest {
    public static void main(String[] args) {
        // 在jdk1.8中
        String s1 = "abc"; // 在方法区中看有无abc的引用->没有->在堆中创建String对象so1->方法区中加入so1的引用->s1指向方法区中的引用
//        String s2 = "abc"; // 在方法区中看有无abc的引用->有->s2指向方法区中的引用
        String s2 = s1 + "a";
        String s3 = new String("abc");
//        String s4 = new String("abc");
//        String s5 = new String("ABC");
//        StringBuffer sb = new StringBuffer();
//        System.out.println(s1 == s2); // true，都是指向了方法区的引用
//        s2.intern();
        s3.intern();
    }
}
