package com.mhb.discogsapitest.Release.Domain;

import com.mhb.discogsapitest.Release.Domain.ValueObject.BarCode;
import com.mhb.discogsapitest.Shared.Domain.NotEmptyString;
import com.mhb.discogsapitest.Shared.Domain.SequentialId;
import org.apache.commons.lang3.RandomStringUtils;

import java.util.Random;

public class ReleaseMotherObject {
    public static Release createRandom(int id) {
        Random random = new Random();
        if (id == 0) {
            id = random.nextInt(1, 1000);
        }
        return new Release(
                new SequentialId(id),
                new NotEmptyString(RandomStringUtils.randomAlphabetic(10)),
                new BarCode(RandomStringUtils.randomNumeric(13))
        );
    }
}
