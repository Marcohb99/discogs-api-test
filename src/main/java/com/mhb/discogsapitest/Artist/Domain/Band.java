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
public class Band extends Artist{
    private final Map<SequentialId, NotEmptyString> members;

    public Band(
            BasicArtistInfo basicArtistInfo,
            NotEmptyString description,
            Map<SequentialId, NotEmptyString> aliases,
            Map<SequentialId, NotEmptyString> nameVariations,
            List<URL> sites,
            Map<SequentialId, NotEmptyString> members
    ) {
        super(basicArtistInfo, description, aliases, nameVariations, sites);
        this.members = members;
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Band band)) return false;
        return super.equals(obj) && members.equals(band.members);
    }
}
