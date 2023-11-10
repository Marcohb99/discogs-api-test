package com.mhb.discogsapitest.Release.Domain;

import com.mhb.discogsapitest.Release.Domain.Exception.InvalidFormatName;
import com.mhb.discogsapitest.Release.Domain.ValueObject.BarCode;
import com.mhb.discogsapitest.Release.Domain.ValueObject.Credit;
import com.mhb.discogsapitest.Shared.Domain.NotEmptyString;
import com.mhb.discogsapitest.Shared.Domain.SequentialId;
import lombok.Getter;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Objects;

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

    public Release(
            SequentialId id,
            BarCode barCode,
            Date releaseDate,
            Map<NotEmptyString,List<Credit>> credits,
            NotEmptyString label,
            NotEmptyString country,
            Album album,
            List<NotEmptyString> formatName
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
