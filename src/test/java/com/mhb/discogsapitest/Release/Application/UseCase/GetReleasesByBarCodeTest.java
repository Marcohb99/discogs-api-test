package com.mhb.discogsapitest.Release.Application.UseCase;

import com.mhb.discogsapitest.Release.Application.UseCase.Exception.GetReleasesByBarcodeException;
import com.mhb.discogsapitest.Release.Domain.Release;
import com.mhb.discogsapitest.Release.Domain.ReleaseCollectionMotherObject;
import com.mhb.discogsapitest.Release.Domain.ReleaseRepository;
import com.mhb.discogsapitest.Release.Domain.ValueObject.BarCode;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

public class GetReleasesByBarCodeTest {
    @Test
    public void whenValidBarCodeThenReturnReleases() {
        // given
        String barCodeStr = "1234567890123";
        BarCode barCode = new BarCode(barCodeStr);

        ReleaseRepository releaseRepositoryMock = mock(ReleaseRepository.class);
        List<Release> expected = ReleaseCollectionMotherObject.createRandom(10);
        when(releaseRepositoryMock.byBarCode(barCode)).thenReturn(expected);

        GetReleasesByBarCode sut = new GetReleasesByBarCode(releaseRepositoryMock);

        // when
        List<Release> actual = sut.execute(barCodeStr);

        // then
        assert actual.equals(expected);
    }

    @Test
    public void whenInvalidBarCodeThenThrowException() {
        // given
        String barcode = "555patata";
        List<Release> expected = ReleaseCollectionMotherObject.createRandom(10);
        ReleaseRepository repositoryMock = mock(ReleaseRepository.class);
        verify(repositoryMock, never()).byBarCode(any(BarCode.class));

        GetReleasesByBarCode sut = new GetReleasesByBarCode(repositoryMock);

        // when / then
        assertThrows(GetReleasesByBarcodeException.class, () -> sut.execute(barcode));
    }
}
