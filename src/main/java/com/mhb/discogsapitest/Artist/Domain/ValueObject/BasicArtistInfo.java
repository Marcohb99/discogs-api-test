package com.mhb.discogsapitest.Artist.Domain.ValueObject;

import com.mhb.discogsapitest.Shared.Domain.NotEmptyString;
import com.mhb.discogsapitest.Shared.Domain.SequentialId;

public record BasicArtistInfo(SequentialId id, NotEmptyString name) {
}
