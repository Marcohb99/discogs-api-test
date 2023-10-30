package com.mhb.discogsapitest.Release.Application.UseCase;

import com.mhb.discogsapitest.Release.Domain.Release;
import com.mhb.discogsapitest.Release.Domain.ReleaseCollectionMotherObject;
import com.mhb.discogsapitest.Release.Domain.ReleaseRepository;
import com.mhb.discogsapitest.Release.Domain.ValueObject.BarCode;
import com.mhb.discogsapitest.Release.Domain.ValueObject.Title;
import com.mhb.discogsapitest.Shared.Domain.SequentialId;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@SpringBootTest
public class GetReleasesTest {

    @Test
    public void testHappyPath() {
        // given
        ReleaseRepository repositoryMock = mock(ReleaseRepository.class);
        List<Release> expected = ReleaseCollectionMotherObject.createRandom(10);
        when(repositoryMock.all()).thenReturn(expected);

        GetReleases sut = new GetReleases(repositoryMock);

        // when
        List<Release> result = sut.execute();

        // then
        assert result.equals(expected);
    }
}
