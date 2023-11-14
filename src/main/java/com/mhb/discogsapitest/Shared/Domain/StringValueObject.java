package com.mhb.discogsapitest.Shared.Domain;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
@EqualsAndHashCode
public class StringValueObject {
    private final String value;
}
