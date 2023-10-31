package com.mhb.discogsapitest.Shared.Domain;

import lombok.Getter;

public class StringValueObject {
    @Getter
    private final String value;

    protected StringValueObject(String value) {
        this.value = value;
    }

    @Override
    public boolean equals(Object obj) {
        return this.value.equals(((StringValueObject) obj).value);
    }
}