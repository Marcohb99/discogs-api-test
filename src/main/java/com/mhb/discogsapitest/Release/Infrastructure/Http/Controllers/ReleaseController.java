package com.mhb.discogsapitest.Release.Infrastructure.Http.Controllers;

import com.mhb.discogsapitest.Release.Application.UseCase.GetArtistReleases;
import com.mhb.discogsapitest.Release.Application.UseCase.GetReleaseById;
import com.mhb.discogsapitest.Release.Application.UseCase.GetReleases;
import com.mhb.discogsapitest.Release.Application.UseCase.GetReleasesByBarCode;
import com.mhb.discogsapitest.Release.Domain.Release;
import com.mhb.discogsapitest.Album.Domain.AlbumType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@AllArgsConstructor
@Getter
public class ReleaseController {
    private GetReleaseById getReleaseById;

    private GetReleases getReleases;

    private GetReleasesByBarCode getReleasesByBarCode;

    private GetArtistReleases getArtistReleases;

    @GetMapping("/releases/{id}")
    public Release getReleaseById(@PathVariable Integer id) {
        return this.getReleaseById.execute(id);
    }

    @GetMapping("/releases")
    public List<Release> getReleases() {
        return getReleases.execute();
    }

    @GetMapping("/releases/scan/{barCode}")
    public List<Release> getReleasesByBarCode(@PathVariable String barCode) {
        return getReleasesByBarCode.execute(barCode);
    }

    @GetMapping("/artists/{id}/releases")
    public Map<AlbumType,List<Release>> getArtistReleases(@PathVariable Integer id) {
        return getArtistReleases.execute(id);
    }

    @GetMapping("/healthcheck")
    public String healthCheck() {
        return "OK";
    }

}
