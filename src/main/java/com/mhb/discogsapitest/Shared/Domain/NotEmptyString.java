package com.mhb.discogsapitest.Shared.Domain;

public class NotEmptyString extends StringValueObject {
    public NotEmptyString(String value) {
        super(value);
        if (value.isEmpty()) {
            throw new IllegalArgumentException("The value can't be empty");
        }
    }
}
