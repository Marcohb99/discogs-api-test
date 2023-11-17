package com.mhb.discogsapitest.Shared.Domain;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class StringValueObject {
    private final String value;

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof StringValueObject stringValueObject)) return false;
        return value.equals(stringValueObject.value);
    }
}
