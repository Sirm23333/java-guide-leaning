package com.gof.create.factory.factory;

import com.gof.create.factory.product.DatabaseLogger;
import com.gof.create.factory.product.Logger;

public class DatabaseLoggerFactory implements LoggerFactory {
    @Override
    public Logger createLogger() {
        return new DatabaseLogger();
    }
}
