package com.mhb.discogsapitest.Release.Infrastructure.Persistence.InMemory;

import com.mhb.discogsapitest.Album.Domain.AlbumType;
import com.mhb.discogsapitest.Artist.Domain.ValueObject.BasicArtistInfo;
import com.mhb.discogsapitest.Album.Domain.Album;
import com.mhb.discogsapitest.Release.Domain.Release;
import com.mhb.discogsapitest.Release.Domain.ValueObject.BarCode;
import com.mhb.discogsapitest.Release.Domain.ValueObject.Credit;
import com.mhb.discogsapitest.Shared.Domain.NotEmptyString;
import com.mhb.discogsapitest.Shared.Domain.SequentialId;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;
import java.util.List;
import java.util.Map;

@SpringBootTest
public class InMemoryReleaseRepositoryTest {

    @Test
    public void testById() {
        // given
        Release expected = new Release(
                new SequentialId(1),
                new BarCode("1234567890123"),
                new Date(1234567890L),
                new NotEmptyString("label_1"),
                new NotEmptyString("country_1"),
                new Album(
                        new SequentialId(1),
                        new NotEmptyString("title_1"),
                        List.of(
                                new NotEmptyString("track_1"),
                                new NotEmptyString("track_2"),
                                new NotEmptyString("track_3")
                        ),
                        List.of(
                                new NotEmptyString("genre_1"),
                                new NotEmptyString("genre_2"),
                                new NotEmptyString("genre_3")
                        ),
                        List.of(
                                new BasicArtistInfo(
                                        new SequentialId(1),
                                        new NotEmptyString("artist_1")
                                )
                        ),
                        Map.of(
                                "person_1",
                                List.of(
                                        Credit.LYRICS_BY,
                                        Credit.MUSIC_BY
                                ),
                                "person_2",
                                List.of(Credit.PHOTOGRAPHY_BY),
                                "person_3",
                                List.of(Credit.EXECUTIVE_PRODUCER)
                        ),
                        AlbumType.ALBUM
                ),
                List.of(new NotEmptyString("format_1")),
                null
        );
        InMemoryReleaseRepository sut = new InMemoryReleaseRepository();

        // when
        Release result = sut.byId(new SequentialId(1));

        // then
        assert result.equals(expected);
    }

    @Test
    public void testByArtistId() {
        // given
        List<Release> expected = List.of(
                new Release(
                    new SequentialId(1),
                    new BarCode("1234567890123"),
                    new Date(1234567890L),
                    new NotEmptyString("label_1"),
                    new NotEmptyString("country_1"),
                    new Album(
                            new SequentialId(1),
                            new NotEmptyString("title_1"),
                            List.of(
                                    new NotEmptyString("track_1"),
                                    new NotEmptyString("track_2"),
                                    new NotEmptyString("track_3")
                            ),
                            List.of(
                                    new NotEmptyString("genre_1"),
                                    new NotEmptyString("genre_2"),
                                    new NotEmptyString("genre_3")
                            ),
                            List.of(
                                    new BasicArtistInfo(
                                            new SequentialId(1),
                                            new NotEmptyString("artist_1")
                                    )
                            ),
                            Map.of(
                                    "person_1",
                                    List.of(
                                            Credit.LYRICS_BY,
                                            Credit.MUSIC_BY
                                    ),
                                    "person_2",
                                    List.of(Credit.PHOTOGRAPHY_BY),
                                    "person_3",
                                    List.of(Credit.EXECUTIVE_PRODUCER)
                            ),
                            AlbumType.ALBUM
                    ),
                    List.of(new NotEmptyString("format_1")),
                    null
            )
        );
        InMemoryReleaseRepository sut = new InMemoryReleaseRepository();

        // when
        List<Release> result = sut.byArtistId(new SequentialId(1));

        // then
        assert result.equals(expected);
    }

