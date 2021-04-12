package com.gof.create.abstract_factory.product.red;
import com.gof.create.abstract_factory.product.abs.Text;

public class RedText extends Text {
    @Override
    public void showText() {
        System.out.println("红色文本");
    }
}
