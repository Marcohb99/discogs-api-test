package com.mhb.discogsapitest.Artist.Application.UseCase;

import com.mhb.discogsapitest.Artist.Domain.Artist;
import com.mhb.discogsapitest.Artist.Domain.ArtistRepository;
import com.mhb.discogsapitest.Artist.Domain.Exception.ArtistNotFound;
import com.mhb.discogsapitest.Shared.Domain.SequentialId;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
@Getter
public class GetArtistInfo {
    private final ArtistRepository repository;
    public Artist execute(Integer id) throws ArtistNotFound {
        SequentialId artistId = new SequentialId(id);
        return repository.byId(artistId);
    }
}
