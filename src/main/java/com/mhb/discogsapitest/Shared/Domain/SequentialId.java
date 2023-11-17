package com.mhb.discogsapitest.Shared.Domain;

import com.mhb.discogsapitest.Shared.Domain.Exception.InvalidSequentialId;

public class SequentialId extends IntegerValueObject {
    public SequentialId(Integer value) {
        super(value);
        if (value < 1) {
            throw InvalidSequentialId.fromValue(value);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof SequentialId sequentialId)) return false;
        return getValue().equals(sequentialId.getValue());
    }
}
