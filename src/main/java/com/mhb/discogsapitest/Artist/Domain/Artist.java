package com.mhb.discogsapitest.Artist.Domain;

import com.mhb.discogsapitest.Artist.Domain.ValueObject.BasicArtistInfo;
import com.mhb.discogsapitest.Shared.Domain.NotEmptyString;
import com.mhb.discogsapitest.Shared.Domain.SequentialId;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.net.URL;
import java.util.List;
import java.util.Map;

@AllArgsConstructor
public abstract class Artist {
    @Getter
    private final BasicArtistInfo basicArtistInfo;

    @Getter
    private final NotEmptyString description;

    @Getter
    private final Map<SequentialId, NotEmptyString> aliases;

    @Getter
    private final Map<SequentialId, NotEmptyString> nameVariations;

    @Getter
    private final List<URL> sites;
}
