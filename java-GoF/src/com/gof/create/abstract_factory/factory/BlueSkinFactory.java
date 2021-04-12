package com.gof.create.abstract_factory.factory;

import com.gof.create.abstract_factory.product.abs.Button;
import com.gof.create.abstract_factory.product.abs.Text;
import com.gof.create.abstract_factory.product.blue.BlueButton;
import com.gof.create.abstract_factory.product.blue.BlueText;

public class BlueSkinFactory implements SkinFactory{
    @Override
    public Button createButton() {
        return new BlueButton();
    }

    @Override
    public Text createText() {
        return new BlueText();
    }
}
