package com.mhb.discogsapitest.Release.Infrastructure.Persistence.InMemory;

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
                new NotEmptyString("title_1"),
                new BarCode("1234567890123"),
                new NotEmptyString("artist_1"),
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
                new Date(),
                Map.of(
                        new NotEmptyString("person_1"),
                        List.of(
                                Credit.LYRICS_BY,
                                Credit.MUSIC_BY
                        ),
                        new NotEmptyString("person_2"),
                        List.of(Credit.PHOTOGRAPHY_BY),
                        new NotEmptyString("person_3"),
                        List.of(Credit.EXECUTIVE_PRODUCER)
                ),
                new NotEmptyString("label_1"),
                new NotEmptyString("country_1")
        );
        InMemoryReleaseRepository sut = new InMemoryReleaseRepository();

        // when
        Release result = sut.byId(new SequentialId(1));

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
                        new NotEmptyString("title_1"),
                        new BarCode("1234567890123"),
                        new NotEmptyString("artist_1"),
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
                        new Date(),
                        Map.of(
                                new NotEmptyString("person_1"),
                                List.of(
                                        Credit.LYRICS_BY,
                                        Credit.MUSIC_BY
                                ),
                                new NotEmptyString("person_2"),
                                List.of(Credit.PHOTOGRAPHY_BY),
                                new NotEmptyString("person_3"),
                                List.of(Credit.EXECUTIVE_PRODUCER)
                        ),
                        new NotEmptyString("label_1"),
                        new NotEmptyString("country_1")
                ),
                new Release(
                        new SequentialId(3),
                        new NotEmptyString("title_3"),
                        new BarCode("1234567890123"),
                        new NotEmptyString("artist_3"),
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
                        new Date(),
                        Map.of(
                                new NotEmptyString("person_1"),
                                List.of(Credit.LYRICS_BY, Credit.MUSIC_BY),
                                new NotEmptyString("person_2"),
                                List.of(Credit.PHOTOGRAPHY_BY),
                                new NotEmptyString("person_3"),
                                List.of(Credit.EXECUTIVE_PRODUCER)
                        ),
                        new NotEmptyString("label_3"),
                        new NotEmptyString("country_3")
                ),
                new Release(
                        new SequentialId(5),
                        new NotEmptyString("title_5"),
                        new BarCode("1234567890123"),
                        new NotEmptyString("artist_5"),
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
                        new Date(),
                        Map.of(
                                new NotEmptyString("person_1"),
                                List.of(Credit.LYRICS_BY, Credit.MUSIC_BY),
                                new NotEmptyString("person_2"),
                                List.of(Credit.PHOTOGRAPHY_BY),
                                new NotEmptyString("person_3"),
                                List.of(Credit.EXECUTIVE_PRODUCER)
                        ),
                        new NotEmptyString("label_5"),
                        new NotEmptyString("country_5")
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
                        new NotEmptyString("title_1"),
                        new BarCode("1234567890123"),
                        new NotEmptyString("artist_1"),
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
                        new Date(),
                        Map.of(
                                new NotEmptyString("person_1"),
                                List.of(
                                        Credit.LYRICS_BY,
                                        Credit.MUSIC_BY
                                ),
                                new NotEmptyString("person_2"),
                                List.of(Credit.PHOTOGRAPHY_BY),
                                new NotEmptyString("person_3"),
                                List.of(Credit.EXECUTIVE_PRODUCER)
                        ),
                        new NotEmptyString("label_1"),
                        new NotEmptyString("country_1")
                ),
                new Release(
                        new SequentialId(2),
                        new NotEmptyString("title_2"),
                        new BarCode("4563214569874"),
                        new NotEmptyString("artist_2"),
                        List.of(
                                new NotEmptyString("track_1"),
                                new NotEmptyString("track_2"),
                                new NotEmptyString("track_3")
                        ),
                        List.of(new NotEmptyString("genre_1")),
                        new Date(),
                        Map.of(
                                new NotEmptyString("person_1"),
                                List.of(Credit.LYRICS_BY, Credit.MUSIC_BY),
                                new NotEmptyString("person_3"),
                                List.of(Credit.EXECUTIVE_PRODUCER)
                        ),
                        new NotEmptyString("label_2"),
                        new NotEmptyString("country_2")
                ),
                new Release(
                        new SequentialId(3),
                        new NotEmptyString("title_3"),
                        new BarCode("1234567890123"),
                        new NotEmptyString("artist_3"),
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
                        new Date(),
                        Map.of(
                                new NotEmptyString("person_1"),
                                List.of(Credit.LYRICS_BY, Credit.MUSIC_BY),
                                new NotEmptyString("person_2"),
                                List.of(Credit.PHOTOGRAPHY_BY),
                                new NotEmptyString("person_3"),
                                List.of(Credit.EXECUTIVE_PRODUCER)
                        ),
                        new NotEmptyString("label_3"),
                        new NotEmptyString("country_3")
                ),
                new Release(
                        new SequentialId(4),
                        new NotEmptyString("title_4"),
                        new BarCode("3456789012345"),
                        new NotEmptyString("artist_4"),
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
                        new Date(),
                        Map.of(
                                new NotEmptyString("person_1"),
                                List.of(Credit.LYRICS_BY, Credit.MUSIC_BY),
                                new NotEmptyString("person_2"),
                                List.of(Credit.PHOTOGRAPHY_BY),
                                new NotEmptyString("person_3"),
                                List.of(Credit.EXECUTIVE_PRODUCER)
                        ),
                        new NotEmptyString("label_4"),
                        new NotEmptyString("country_4")
                ),
                new Release(
                        new SequentialId(5),
                        new NotEmptyString("title_5"),
                        new BarCode("1234567890123"),
                        new NotEmptyString("artist_5"),
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
                        new Date(),
                        Map.of(
                                new NotEmptyString("person_1"),
                                List.of(Credit.LYRICS_BY, Credit.MUSIC_BY),
                                new NotEmptyString("person_2"),
                                List.of(Credit.PHOTOGRAPHY_BY),
                                new NotEmptyString("person_3"),
                                List.of(Credit.EXECUTIVE_PRODUCER)
                        ),
                        new NotEmptyString("label_5"),
                        new NotEmptyString("country_5")
                ),
                new Release(
                        new SequentialId(6),
                        new NotEmptyString("title_6"),
                        new BarCode("0909090909090"),
                        new NotEmptyString("artist_6"),
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
                        new Date(),
                        Map.of(
                                new NotEmptyString("person_1"),
                                List.of(Credit.LYRICS_BY, Credit.MUSIC_BY),
                                new NotEmptyString("person_2"),
                                List.of(Credit.PHOTOGRAPHY_BY),
                                new NotEmptyString("person_3"),
                                List.of(Credit.EXECUTIVE_PRODUCER)
                        ),
                        new NotEmptyString("label_6"),
                        new NotEmptyString("country_6")
                ),
                new Release(
                        new SequentialId(7),
                        new NotEmptyString("title_7"),
                        new BarCode("4545454545454"),
                        new NotEmptyString("artist_7"),
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
                        new Date(),
                        Map.of(
                                new NotEmptyString("person_1"),
                                List.of(Credit.LYRICS_BY, Credit.MUSIC_BY),
                                new NotEmptyString("person_2"),
                                List.of(Credit.PHOTOGRAPHY_BY),
                                new NotEmptyString("person_3"),
                                List.of(Credit.EXECUTIVE_PRODUCER)
                        ),
                        new NotEmptyString("label_7"),
                        new NotEmptyString("country_7")
                ),
                new Release(
                        new SequentialId(8),
                        new NotEmptyString("title_8"),
                        new BarCode("4563214569874"),
                        new NotEmptyString("artist_8"),
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
                        new Date(),
                        Map.of(
                                new NotEmptyString("person_1"),
                                List.of(Credit.LYRICS_BY, Credit.MUSIC_BY),
                                new NotEmptyString("person_3"),
                                List.of(Credit.EXECUTIVE_PRODUCER)
                        ),
                        new NotEmptyString("label_8"),
                        new NotEmptyString("country_8")
                ),
                new Release(
                        new SequentialId(9),
                        new NotEmptyString("title_9"),
                        new BarCode("6547896547896"),
                        new NotEmptyString("artist_9"),
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
                        new Date(),
                        Map.of(
                                new NotEmptyString("person_1"),
                                List.of(Credit.LYRICS_BY, Credit.MUSIC_BY),
                                new NotEmptyString("person_2"),
                                List.of(Credit.PHOTOGRAPHY_BY),
                                new NotEmptyString("person_3"),
                                List.of(Credit.EXECUTIVE_PRODUCER)
                        ),
                        new NotEmptyString("label_9"),
                        new NotEmptyString("country_9")
                ),
                new Release(
                        new SequentialId(10),
                        new NotEmptyString("title_10"),
                        new BarCode("3336669993336"),
                        new NotEmptyString("artist_10"),
                        List.of(
                                new NotEmptyString("track_1"),
                                new NotEmptyString("track_2"),
                                new NotEmptyString("track_3")
                        ),
                        List.of(new NotEmptyString("genre_1")),
                        new Date(),
                        Map.of(
                                new NotEmptyString("person_1"),
                                List.of(Credit.LYRICS_BY, Credit.MUSIC_BY),
                                new NotEmptyString("person_3"),
                                List.of(Credit.EXECUTIVE_PRODUCER)
                        ),
                        new NotEmptyString("label_10"),
                        new NotEmptyString("country_10")
                )
        );
        InMemoryReleaseRepository sut = new InMemoryReleaseRepository();

        // when
        List<Release> result = sut.all();

        // then
        assert result.equals(expected);
    }
}
