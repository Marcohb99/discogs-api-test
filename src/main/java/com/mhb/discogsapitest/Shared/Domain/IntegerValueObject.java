package com.mhb.discogsapitest.Shared.Domain;

import lombok.Getter;

public class IntegerValueObject {
    @Getter
    private final int value;

    protected IntegerValueObject(int value) {
        this.value = value;
    }

    @Override
    public boolean equals(Object obj) {
        return this.getValue() == ((IntegerValueObject) obj).getValue();
    }
}
