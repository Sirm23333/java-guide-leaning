package com.gof.create.abstract_factory;
import com.gof.create.abstract_factory.factory.SkinFactory;
import com.gof.create.abstract_factory.product.abs.Button;
import com.gof.create.abstract_factory.product.abs.Text;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * 抽象工厂模式，对工厂模式的进一步抽象，将多个产品（产品族）在同一个工厂中生产，而不是工厂模式一个工厂生产一个产品的形式
 * 优点：
 *      1.有了产品族的概念，减少了工厂类的定义
 *      2.对产品族的管理满足开闭原则
 *  缺点：
 *      1.对产品族内部的产品等级结构的管理，不满足开闭原则，这种叫开闭原则的倾斜性，即如果要在产品族中添加一个产品，需要更改工厂抽象类、每个工厂的具体实现类、客户端代码
 */
public class Main {
    public static void main(String[] args) throws IOException, ClassNotFoundException, IllegalAccessException, InstantiationException {
        Properties properties = new Properties();
        InputStream inputStream = new FileInputStream("D:\\data\\idea-project\\java-guide-leaning\\java-GoF\\src\\com\\gof\\create\\abstract_factory\\factoryconf.properties");
        properties.load(inputStream);
        String loggerFactoryName = (String) properties.get("loggerFactory");
        SkinFactory skinFactory = (SkinFactory) Class.forName(loggerFactoryName).newInstance();
        Button button = skinFactory.createButton();
        Text text = skinFactory.createText();
        button.showButton();
        text.showText();
    }
}
