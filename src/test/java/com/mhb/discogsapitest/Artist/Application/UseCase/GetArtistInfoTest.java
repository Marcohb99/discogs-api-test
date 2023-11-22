package com.mhb.discogsapitest.Artist.Application.UseCase;

import com.mhb.discogsapitest.Artist.Domain.Artist;
import com.mhb.discogsapitest.Artist.Domain.ArtistMotherObject;
import com.mhb.discogsapitest.Artist.Domain.ArtistRepository;
import com.mhb.discogsapitest.Artist.Domain.Exception.ArtistNotFound;
import com.mhb.discogsapitest.Shared.Domain.SequentialId;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.mock;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;


public class GetArtistInfoTest {
    @Test
    public void testExecute() {
        // given
        Integer id = 1;
        ArtistRepository repository = mock(ArtistRepository.class);
        Artist expected;
        try {
            expected = ArtistMotherObject.random(id, null);
        } catch (Exception e) {
            fail(e.getMessage());
            return;
        }
        when(repository.byId(new SequentialId(id))).thenReturn(expected);

        GetArtistInfo sut = new GetArtistInfo(repository);

        // when
        Artist result = sut.execute(id);

        // then
        assertEquals(expected, result);
    }

    @Test
    public void testExecuteNotFound() {
        // given
        Integer id = 1;
        ArtistRepository repository = mock(ArtistRepository.class);
        when(repository.byId(new SequentialId(id))).thenThrow(ArtistNotFound.class);

        GetArtistInfo sut = new GetArtistInfo(repository);

        // when / then
        assertThrows(ArtistNotFound.class, () -> sut.execute(id));
    }
}
