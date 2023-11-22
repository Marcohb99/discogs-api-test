package com.mhb.discogsapitest.Release.Domain;

import java.util.ArrayList;
import java.util.List;

public class ReleaseCollectionMotherObject {
    public static List<Release> createRandom(int quantity) {
        List<Release> releases = new ArrayList<>();
        for (int i = 0; i < quantity; i++) {
            releases.add(ReleaseMotherObject.createRandom(i + 1, null));
        }
        return releases;
    }
}
