package com.mhb.discogsapitest.Shared.Domain;

import com.mhb.discogsapitest.Shared.Domain.Exception.InvalidSequentialId;

public class SequentialId extends IntegerValueObject {
    public SequentialId(int value) {
        super(value);
        if (value < 1) {
            throw InvalidSequentialId.fromValue(value);
        }
    }
}
