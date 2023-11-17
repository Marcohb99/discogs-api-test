package com.mhb.discogsapitest.Artist.Domain;

import com.mhb.discogsapitest.Artist.Domain.ValueObject.BasicArtistInfo;
import com.mhb.discogsapitest.Shared.Domain.NotEmptyString;
import com.mhb.discogsapitest.Shared.Domain.SequentialId;
import lombok.EqualsAndHashCode;
import lombok.Getter;

import java.net.URL;
import java.util.List;
import java.util.Map;

@Getter
public class IndividualArtist extends Artist {
    private final Map<SequentialId, NotEmptyString> bands;

    private final String realName;

    public IndividualArtist(
            BasicArtistInfo basicArtistInfo,
            NotEmptyString description,
            Map<SequentialId, NotEmptyString> aliases,
            Map<SequentialId, NotEmptyString> nameVariations,
            List<URL> sites,
            Map<SequentialId, NotEmptyString> bands,
            String realName
    ) {
        super(basicArtistInfo, description, aliases, nameVariations, sites);
        this.bands = bands;
        this.realName = realName;
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof IndividualArtist individualArtist)) return false;
        return super.equals(obj)
                && bands.equals(individualArtist.bands)
                && realName.equals(individualArtist.realName);
    }
}
