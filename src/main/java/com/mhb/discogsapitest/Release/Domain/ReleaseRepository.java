package com.mhb.discogsapitest.Release.Domain;

import java.util.List;

public interface ReleaseRepository {
    Release byId(int id);

    List<Release> all();
}
