package com.gof.create.abstract_factory.factory;

import com.gof.create.abstract_factory.product.abs.Button;
import com.gof.create.abstract_factory.product.abs.Text;
import com.gof.create.abstract_factory.product.blue.BlueButton;
import com.gof.create.abstract_factory.product.blue.BlueText;
import com.gof.create.abstract_factory.product.red.RedButton;
import com.gof.create.abstract_factory.product.red.RedText;

public class RedSkinFactory implements SkinFactory{
    @Override
    public Button createButton() {
        return new RedButton();
    }

    @Override
    public Text createText() {
        return new RedText();
    }
}
