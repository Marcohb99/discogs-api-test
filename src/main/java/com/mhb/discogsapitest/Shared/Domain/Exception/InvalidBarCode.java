package com.mhb.discogsapitest.Shared.Domain.Exception;

public class InvalidBarCode extends DomainException {
    public InvalidBarCode(String value) {
        super(String.format("The bar code <%s> is invalid", value));
    }

    public static InvalidBarCode fromValue(String value) {
        return new InvalidBarCode(value);
    }
}
