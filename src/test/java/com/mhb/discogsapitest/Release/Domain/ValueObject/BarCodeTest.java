package com.mhb.discogsapitest.Release.Domain.ValueObject;

import com.mhb.discogsapitest.Shared.Domain.Exception.InvalidBarCode;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class BarCodeTest {

    @Test
    public void whenValidBarCodeThenNoException() {
        // given
        String validBarCode = "1234567890123";

        // when
        BarCode sut = new BarCode(validBarCode);

        // then
        assertEquals(sut.getValue(), validBarCode);
    }

    @Test
    public void whenInvalidBarCodeThenThrowException() {
        // given
        String invalidBarCode = "123456789012";

        // when / then
        assertThrows(InvalidBarCode.class, () -> new BarCode(invalidBarCode));
    }
}
