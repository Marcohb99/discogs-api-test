package com.mhb.discogsapitest.Artist.Domain;

import com.mhb.discogsapitest.Artist.Domain.ValueObject.BasicArtistInfo;
import com.mhb.discogsapitest.Shared.Domain.NotEmptyString;
import lombok.Getter;

import java.net.URL;
import java.util.List;
import java.util.Map;

@Getter
public class Band extends Artist {
    private final Map<Integer, NotEmptyString> members;

    public Band(
            BasicArtistInfo basicArtistInfo,
            NotEmptyString description,
            Map<Integer, NotEmptyString> aliases,
            Map<Integer, NotEmptyString> nameVariations,
            Map<Integer, NotEmptyString> members,
            List<URL> sites
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
