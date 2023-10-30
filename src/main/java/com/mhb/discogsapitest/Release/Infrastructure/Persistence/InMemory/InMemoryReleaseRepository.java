package com.mhb.discogsapitest.Release.Infrastructure.Persistence.InMemory;

import com.mhb.discogsapitest.Release.Domain.Release;
import com.mhb.discogsapitest.Release.Domain.ReleaseRepository;
import com.mhb.discogsapitest.Release.Domain.ValueObject.BarCode;
import com.mhb.discogsapitest.Release.Domain.ValueObject.Title;
import com.mhb.discogsapitest.Shared.Domain.SequentialId;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class InMemoryReleaseRepository implements ReleaseRepository {
    private final String SAMPLE_TITLE = "no_title";
    private final String SAMPLE_BARCODE = "0000000000000";
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
        return getReleaseList(new Title(this.SAMPLE_TITLE), new BarCode(this.SAMPLE_BARCODE));
    }

    private List<Release> getReleaseList(Title title, BarCode barCode) {
        boolean randomizeTitle = title.getValue().equals(this.SAMPLE_TITLE);
        boolean randomizeBarCode = barCode.getValue().equals(this.SAMPLE_BARCODE);

        System.out.println("randomizeTitle: " + randomizeTitle);
        System.out.println("randomizeBarCode: " + randomizeBarCode);

        List<Release> result = new ArrayList<>();

        for (int i = 0; i < MAX_ELEMS; i++) {
            result.add(
                    new Release(
                            new SequentialId(i + 1),
                            randomizeTitle ? new Title(RandomStringUtils.randomAlphabetic(10)) : title,
                            randomizeBarCode ? new BarCode(RandomStringUtils.randomNumeric(13)) : barCode
                    )
            );
        }
        return result;
    }

    @Override
    public List<Release> byBarCode(BarCode barCode) {
        return this.getReleaseList(new Title(this.SAMPLE_TITLE), barCode);
    }
}
