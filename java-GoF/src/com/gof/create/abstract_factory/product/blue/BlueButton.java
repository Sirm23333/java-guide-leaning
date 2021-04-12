package com.gof.create.abstract_factory.product.blue;

import com.gof.create.abstract_factory.product.abs.Button;

public class BlueButton extends Button {
    @Override
    public void showButton() {
        System.out.println("蓝色按钮");
    }
}
