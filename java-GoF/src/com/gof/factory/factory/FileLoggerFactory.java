package com.gof.factory.factory;

import com.gof.factory.product.FileLogger;
import com.gof.factory.product.Logger;

public class FileLoggerFactory implements LoggerFactory {
    @Override
    public Logger createLogger() {
        return new FileLogger();
    }
}
