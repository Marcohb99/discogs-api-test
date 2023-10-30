package com.mhb.discogsapitest.Shared.Domain;

import com.mhb.discogsapitest.Shared.Domain.Exception.InvalidSequentialId;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
public class SequentialIdTest {

    @Test
    public void whenInvalidIdThenThrowException() {
        // given
        int invalidId = -1;

        // when / then
        assertThrows(InvalidSequentialId.class, () -> new SequentialId(invalidId));
    }

    @Test
    public void whenValidIdThenNoException() {
        // given
        int validId = 1;

        // when
        SequentialId sut = new SequentialId(validId);

        // then
        assertEquals(sut.getValue(), validId);
    }
}
