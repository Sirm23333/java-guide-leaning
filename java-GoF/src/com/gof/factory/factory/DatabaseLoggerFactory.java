package com.gof.factory.factory;

import com.gof.factory.product.DatabaseLogger;
import com.gof.factory.product.Logger;

public class DatabaseLoggerFactory implements LoggerFactory {
    @Override
    public Logger createLogger() {
        return new DatabaseLogger();
    }
}