    @Test
    public void testByBarCode() {
        // given
        BarCode barCode = new BarCode("1234567890123");
        List<Release> expected = List.of(
                new Release(
                        new SequentialId(1),
                        new BarCode("1234567890123"),
                        new Date(1234567890L),
                        new NotEmptyString("label_1"),
                        new NotEmptyString("country_1"),
                        new Album(
                                new SequentialId(1),
                                new NotEmptyString("title_1"),
                                List.of(
                                        new NotEmptyString("track_1"),
                                        new NotEmptyString("track_2"),
                                        new NotEmptyString("track_3")
                                ),
                                List.of(
                                        new NotEmptyString("genre_1"),
                                        new NotEmptyString("genre_2"),
                                        new NotEmptyString("genre_3")
                                ),
                                List.of(
                                        new BasicArtistInfo(
                                                new SequentialId(1),
                                                new NotEmptyString("artist_1")
                                        )
                                ),
                                Map.of(
                                        "person_1",
                                        List.of(
                                                Credit.LYRICS_BY,
                                                Credit.MUSIC_BY
                                        ),
                                        "person_2",
                                        List.of(Credit.PHOTOGRAPHY_BY),
                                        "person_3",
                                        List.of(Credit.EXECUTIVE_PRODUCER)
                                ),
                                AlbumType.ALBUM
                        ),
                        List.of(new NotEmptyString("format_1")),
                        null
                ),
                new Release(
                        new SequentialId(3),
                        new BarCode("1234567890123"),
                        new Date(1234567890L),
                        new NotEmptyString("label_3"),
                        new NotEmptyString("country_3"),
                        new Album(
                                new SequentialId(3),
                                new NotEmptyString("title_3"),
                                List.of(
                                        new NotEmptyString("track_1"),
                                        new NotEmptyString("track_2"),
                                        new NotEmptyString("track_3")
                                ),
                                List.of(
                                        new NotEmptyString("genre_1"),
                                        new NotEmptyString("genre_2"),
                                        new NotEmptyString("genre_3")
                                ),
                                List.of(
                                        new BasicArtistInfo(
                                                new SequentialId(3),
                                                new NotEmptyString("artist_3")
                                        )
                                ),
                                Map.of(
                                        "person_1",
                                        List.of(
                                                Credit.LYRICS_BY,
                                                Credit.MUSIC_BY
                                        ),
                                        "person_2",
                                        List.of(Credit.PHOTOGRAPHY_BY),
                                        "person_3",
                                        List.of(Credit.EXECUTIVE_PRODUCER)
                                ),
                                AlbumType.ALBUM
                        ),
                        List.of(new NotEmptyString("format_3")),
                        "catalog_number_3"
                )
        );
        InMemoryReleaseRepository sut = new InMemoryReleaseRepository();

        // when
        List<Release> result = sut.byBarCode(barCode);

        // then
        assert result.equals(expected);
    }

