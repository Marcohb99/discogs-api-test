package com.mhb.discogsapitest.Artist.Domain;

import com.mhb.discogsapitest.Artist.Domain.ValueObject.BasicArtistInfo;
import com.mhb.discogsapitest.Shared.Domain.NotEmptyString;
import com.mhb.discogsapitest.Shared.Domain.SequentialId;
import lombok.EqualsAndHashCode;
import lombok.Getter;

import javax.annotation.Nullable;
import java.net.URL;
import java.util.List;
import java.util.Map;
import java.util.Objects;

@Getter
public class IndividualArtist extends Artist {
    private final @Nullable Map<Integer, NotEmptyString> bands;

    private final NotEmptyString realName;

    public IndividualArtist(
            BasicArtistInfo basicArtistInfo,
            NotEmptyString description,
            Map<Integer, NotEmptyString> aliases,
            Map<Integer, NotEmptyString> nameVariations,
            List<URL> sites,
            NotEmptyString realName,
            @Nullable Map<Integer, NotEmptyString> bands
    ) {
        super(basicArtistInfo, description, aliases, nameVariations, sites);
        this.bands = bands;
        this.realName = realName;
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof IndividualArtist individualArtist)) return false;
        boolean bandsAreEqual = Objects.equals(bands, individualArtist.bands);
        return super.equals(obj)
                && bandsAreEqual
                && realName.equals(individualArtist.realName);
    }
}
