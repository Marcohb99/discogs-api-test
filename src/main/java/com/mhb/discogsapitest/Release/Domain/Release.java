package com.mhb.discogsapitest.Release.Domain;

import com.mhb.discogsapitest.Album.Domain.Album;
import com.mhb.discogsapitest.Release.Domain.Exception.InvalidFormatName;
import com.mhb.discogsapitest.Release.Domain.ValueObject.BarCode;
import com.mhb.discogsapitest.Release.Domain.ValueObject.Credit;
import com.mhb.discogsapitest.Shared.Domain.NotEmptyString;
import com.mhb.discogsapitest.Shared.Domain.SequentialId;
import io.micrometer.common.lang.Nullable;
import lombok.Getter;

import java.util.*;

public class Release {
    @Getter
    private final SequentialId id;

    @Getter
    private final BarCode barCode;

    @Getter
    private final Date releaseDate;

    @Getter
    private final Map<NotEmptyString, List<Credit>> credits;

    @Getter
    private final NotEmptyString label;

    @Getter
    private final NotEmptyString country;

    @Getter
    private final Album album;

    @Getter
    private final List<NotEmptyString> formatName;

    @Getter
    private String catalogNumber;

    public Release(
            SequentialId id,
            BarCode barCode,
            Date releaseDate,
            Map<NotEmptyString,List<Credit>> credits,
            NotEmptyString label,
            NotEmptyString country,
            Album album,
            List<NotEmptyString> formatName,
            @Nullable String catalogNumber
    ) {
        this.id = id;
        this.barCode = barCode;
        this.releaseDate = releaseDate;
        this.credits = credits;
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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Release release = (Release) o;
        return Objects.equals(id, release.id)
                && Objects.equals(barCode, release.barCode)
                && Objects.equals(releaseDate, release.releaseDate)
                && Objects.equals(credits, release.credits)
                && Objects.equals(label, release.label)
                && Objects.equals(country, release.country)
                && Objects.equals(album, release.album)
                && Objects.equals(formatName, release.formatName);
    }
}
