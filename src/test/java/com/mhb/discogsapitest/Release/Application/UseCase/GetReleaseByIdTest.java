package com.mhb.discogsapitest.Release.Application.UseCase;

import com.mhb.discogsapitest.Release.Domain.Release;
import com.mhb.discogsapitest.Release.Domain.ReleaseRepository;
import com.mhb.discogsapitest.Release.Domain.ValueObject.BarCode;
import com.mhb.discogsapitest.Release.Domain.ValueObject.Title;
import com.mhb.discogsapitest.Shared.Domain.SequentialId;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@SpringBootTest
public class GetReleaseByIdTest {

    @Test
    public void whenValidIdThenReturnRelease() {
        // given
        int validId = 1;
        Release expected = new Release(
                new SequentialId(1),
                new Title("title"),
                new BarCode("1234567890123")
        );
        ReleaseRepository repositoryMock = mock(ReleaseRepository.class);
        when(repositoryMock.byId(validId)).thenReturn(expected);

        GetReleaseById sut = new GetReleaseById(repositoryMock);

        // when
        Release result = sut.execute(validId);

        // then
        assert result.equals(expected);
    }
}
