package com.mhb.discogsapitest.Release.Infrastructure.Persistence.InMemory;

import com.mhb.discogsapitest.Release.Domain.Release;
import com.mhb.discogsapitest.Release.Domain.ReleaseRepository;
import com.mhb.discogsapitest.Release.Domain.ValueObject.BarCode;
import com.mhb.discogsapitest.Release.Domain.ValueObject.Title;
import com.mhb.discogsapitest.Shared.Domain.SequentialId;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.stereotype.Repository;

import javax.annotation.Nullable;
import java.util.ArrayList;
import java.util.List;

@Repository
public class InMemoryReleaseRepository implements ReleaseRepository {
    private final int MAX_ELEMS = 10;

    @Override
    public Release byId(int id) {
        return new Release(
                new SequentialId(1),
                new Title("title"),
                new BarCode("1234567890123")
        );
    }

    @Override
    public List<Release> all() {
        return getReleaseList(null, null);
    }

    private List<Release> getReleaseList(@Nullable Title title, @Nullable BarCode barCode) {
        List<Release> result = new ArrayList<>();

        for (int i = 0; i < MAX_ELEMS; i++) {
            result.add(
                    new Release(
                            new SequentialId(i + 1),
                            title == null ? new Title(RandomStringUtils.randomAlphabetic(10)) : title,
                            barCode == null ? new BarCode(RandomStringUtils.randomNumeric(13)) : barCode
                    )
            );
            System.out.println(result.get(i).toString());
        }
        return result;
    }

    @Override
    public List<Release> byBarCode(BarCode barCode) {
        return this.getReleaseList(null, barCode);
    }
}
