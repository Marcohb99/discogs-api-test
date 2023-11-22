package com.mhb.discogsapitest.Artist.Infrastructure.Http.Controllers;

import com.mhb.discogsapitest.Artist.Application.UseCase.GetArtistInfo;
import com.mhb.discogsapitest.Artist.Domain.Artist;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
public class ArtistController {

    private GetArtistInfo getArtistInfo;

    @GetMapping("/artists/{id}")
    public Artist getArtistReleases(@PathVariable Integer id) {
        return getArtistInfo.execute(id);
    }
}
