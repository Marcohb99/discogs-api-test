package com.mhb.discogsapitest.Release.Domain.Exception;

import com.mhb.discogsapitest.Shared.Domain.Exception.DomainException;

public class InvalidFormatName extends DomainException {
    public InvalidFormatName(String message) {
        super(message);
    }

    public static InvalidFormatName empty() {
        return new InvalidFormatName("Format name cannot be empty");
    }
}
