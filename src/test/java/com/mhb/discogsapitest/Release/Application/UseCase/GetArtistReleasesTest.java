package com.mhb.discogsapitest.Release.Application.UseCase;

import com.mhb.discogsapitest.Album.Domain.AlbumType;
import com.mhb.discogsapitest.Release.Domain.Release;
import com.mhb.discogsapitest.Release.Domain.ReleaseMotherObject;
import com.mhb.discogsapitest.Release.Domain.ReleaseRepository;
import com.mhb.discogsapitest.Shared.Domain.SequentialId;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class GetArtistReleasesTest {
    @Test
    public void testHappyPath() {
        // given
        ReleaseRepository repository = mock(ReleaseRepository.class);
        Integer id = 1;
        List<Release> list1 = List.of(
                ReleaseMotherObject.createRandom(1, AlbumType.ALBUM),
                ReleaseMotherObject.createRandom(2, AlbumType.ALBUM)
        );
        List<Release> list2 = List.of(
                ReleaseMotherObject.createRandom(11, AlbumType.SINGLE),
                ReleaseMotherObject.createRandom(22, AlbumType.SINGLE)
        );
        Map<AlbumType, List<Release>> expectedMap = Map.of(
                AlbumType.ALBUM, list1,
                AlbumType.SINGLE, list2
        );
        when(repository.byArtistId(new SequentialId(id))).thenReturn(
                Stream.concat(list1.stream(), list2.stream()).toList()
        );
        GetArtistReleases sut = new GetArtistReleases(repository);

        // when
        Map<AlbumType, List<Release>> actual = sut.execute(id);

        // then
        assertEquals(expectedMap, actual);
    }
}
