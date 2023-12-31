package com.mhb.discogsapitest.Shared.Domain.Exception;

public class InvalidSequentialId extends DomainException {
    private InvalidSequentialId(String format) {
        super(format);
    }

    public static InvalidSequentialId fromValue(Integer value) {
        return new InvalidSequentialId(
                String.format("The sequential id <%s> must be greater than zero", value)
        );
    }
}
