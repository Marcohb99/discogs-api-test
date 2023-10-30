package com.mhb.discogsapitest.Release.Domain.ValueObject;

import com.mhb.discogsapitest.Shared.Domain.Exception.InvalidBarCode;
import com.mhb.discogsapitest.Shared.Domain.StringValueObject;

public class BarCode extends StringValueObject {
    public BarCode(String value) {
        super(value);
        if (!this.validate(value)) {
            throw InvalidBarCode.fromValue(value);
        }
    }

    private boolean validate(String value) {
        return value.matches("^[0-9]{13}$");
    }
}
