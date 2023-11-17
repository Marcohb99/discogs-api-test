package com.mhb.discogsapitest.Release.Domain;

import com.mhb.discogsapitest.Album.Domain.Album;
import com.mhb.discogsapitest.Release.Domain.Exception.InvalidFormatName;
import com.mhb.discogsapitest.Release.Domain.ValueObject.BarCode;
import com.mhb.discogsapitest.Release.Domain.ValueObject.Credit;
import com.mhb.discogsapitest.Shared.Domain.NotEmptyString;
import com.mhb.discogsapitest.Shared.Domain.SequentialId;
import io.micrometer.common.lang.Nullable;
import lombok.EqualsAndHashCode;
import lombok.Getter;

import java.util.*;

@Getter
public class Release {
    private final SequentialId id;

    private final BarCode barCode;

    private final Date releaseDate;

    private final NotEmptyString label;

    private final NotEmptyString country;

    private final Album album;

    private final List<NotEmptyString> formatName;

    private String catalogNumber;

    public Release(
            SequentialId id,
            BarCode barCode,
            Date releaseDate,
            NotEmptyString label,
            NotEmptyString country,
            Album album,
            List<NotEmptyString> formatName,
            @Nullable String catalogNumber
    ) {
        this.id = id;
        this.barCode = barCode;
        this.releaseDate = releaseDate;
        this.label = label;
        this.country = country;
        this.album = album;
        if (formatName.size() == 0) {
            throw InvalidFormatName.empty();
        }
        this.formatName = formatName;
        if (catalogNumber == null) {
            // see for example https://www.discogs.com/release/15734227-Glass-Animals-Dreamland
            this.catalogNumber = "none";
        }
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Release release)) return false;

        System.out.println("Album " + album.equals(release.album));

        return id.equals(release.id)
                && barCode.equals(release.barCode)
                && releaseDate.equals(release.releaseDate)
                && label.equals(release.label)
                && country.equals(release.country)
                && album.equals(release.album)
                && formatName.equals(release.formatName)
                && Objects.equals(release.catalogNumber, catalogNumber);
    }
}
