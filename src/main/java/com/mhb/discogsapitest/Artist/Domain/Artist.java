package com.mhb.discogsapitest.Artist.Domain;

import com.mhb.discogsapitest.Artist.Domain.ValueObject.BasicArtistInfo;
import com.mhb.discogsapitest.Shared.Domain.NotEmptyString;
import com.mhb.discogsapitest.Shared.Domain.SequentialId;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;

import java.net.URL;
import java.util.List;
import java.util.Map;

@Getter
@AllArgsConstructor
@EqualsAndHashCode
public abstract class Artist {
    private final BasicArtistInfo basicArtistInfo;

    private final NotEmptyString description;

    private final Map<SequentialId, NotEmptyString> aliases;

    private final Map<SequentialId, NotEmptyString> nameVariations;

    private final List<URL> sites;
}
