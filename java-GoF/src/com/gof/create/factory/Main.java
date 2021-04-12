package com.gof.create.factory;

import com.gof.create.factory.factory.LoggerFactory;
import com.gof.create.factory.product.Logger;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * 工厂模式，静态工厂在扩展时需要改动工厂代码和客户端代码，违反开闭原则，工厂模式时一个具体子类对应一个具体实现工厂
 * 优点：
 *      1.配合配置文件+反射的机制，添加新的具体实现类时，只需要修改配置文件就可以，无需侵入代码，完全符合开闭原则
 *      2.客户端不必知道要创建的类名，只需要拿到改具体类的工厂即可
 *  缺点：
 *      1.每增加一个具体实现类，不仅要有类的定义，还有定义对应的工厂，增加了代码量
 */

public class Main {
    public static void main(String[] args) throws IOException, ClassNotFoundException, IllegalAccessException, InstantiationException {
        Properties properties = new Properties();
        InputStream inputStream = new FileInputStream("D:\\data\\idea-project\\java-guide-leaning\\java-GoF\\src\\com\\gof\\factory\\factoryconf.properties");
        properties.load(inputStream);
        String loggerFactoryName = (String) properties.get("loggerFactory");
        LoggerFactory loggerFactory = (LoggerFactory) Class.forName(loggerFactoryName).newInstance();
        Logger logger = loggerFactory.createLogger();
        logger.loggerWriter();
    }
}
