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
public abstract class Artist {
    private final BasicArtistInfo basicArtistInfo;

    private final NotEmptyString description;

    private final Map<SequentialId, NotEmptyString> aliases;

    private final Map<SequentialId, NotEmptyString> nameVariations;

    private final List<URL> sites;

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Artist artist)) return false;
        return basicArtistInfo.equals(artist.basicArtistInfo)
                && description.equals(artist.description)
                && aliases.equals(artist.aliases)
                && nameVariations.equals(artist.nameVariations)
                && sites.equals(artist.sites);
    }
}
