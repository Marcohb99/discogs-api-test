package com.mhb.discogsapitest.Release.Application.UseCase;

import com.mhb.discogsapitest.Release.Domain.Release;
import com.mhb.discogsapitest.Release.Domain.ReleaseRepository;
import com.mhb.discogsapitest.Album.Domain.AlbumType;
import com.mhb.discogsapitest.Shared.Domain.SequentialId;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@AllArgsConstructor
@Getter
public class GetArtistReleases {
    private final ReleaseRepository repository;

    public Map<AlbumType,List<Release>> execute(Integer id) {
        SequentialId artistId = new SequentialId(id);
        List<Release> releases = repository.byArtistId(artistId);
        return this.formatResponse(releases);
    }

    private Map<AlbumType, List<Release>> formatResponse(List<Release> releases) {
        Map<AlbumType, List<Release>> releasesByType = new HashMap<>();
        for (Release release : releases) {
            AlbumType albumType = release.getAlbum().getAlbumType();
            if (!releasesByType.containsKey(albumType)) {
                List<Release> releasesList = new ArrayList<>();
                releasesList.add(release);
                releasesByType.put(albumType, releasesList);
            } else {
                releasesByType.get(albumType).add(release);
            }
        }
        return releasesByType;
    }
}
