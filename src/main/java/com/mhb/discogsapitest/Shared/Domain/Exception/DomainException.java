package com.mhb.discogsapitest.Shared.Domain.Exception;

public class DomainException extends RuntimeException{
    public DomainException(String format) {
        super(format);
    }
}
