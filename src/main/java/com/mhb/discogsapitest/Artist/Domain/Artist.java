package com.mhb.discogsapitest.Artist.Domain;

import com.mhb.discogsapitest.Artist.Domain.ValueObject.BasicArtistInfo;
import com.mhb.discogsapitest.Shared.Domain.NotEmptyString;
import com.mhb.discogsapitest.Shared.Domain.SequentialId;
import lombok.AllArgsConstructor;
import lombok.Getter;

import javax.annotation.Nullable;
import java.net.URL;
import java.util.List;
import java.util.Map;
import java.util.Objects;

@Getter
@AllArgsConstructor
public abstract class Artist {
    private final BasicArtistInfo basicArtistInfo;

    private final NotEmptyString description;

    private final @Nullable Map<Integer, NotEmptyString> aliases;

    private final @Nullable Map<Integer, NotEmptyString> nameVariations;

    private final List<URL> sites;

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Artist artist)) return false;
        boolean nameVariationsAreEqual = Objects.equals(nameVariations, artist.nameVariations);
        boolean aliasesAreEqual = Objects.equals(aliases, artist.aliases);

        return basicArtistInfo.equals(artist.basicArtistInfo)
                && description.equals(artist.description)
                && aliasesAreEqual
                && nameVariationsAreEqual
                && sites.equals(artist.sites);
    }
}
