package com.mhb.discogsapitest.Artist.Domain.ValueObject;

import com.mhb.discogsapitest.Shared.Domain.NotEmptyString;
import com.mhb.discogsapitest.Shared.Domain.SequentialId;

public record BasicArtistInfo(SequentialId id, NotEmptyString name) {

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof BasicArtistInfo basicArtistInfo)) return false;
        return id.equals(basicArtistInfo.id) && name.equals(basicArtistInfo.name);
    }
}
