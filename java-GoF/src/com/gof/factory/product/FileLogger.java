package com.gof.factory.product;

public class FileLogger extends Logger {
    @Override
    public void loggerWriter() {
        System.out.println("File logger ...");
    }
}
