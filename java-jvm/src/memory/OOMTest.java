package memory;

import java.util.ArrayList;
import java.util.List;

public class OOMTest {

    public static void test(){
        int i = 0;
        List<String> strs = new ArrayList<>();
        while(true){
            strs.add(String.valueOf(i++).intern());
        }

    }

    public static void main(String[] args) {
        test();

    }
}
