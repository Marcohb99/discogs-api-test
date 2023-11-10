package com.mhb.discogsapitest.Release.Domain.Exception;

import com.mhb.discogsapitest.Shared.Domain.Exception.DomainException;

public class InvalidAlbum extends DomainException {
    public InvalidAlbum(String message) {
        super(message);
    }

    public static InvalidAlbum emptyTrackList() {
        return new InvalidAlbum("Album track list cannot be empty");
    }

    public static InvalidAlbum emptyGenres() {
        return new InvalidAlbum("Album genre list cannot be empty");
    }

    public static InvalidAlbum emptyArtists() {
        return new InvalidAlbum("Album artist list cannot be empty");
    }
}