    @Test
    public void testAll() {
        // given
        List<Release> expected = List.of(
                new Release(
                        new SequentialId(1),
                        new BarCode("1234567890123"),
                        new Date(1234567890L),
                        new NotEmptyString("label_1"),
                        new NotEmptyString("country_1"),
                        new Album(
                                new SequentialId(1),
                                new NotEmptyString("title_1"),
                                List.of(
                                        new NotEmptyString("track_1"),
                                        new NotEmptyString("track_2"),
                                        new NotEmptyString("track_3")
                                ),
                                List.of(
                                        new NotEmptyString("genre_1"),
                                        new NotEmptyString("genre_2"),
                                        new NotEmptyString("genre_3")
                                ),
                                List.of(
                                        new BasicArtistInfo(
                                                new SequentialId(1),
                                                new NotEmptyString("artist_1")
                                        )
                                ),
                                Map.of(
                                        "person_1",
                                        List.of(
                                                Credit.LYRICS_BY,
                                                Credit.MUSIC_BY
                                        ),
                                        "person_2",
                                        List.of(Credit.PHOTOGRAPHY_BY),
                                        "person_3",
                                        List.of(Credit.EXECUTIVE_PRODUCER)
                                ),
                                AlbumType.ALBUM
                        ),
                        List.of(new NotEmptyString("format_1")),
                        null
                ),
                new Release(
                        new SequentialId(2),
                        new BarCode("1234567890124"),
                        new Date(1234567890L),
                        new NotEmptyString("label_2"),
                        new NotEmptyString("country_2"),
                        new Album(
                                new SequentialId(2),
                                new NotEmptyString("title_2"),
                                List.of(
                                        new NotEmptyString("track_1"),
                                        new NotEmptyString("track_2"),
                                        new NotEmptyString("track_3")
                                ),
                                List.of(
                                        new NotEmptyString("genre_1"),
                                        new NotEmptyString("genre_2"),
                                        new NotEmptyString("genre_3")
                                ),
                                List.of(
                                        new BasicArtistInfo(
                                                new SequentialId(2),
                                                new NotEmptyString("artist_2")
                                        )
                                ),
                                Map.of(
                                        "person_1",
                                        List.of(
                                                Credit.LYRICS_BY,
                                                Credit.MUSIC_BY
                                        ),
                                        "person_2",
                                        List.of(Credit.PHOTOGRAPHY_BY),
                                        "person_3",
                                        List.of(Credit.EXECUTIVE_PRODUCER)
                                ),
                                AlbumType.ALBUM
                        ),
                        List.of(new NotEmptyString("format_2")),
                        "catalog_number_2"
                ),
                new Release(
                        new SequentialId(3),
                        new BarCode("1234567890123"),
                        new Date(1234567890L),
                        new NotEmptyString("label_3"),
                        new NotEmptyString("country_3"),
                        new Album(
                                new SequentialId(3),
                                new NotEmptyString("title_3"),
                                List.of(
                                        new NotEmptyString("track_1"),
                                        new NotEmptyString("track_2"),
                                        new NotEmptyString("track_3")
                                ),
                                List.of(
                                        new NotEmptyString("genre_1"),
                                        new NotEmptyString("genre_2"),
                                        new NotEmptyString("genre_3")
                                ),
                                List.of(
                                        new BasicArtistInfo(
                                                new SequentialId(3),
                                                new NotEmptyString("artist_3")
                                        )
                                ),
                                Map.of(
                                        "person_1",
                                        List.of(
                                                Credit.LYRICS_BY,
                                                Credit.MUSIC_BY
                                        ),
                                        "person_2",
                                        List.of(Credit.PHOTOGRAPHY_BY),
                                        "person_3",
                                        List.of(Credit.EXECUTIVE_PRODUCER)
                                ),
                                AlbumType.ALBUM
                        ),
                        List.of(new NotEmptyString("format_3")),
                        "catalog_number_3"
                ),
                new Release(
                        new SequentialId(4),
                        new BarCode("1234567890126"),
                        new Date(1234567890L),
                        new NotEmptyString("label_4"),
                        new NotEmptyString("country_4"),
                        new Album(
                                new SequentialId(4),
                                new NotEmptyString("title_4"),
                                List.of(
                                        new NotEmptyString("track_1"),
                                        new NotEmptyString("track_2"),
                                        new NotEmptyString("track_3")
                                ),
                                List.of(
                                        new NotEmptyString("genre_1"),
                                        new NotEmptyString("genre_2"),
                                        new NotEmptyString("genre_3")
                                ),
                                List.of(
                                        new BasicArtistInfo(
                                                new SequentialId(4),
                                                new NotEmptyString("artist_4")
                                        )
                                ),
                                Map.of(
                                        "person_1",
                                        List.of(
                                                Credit.LYRICS_BY,
                                                Credit.MUSIC_BY
                                        ),
                                        "person_2",
                                        List.of(Credit.PHOTOGRAPHY_BY),
                                        "person_3",
                                        List.of(Credit.EXECUTIVE_PRODUCER)
                                ),
                                AlbumType.ALBUM
                        ),
                        List.of(new NotEmptyString("format_4")),
                        "catalog_number_4"
                ),
                new Release(
                        new SequentialId(5),
                        new BarCode("1234567890127"),
                        new Date(1234567890L),
                        new NotEmptyString("label_5"),
                        new NotEmptyString("country_5"),
                        new Album(
                                new SequentialId(5),
                                new NotEmptyString("title_5"),
                                List.of(
                                        new NotEmptyString("track_1"),
                                        new NotEmptyString("track_2"),
                                        new NotEmptyString("track_3")
                                ),
                                List.of(
                                        new NotEmptyString("genre_1"),
                                        new NotEmptyString("genre_2"),
                                        new NotEmptyString("genre_3")
                                ),
                                List.of(
                                        new BasicArtistInfo(
                                                new SequentialId(5),
                                                new NotEmptyString("artist_5")
                                        )
                                ),
                                Map.of(
                                        "person_1",
                                        List.of(
                                                Credit.LYRICS_BY,
                                                Credit.MUSIC_BY
                                        ),
                                        "person_2",
                                        List.of(Credit.PHOTOGRAPHY_BY),
                                        "person_3",
                                        List.of(Credit.EXECUTIVE_PRODUCER)
                                ),
                                AlbumType.ALBUM
                        ),
                        List.of(new NotEmptyString("format_5")),
                        "catalog_number_5"
                )
        );
        InMemoryReleaseRepository sut = new InMemoryReleaseRepository();

        // when
        List<Release> result = sut.all();

        // then
        assert result.equals(expected);
    }
}
