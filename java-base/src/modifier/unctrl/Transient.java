package modifier.unctrl;

import java.io.*;

/**
 *
 */
public class Transient implements Serializable {
    // 用transient修饰的变量无法被序列化
    public transient int i = 1;

    public int j = 2;

    public  void test(){
        System.out.println("test:" + i + " " + j);
    }
    public static void main(String[] args) throws IOException, ClassNotFoundException {
//        Transient t = new Transient();
        Transient2 t = new Transient2();
        // 序列化
        FileOutputStream fileOutputStream = new FileOutputStream("/home/sirm/文档/Project/IdeaProjects/java-guide-leaning/java-base/src/modifier/unctrl/transient");
        ObjectOutput oot = new ObjectOutputStream(fileOutputStream);
        oot.writeObject(t);
        oot.close();
        // 反序列化
        FileInputStream fileInputStream = new FileInputStream("/home/sirm/文档/Project/IdeaProjects/java-guide-leaning/java-base/src/modifier/unctrl/transient");
        ObjectInput oit = new ObjectInputStream(fileInputStream);
        Transient2 ot = (Transient2)oit.readObject();
        ot.test();
    }
}

/**
 * 实现Externalizable接口的类，可以指定需要序列化的字段，即使是用transient修饰的字段
 */
class Transient2 implements Externalizable{

    public transient int i = 1;

    public int j = 2;

    public Transient2(){}

    public  void test(){
        System.out.println("test:" + i + " " + j);
    }
    @Override
    public void writeExternal(ObjectOutput out) throws IOException {
        out.writeObject(i);
        out.writeObject(j);
    }

    @Override
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
        i = (int)in.readObject();
        j = (int)in.readObject();
    }
}
