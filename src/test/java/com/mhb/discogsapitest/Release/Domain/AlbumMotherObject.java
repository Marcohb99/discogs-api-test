package com.mhb.discogsapitest.Release.Domain;

import com.mhb.discogsapitest.Shared.Domain.NotEmptyString;
import com.mhb.discogsapitest.Shared.Domain.SequentialId;
import org.apache.commons.lang3.RandomStringUtils;

import javax.annotation.Nullable;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class AlbumMotherObject {
    private final static int DEFAULT_QUANTITY = 5;
    public static Album createRandom(@Nullable Integer id) {
        Random random = new Random();
        if (id == null) {
            id = random.nextInt(1, 1000);
        }
        // trackList
        List<NotEmptyString> trackList = new ArrayList<>();
        for (int i = 0; i < DEFAULT_QUANTITY; i++) {
            trackList.add(new NotEmptyString(RandomStringUtils.randomAlphabetic(10)));
        }
        // genres
        List<NotEmptyString> genres = new ArrayList<>();
        for (int i = 0; i < DEFAULT_QUANTITY; i++) {
            genres.add(new NotEmptyString(RandomStringUtils.randomAlphabetic(10)));
        }

        return new Album(
                new SequentialId(id),
                new NotEmptyString(RandomStringUtils.randomAlphabetic(10)),
                trackList,
                genres,
                new NotEmptyString(RandomStringUtils.randomAlphabetic(10))
        );
    }
}
