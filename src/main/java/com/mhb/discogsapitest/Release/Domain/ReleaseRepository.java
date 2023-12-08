package com.mhb.discogsapitest.Release.Domain;

import com.mhb.discogsapitest.Release.Domain.ValueObject.BarCode;
import com.mhb.discogsapitest.Shared.Domain.SequentialId;

import java.util.List;

public interface ReleaseRepository {
    Release byId(SequentialId id);

    List<Release> all();

    List<Release> byBarCode(BarCode barCode);

    List<Release> byArtistId(SequentialId artistId);
}
