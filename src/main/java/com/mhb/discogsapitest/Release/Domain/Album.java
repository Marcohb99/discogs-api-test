package com.mhb.discogsapitest.Release.Domain;

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
    private final NotEmptyString artistName;

    public Album(
            SequentialId id,
            NotEmptyString title,
            List<NotEmptyString> trackList,
            List<NotEmptyString> genres,
            NotEmptyString artistName
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
        this.artistName = artistName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Album album = (Album) o;
        return Objects.equals(id, album.id)
                && Objects.equals(title, album.title)
                && Objects.equals(artistName, album.artistName)
                && Objects.equals(trackList, album.trackList)
                && Objects.equals(genres, album.genres);
    }
}
