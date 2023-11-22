package com.mhb.discogsapitest.Artist.Domain;

import com.mhb.discogsapitest.Shared.Domain.NotEmptyString;
import org.apache.commons.lang3.RandomStringUtils;

import javax.annotation.Nullable;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.Map;

public class ArtistMotherObject {
    public static Artist random(@Nullable Integer id, @Nullable Integer type) throws MalformedURLException {
        return type == null || type == 1 ? randomIndividual(id) : randomBand(id);
    }

    private static Band randomBand(Integer id) throws MalformedURLException {
        return new Band(
                BasicArtistInfoMotherObject.createRandom(id),
                new NotEmptyString(RandomStringUtils.randomAlphabetic(10)),
                Map.of(
                        1, new NotEmptyString(RandomStringUtils.randomAlphabetic(10)),
                        2, new NotEmptyString(RandomStringUtils.randomAlphabetic(10))
                ),
                Map.of(
                        11, new NotEmptyString(RandomStringUtils.randomAlphabetic(10)),
                        22, new NotEmptyString(RandomStringUtils.randomAlphabetic(10))
                ),
                Map.of(
                        111, new NotEmptyString(RandomStringUtils.randomAlphabetic(10)),
                        222, new NotEmptyString(RandomStringUtils.randomAlphabetic(10))
                ),
                List.of(
                        new URL("https://www." + RandomStringUtils.randomAlphabetic(10) + ".com"),
                        new URL("https://www." + RandomStringUtils.randomAlphabetic(10) + ".com")
                )
        );
    }

    private static IndividualArtist randomIndividual(Integer id) throws MalformedURLException {
        return new IndividualArtist(
                BasicArtistInfoMotherObject.createRandom(id),
                new NotEmptyString(RandomStringUtils.randomAlphabetic(10)),
                Map.of(
                        1, new NotEmptyString(RandomStringUtils.randomAlphabetic(10)),
                        2, new NotEmptyString(RandomStringUtils.randomAlphabetic(10))
                ),
                Map.of(
                        11, new NotEmptyString(RandomStringUtils.randomAlphabetic(10)),
                        22, new NotEmptyString(RandomStringUtils.randomAlphabetic(10))
                ),
                List.of(
                        new URL("https://www." + RandomStringUtils.randomAlphabetic(10) + ".com"),
                        new URL("https://www." + RandomStringUtils.randomAlphabetic(10) + ".com")
                ),
                new NotEmptyString(RandomStringUtils.randomAlphabetic(10)),
                Map.of(
                        111, new NotEmptyString(RandomStringUtils.randomAlphabetic(10)),
                        222, new NotEmptyString(RandomStringUtils.randomAlphabetic(10))
                )
        );
    }
}
