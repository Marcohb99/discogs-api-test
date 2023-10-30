package com.mhb.discogsapitest.Release.Application.UseCase;

import com.mhb.discogsapitest.Release.Application.UseCase.Exception.GetReleasesByBarcodeException;
import com.mhb.discogsapitest.Release.Domain.Release;
import com.mhb.discogsapitest.Release.Domain.ReleaseRepository;
import com.mhb.discogsapitest.Release.Domain.ValueObject.BarCode;
import com.mhb.discogsapitest.Shared.Domain.Exception.InvalidBarCode;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class GetReleasesByBarCode {

    @Getter
    private final ReleaseRepository repository;

    public List<Release> execute(String barCode) {
        try {
            BarCode code = new BarCode(barCode);
            return this.repository.byBarCode(code);
        } catch (InvalidBarCode e) {
            throw GetReleasesByBarcodeException.fromError(e);
        }
    }
}
