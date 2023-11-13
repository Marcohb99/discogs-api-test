package com.mhb.discogsapitest.Album.Domain;

import com.mhb.discogsapitest.Artist.Domain.ValueObject.BasicArtistInfo;
import com.mhb.discogsapitest.Release.Domain.Exception.InvalidAlbum;
import com.mhb.discogsapitest.Shared.Domain.NotEmptyString;
import com.mhb.discogsapitest.Shared.Domain.SequentialId;
import lombok.Getter;

import java.util.List;
import java.util.Objects;

public class Album {
    @Getter
    private final SequentialId id;

    @Getter
    private final NotEmptyString title;

    @Getter
    private final List<NotEmptyString> trackList;

    @Getter
    private final List<NotEmptyString> genres;

    @Getter
    private final List<BasicArtistInfo> artists;

    public Album(
            SequentialId id,
            NotEmptyString title,
            List<NotEmptyString> trackList,
            List<NotEmptyString> genres,
            List<BasicArtistInfo> artists
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
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Album album = (Album) o;
        return Objects.equals(id, album.id)
                && Objects.equals(title, album.title)
                && Objects.equals(trackList, album.trackList)
                && Objects.equals(genres, album.genres)
                && Objects.equals(artists, album.artists);
    }
}
