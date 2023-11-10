package com.mhb.discogsapitest.Release.Domain;

import com.mhb.discogsapitest.Release.Domain.ValueObject.BarCode;
import com.mhb.discogsapitest.Release.Domain.ValueObject.Credit;
import com.mhb.discogsapitest.Shared.Domain.NotEmptyString;
import com.mhb.discogsapitest.Shared.Domain.SequentialId;
import org.apache.commons.lang3.RandomStringUtils;

import javax.annotation.Nullable;
import java.util.*;

public class ReleaseMotherObject {
    private final static int DEFAULT_QUANTITY = 5;

    public static Release createRandom(@Nullable Integer id) {
        Random random = new Random();
        if (id == null) {
            id = random.nextInt(1, 1000);
        }

        List<NotEmptyString> formats = new ArrayList<>();
        for (int i = 0; i < DEFAULT_QUANTITY; i++) {
            formats.add(new NotEmptyString(RandomStringUtils.randomAlphabetic(10)));
        }

        return new Release(
                new SequentialId(id),
                new BarCode(RandomStringUtils.randomNumeric(13)),
                new Date(),
                defaultCredits(),
                new NotEmptyString(RandomStringUtils.randomAlphabetic(10)),
                new NotEmptyString(RandomStringUtils.randomAlphabetic(10)),
                AlbumMotherObject.createRandom(id),
                formats
        );
    }

    private static Map<NotEmptyString, List<Credit>> defaultCredits() {
        Map<NotEmptyString, List<Credit>> credits = new HashMap<>();
        credits.put(
                new NotEmptyString("artist_1"),
                List.of(Credit.LYRICS_BY, Credit.MUSIC_BY)
        );
        credits.put(
                new NotEmptyString("prod_1"),
                List.of(Credit.EXECUTIVE_PRODUCER, Credit.MASTERED_BY)
        );
        return credits;
    }
}
