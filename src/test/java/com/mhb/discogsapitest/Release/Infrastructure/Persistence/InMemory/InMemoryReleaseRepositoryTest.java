package com.mhb.discogsapitest.Release.Infrastructure.Persistence.InMemory;

import com.mhb.discogsapitest.Release.Domain.Release;
import com.mhb.discogsapitest.Release.Domain.ValueObject.BarCode;
import com.mhb.discogsapitest.Shared.Domain.NotEmptyString;
import com.mhb.discogsapitest.Shared.Domain.SequentialId;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class InMemoryReleaseRepositoryTest {

    @Test
    public void testById() {
        // given
        Release expected = new Release(
                new SequentialId(1),
                new NotEmptyString("title_1"),
                new BarCode("1234567890123")
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
                        barCode
                ),
                new Release(
                        new SequentialId(3),
                        new NotEmptyString("title_3"),
                        barCode
                ),
                new Release(
                        new SequentialId(5),
                        new NotEmptyString("title_5"),
                        barCode
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
        List.of(
                new Release(
                        new SequentialId(1),
                        new NotEmptyString("title_1"),
                        new BarCode("1234567890123")
                ),
                new Release(
                        new SequentialId(2),
                        new NotEmptyString("title_2"),
                        new BarCode("4563214569874")
                ),
                new Release(
                        new SequentialId(3),
                        new NotEmptyString("title_3"),
                        new BarCode("1234567890123")
                ),
                new Release(
                        new SequentialId(4),
                        new NotEmptyString("title_4"),
                        new BarCode("3456789012345")
                ),
                new Release(
                        new SequentialId(5),
                        new NotEmptyString("title_5"),
                        new BarCode("1234567890123")
                ),
                new Release(
                        new SequentialId(6),
                        new NotEmptyString("title_6"),
                        new BarCode("0909090909090")
                ),
                new Release(
                        new SequentialId(7),
                        new NotEmptyString("title_7"),
                        new BarCode("4545454545454")
                ),
                new Release(
                        new SequentialId(8),
                        new NotEmptyString("title_8"),
                        new BarCode("4563214569874")
                ),
                new Release(
                        new SequentialId(9),
                        new NotEmptyString("title_9"),
                        new BarCode("6547896547896")
                ),
                new Release(
                        new SequentialId(10),
                        new NotEmptyString("title_10"),
                        new BarCode("3336669993336")
                )
        );


    }
}
