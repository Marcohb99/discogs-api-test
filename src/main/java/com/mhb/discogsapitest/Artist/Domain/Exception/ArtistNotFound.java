package com.mhb.discogsapitest.Artist.Domain.Exception;

import com.mhb.discogsapitest.Shared.Domain.Exception.DomainException;
import com.mhb.discogsapitest.Shared.Domain.SequentialId;

public class ArtistNotFound extends DomainException {
    public ArtistNotFound(String message) {
        super(message);
    }

    public static ArtistNotFound fromId(SequentialId id) {
        return new ArtistNotFound("Artist with id " + id.getValue() + " not found");
    }
}
