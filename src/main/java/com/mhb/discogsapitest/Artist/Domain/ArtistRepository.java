package com.mhb.discogsapitest.Artist.Domain;

import com.mhb.discogsapitest.Shared.Domain.SequentialId;

public interface ArtistRepository {
    public Artist byId(SequentialId id);
}
