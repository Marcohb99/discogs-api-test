package com.mhb.discogsapitest.Artist.Infrastructure.Persistence.InMemory;

import com.mhb.discogsapitest.Artist.Domain.Artist;
import com.mhb.discogsapitest.Artist.Domain.Band;
import com.mhb.discogsapitest.Artist.Domain.Exception.ArtistNotFound;
import com.mhb.discogsapitest.Artist.Domain.ValueObject.BasicArtistInfo;
import com.mhb.discogsapitest.Shared.Domain.NotEmptyString;
import com.mhb.discogsapitest.Shared.Domain.SequentialId;
import org.junit.jupiter.api.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.Map;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class InMemoryArtistRepositoryTest {
    @Test
    public void testById() throws MalformedURLException {
        // given
        SequentialId id = new SequentialId(1);
        Artist expected = new Band(
                new BasicArtistInfo(
                        new SequentialId(1),
                        new NotEmptyString("Muse")
                ),
                new NotEmptyString("English rock band from Teignmouth, Devon, formed in 1994. The band consists of Matt Bellamy (lead vocals, guitar, keyboards), Chris Wolstenholme (bass guitar, backing vocals), and Dominic Howard (drums)."),
                Map.of(
                        1, new NotEmptyString("Rocket Baby Dolls")
                ),
                null,
                Map.of(
                        1, new NotEmptyString("Matthew Bellamy"),
                        2, new NotEmptyString("Christopher Wolstenholme"),
                        3, new NotEmptyString("Dominic Howard")
                ),
                List.of(
                        new URL("https://www.muse.mu/"),
                        new URL("https://www.musewiki.org/")
                )
        );
        InMemoryArtistRepository sut = new InMemoryArtistRepository();

        // when
        Artist actual = sut.byId(id);

        // then
        assert actual.equals(expected);
    }

    @Test
    public void testByIdNotFound() {
        // given
        SequentialId id = new SequentialId(11);
        InMemoryArtistRepository sut = new InMemoryArtistRepository();

        // when / then
        assertThrows(ArtistNotFound.class, () -> sut.byId(id));
    }
}
