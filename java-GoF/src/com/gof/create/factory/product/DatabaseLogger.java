package com.gof.create.factory.product;

public class DatabaseLogger extends Logger {
    @Override
    public void loggerWriter() {
        System.out.println("Database logger ...");
    }
}
