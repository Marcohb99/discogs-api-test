package com.mhb.discogsapitest.Release.Infrastructure.Persistence.InMemory;

import com.mhb.discogsapitest.Release.Domain.Release;
import com.mhb.discogsapitest.Release.Domain.ReleaseRepository;
import com.mhb.discogsapitest.Release.Domain.ValueObject.BarCode;
import com.mhb.discogsapitest.Release.Domain.ValueObject.Title;
import com.mhb.discogsapitest.Shared.Domain.SequentialId;
import org.springframework.stereotype.Repository;

@Repository
public class InMemoryReleaseRepository implements ReleaseRepository {
    @Override
    public Release byId(int id) {
        return new Release(
                new SequentialId(1),
                new Title("title"),
                new BarCode("1234567890123")
        );
    }
}
