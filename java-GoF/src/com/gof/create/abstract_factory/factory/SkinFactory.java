package com.gof.create.abstract_factory.factory;

import com.gof.create.abstract_factory.product.abs.Button;
import com.gof.create.abstract_factory.product.abs.Text;

public interface SkinFactory {
    Button createButton();
    Text createText();
}
