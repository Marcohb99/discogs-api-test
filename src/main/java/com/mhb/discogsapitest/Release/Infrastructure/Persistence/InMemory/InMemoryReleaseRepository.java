package com.mhb.discogsapitest.Release.Infrastructure.Persistence.InMemory;

import com.mhb.discogsapitest.Release.Domain.Release;
import com.mhb.discogsapitest.Release.Domain.ReleaseRepository;
import com.mhb.discogsapitest.Release.Domain.ValueObject.BarCode;
import com.mhb.discogsapitest.Shared.Domain.NotEmptyString;
import com.mhb.discogsapitest.Shared.Domain.SequentialId;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class InMemoryReleaseRepository implements ReleaseRepository {

    @Override
    public Release byId(SequentialId id) {
        return releases.stream()
                .filter(release -> release.getId().getValue().equals(id.getValue()))
                .findFirst()
                .orElse(null);
    }

    @Override
    public List<Release> all() {
        return releases;
    }

    @Override
    public List<Release> byBarCode(BarCode barCode) {
        return releases.stream()
                .filter(release -> release.getBarCode().getValue().equals(barCode.getValue()))
                .toList();
    }

    private static final List<Release> releases = List.of(
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
