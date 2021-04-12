package com.gof.create.abstract_factory.product.red;

import com.gof.create.abstract_factory.product.abs.Button;

public class RedButton extends Button {
    @Override
    public void showButton() {
        System.out.println("红色按钮");
    }
}
