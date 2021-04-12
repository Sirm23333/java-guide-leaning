package com.gof.create.factory.factory;

import com.gof.create.factory.product.FileLogger;
import com.gof.create.factory.product.Logger;

public class FileLoggerFactory implements LoggerFactory {
    @Override
    public Logger createLogger() {
        return new FileLogger();
    }
}
