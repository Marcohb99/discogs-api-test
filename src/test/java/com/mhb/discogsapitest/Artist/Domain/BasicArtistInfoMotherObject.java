package com.mhb.discogsapitest.Artist.Domain;

import com.mhb.discogsapitest.Artist.Domain.ValueObject.BasicArtistInfo;
import com.mhb.discogsapitest.Shared.Domain.NotEmptyString;
import com.mhb.discogsapitest.Shared.Domain.SequentialId;
import io.micrometer.common.lang.Nullable;
import org.apache.commons.lang3.RandomStringUtils;

import java.util.Random;

public class BasicArtistInfoMotherObject {
    public static BasicArtistInfo createRandom(@Nullable Integer id) {
        if (id == null) {
            Random random = new Random();
            id = random.nextInt(1, 1000);
        }
        return new BasicArtistInfo(
                new SequentialId(id),
                new NotEmptyString(RandomStringUtils.randomAlphabetic(10))
        );
    }
}
