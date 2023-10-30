package com.mhb.discogsapitest.Shared.Domain;

import lombok.Getter;

public class StringValueObject {
    @Getter
    private final String value;

    protected StringValueObject(String value) {
        this.value = value;
    }
}
