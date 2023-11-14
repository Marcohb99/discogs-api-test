package com.mhb.discogsapitest.Album.Domain;

import com.mhb.discogsapitest.Artist.Domain.ValueObject.BasicArtistInfo;
import com.mhb.discogsapitest.Release.Domain.Exception.InvalidAlbum;
import com.mhb.discogsapitest.Release.Domain.ValueObject.Credit;
import com.mhb.discogsapitest.Shared.Domain.NotEmptyString;
import com.mhb.discogsapitest.Shared.Domain.SequentialId;
import lombok.EqualsAndHashCode;
import lombok.Getter;

import java.util.List;
import java.util.Map;
import java.util.Objects;

@Getter
@EqualsAndHashCode
public class Album {
    private final SequentialId id;

    private final NotEmptyString title;

    private final List<NotEmptyString> trackList;

    private final List<NotEmptyString> genres;

    private final List<BasicArtistInfo> artists;

    private final Map<NotEmptyString, List<Credit>> credits;

    public Album(
            SequentialId id,
            NotEmptyString title,
            List<NotEmptyString> trackList,
            List<NotEmptyString> genres,
            List<BasicArtistInfo> artists,
            Map<NotEmptyString, List<Credit>> credits
    ) {
        this.id = id;
        this.title = title;
        if (trackList.size() == 0) {
            throw InvalidAlbum.emptyTrackList();
        }
        this.trackList = trackList;
        if (genres.size() == 0) {
            throw InvalidAlbum.emptyGenres();
        }
        this.genres = genres;
        if (artists.size() == 0) {
            throw InvalidAlbum.emptyArtists();
        }
        this.artists = artists;
        this.credits = credits;
    }
}
