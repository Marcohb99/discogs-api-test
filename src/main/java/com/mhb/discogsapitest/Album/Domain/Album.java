package com.mhb.discogsapitest.Album.Domain;

import com.mhb.discogsapitest.Artist.Domain.ValueObject.BasicArtistInfo;
import com.mhb.discogsapitest.Release.Domain.Exception.InvalidAlbum;
import com.mhb.discogsapitest.Release.Domain.ValueObject.Credit;
import com.mhb.discogsapitest.Shared.Domain.NotEmptyString;
import com.mhb.discogsapitest.Shared.Domain.SequentialId;
import lombok.Getter;

import java.util.List;
import java.util.Map;

@Getter
public class Album {
    private final SequentialId id;

    private final NotEmptyString title;

    private final List<NotEmptyString> trackList;

    private final List<NotEmptyString> genres;

    private final List<BasicArtistInfo> artists;

    private final Map<String, List<Credit>> credits;

    private final AlbumType albumType;

    public Album(
            SequentialId id,
            NotEmptyString title,
            List<NotEmptyString> trackList,
            List<NotEmptyString> genres,
            List<BasicArtistInfo> artists,
            Map<String, List<Credit>> credits,
            AlbumType albumType
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
        if(credits.keySet().stream().anyMatch(key -> key.length() == 0 || key.isBlank())) {
            throw InvalidAlbum.invalidCredits();
        };
        this.credits = credits;
        this.albumType = albumType;
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Album album)) return false;

        if (album.credits.size() != credits.size()) return false;

        return id.equals(album.id)
                && title.equals(album.title)
                && trackList.equals(album.trackList)
                && genres.equals(album.genres)
                && artists.equals(album.artists)
                && credits.equals(album.credits)
                && albumType.equals(album.albumType);
    }
}
