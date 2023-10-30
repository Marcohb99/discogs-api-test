package com.mhb.discogsapitest.Release.Application.UseCase;

import com.mhb.discogsapitest.Release.Domain.Release;
import com.mhb.discogsapitest.Release.Domain.ReleaseMotherObject;
import com.mhb.discogsapitest.Release.Domain.ReleaseRepository;
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
        Release expected = ReleaseMotherObject.createRandom(validId);
        ReleaseRepository repositoryMock = mock(ReleaseRepository.class);
        when(repositoryMock.byId(validId)).thenReturn(expected);

        GetReleaseById sut = new GetReleaseById(repositoryMock);

        // when
        Release result = sut.execute(validId);

        // then
        assert result.equals(expected);
    }
}
