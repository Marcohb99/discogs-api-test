package com.mhb.discogsapitest.Release.Domain;

import com.mhb.discogsapitest.Release.Domain.ValueObject.Title;
import com.mhb.discogsapitest.Release.Domain.ValueObject.BarCode;
import com.mhb.discogsapitest.Shared.Domain.SequentialId;

public class Release {
    private SequentialId id;
    private Title title;
    private BarCode barCode;
}
