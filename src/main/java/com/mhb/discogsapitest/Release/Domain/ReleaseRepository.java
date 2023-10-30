package com.mhb.discogsapitest.Release.Domain;

import com.mhb.discogsapitest.Release.Domain.ValueObject.BarCode;
import com.mhb.discogsapitest.Release.Domain.ValueObject.Title;

import java.util.List;

public interface ReleaseRepository {
    Release byId(int id);

    List<Release> all();

    List<Release> byBarCode(BarCode barCode);
}
