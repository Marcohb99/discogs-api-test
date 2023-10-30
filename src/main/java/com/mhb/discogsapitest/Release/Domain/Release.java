package com.mhb.discogsapitest.Release.Domain;

import com.mhb.discogsapitest.Release.Domain.ValueObject.Title;
import com.mhb.discogsapitest.Release.Domain.ValueObject.BarCode;
import com.mhb.discogsapitest.Shared.Domain.SequentialId;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
public class Release {
    @Getter
    private SequentialId id;
    @Getter
    private Title title;
    @Getter
    private BarCode barCode;
}
