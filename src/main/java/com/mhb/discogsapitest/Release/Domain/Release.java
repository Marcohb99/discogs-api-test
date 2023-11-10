package com.mhb.discogsapitest.Release.Domain;

import com.mhb.discogsapitest.Release.Domain.ValueObject.BarCode;
import com.mhb.discogsapitest.Release.Domain.ValueObject.Credit;
import com.mhb.discogsapitest.Shared.Domain.NotEmptyString;
import com.mhb.discogsapitest.Shared.Domain.SequentialId;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Objects;

@AllArgsConstructor
public class Release {
    @Getter
    private SequentialId id;
    @Getter
    private NotEmptyString title;
    @Getter
    private BarCode barCode;

    @Getter
    private NotEmptyString artistName;

    @Getter
    private List<NotEmptyString> trackList;

    @Getter
    private List<NotEmptyString> genres;

    @Getter
    private Date releaseDate;

    @Getter
    private Map<NotEmptyString,List<Credit>> credits;


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Release release = (Release) o;
        return Objects.equals(id, release.id)
                && Objects.equals(title, release.title)
                && Objects.equals(barCode, release.barCode)
                && Objects.equals(artistName, release.artistName)
                && Objects.equals(trackList, release.trackList)
                && Objects.equals(genres, release.genres)
                && Objects.equals(releaseDate, release.releaseDate)
                && Objects.equals(credits, release.credits);
    }
}
