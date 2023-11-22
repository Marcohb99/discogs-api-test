package com.mhb.discogsapitest.Release.Domain;

import com.mhb.discogsapitest.Album.Domain.Album;
import com.mhb.discogsapitest.Album.Domain.AlbumType;
import com.mhb.discogsapitest.Artist.Domain.BasicArtistInfoMotherObject;
import com.mhb.discogsapitest.Artist.Domain.ValueObject.BasicArtistInfo;
import com.mhb.discogsapitest.Release.Domain.ValueObject.Credit;
import com.mhb.discogsapitest.Shared.Domain.NotEmptyString;
import com.mhb.discogsapitest.Shared.Domain.SequentialId;
import org.apache.commons.lang3.RandomStringUtils;

import javax.annotation.Nullable;
import java.util.*;

public class AlbumMotherObject {
    private final static int DEFAULT_QUANTITY = 5;
    public static Album createRandom(@Nullable Integer id, @Nullable AlbumType albumType) {
        Random random = new Random();
        if (id == null) {
            id = random.nextInt(1, 1000);
        }
        if (albumType == null) {
            albumType = id % 2 == 0 ? AlbumType.ALBUM : AlbumType.SINGLE;
            if (id < 500) {
                albumType = AlbumType.EP;
            }
        }
        // trackList
        List<NotEmptyString> trackList = new ArrayList<>();
        for (int i = 0; i < DEFAULT_QUANTITY; i++) {
            trackList.add(new NotEmptyString(RandomStringUtils.randomAlphabetic(10)));
        }
        // genres
        List<NotEmptyString> genres = new ArrayList<>();
        List<BasicArtistInfo> artists = new ArrayList<>();
        for (int i = 0; i < DEFAULT_QUANTITY; i++) {
            genres.add(new NotEmptyString(RandomStringUtils.randomAlphabetic(10)));
            artists.add(BasicArtistInfoMotherObject.createRandom(i + 1));
        }

        return new Album(
                new SequentialId(id),
                new NotEmptyString(RandomStringUtils.randomAlphabetic(10)),
                trackList,
                genres,
                artists,
                defaultCredits(),
                albumType
        );
    }

    private static Map<String, List<Credit>> defaultCredits() {
        Map<String, List<Credit>> credits = new HashMap<>();
        credits.put(
                "artist_1",
                List.of(Credit.LYRICS_BY, Credit.MUSIC_BY)
        );
        credits.put(
                "prod_1",
                List.of(Credit.EXECUTIVE_PRODUCER, Credit.MASTERED_BY)
        );
        return credits;
    }
}
