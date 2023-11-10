package com.mhb.discogsapitest.Artist.Domain.ValueObject;

import com.mhb.discogsapitest.Shared.Domain.NotEmptyString;
import com.mhb.discogsapitest.Shared.Domain.SequentialId;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
public class BasicArtistInfo {
    @Getter
    private final SequentialId id;

    @Getter
    private final NotEmptyString name;
}
