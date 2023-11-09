package com.mhb.discogsapitest.Shared.Domain;

import lombok.Getter;

public class IntegerValueObject {
    @Getter
    private final Integer value;

    protected IntegerValueObject(Integer value) {
        this.value = value;
    }

    @Override
    public boolean equals(Object obj) {
        return obj instanceof IntegerValueObject
                && ((IntegerValueObject) obj).value.equals(this.value);
    }
}
