package com.mhb.discogsapitest.Release.Application.UseCase.Exception;

public class GetReleasesByBarcodeException extends RuntimeException {
    public GetReleasesByBarcodeException(String message) {
        super(message);
    }

    public static GetReleasesByBarcodeException fromError(Exception e) {
        return new GetReleasesByBarcodeException(e.getMessage());
    }
}
