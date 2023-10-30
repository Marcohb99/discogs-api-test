package com.mhb.discogsapitest.Shared.Domain.Exception;

public class InvalidSequentialId extends RuntimeException {
    private InvalidSequentialId(String format) {
        super(format);
    }

    public static InvalidSequentialId fromValue(int value) {
        return new InvalidSequentialId(
                String.format("The sequential id <%s> must be greater than zero", value)
        );
    }
}
