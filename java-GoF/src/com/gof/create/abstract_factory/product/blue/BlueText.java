package com.gof.create.abstract_factory.product.blue;
import com.gof.create.abstract_factory.product.abs.Text;

public class BlueText extends Text {
    @Override
    public void showText() {
        System.out.println("蓝色文本");
    }
}
