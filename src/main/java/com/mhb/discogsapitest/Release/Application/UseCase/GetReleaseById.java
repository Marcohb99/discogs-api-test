package com.mhb.discogsapitest.Release.Application.UseCase;

import com.mhb.discogsapitest.Release.Domain.Release;
import com.mhb.discogsapitest.Release.Domain.ReleaseRepository;
import org.springframework.stereotype.Service;

@Service
public class GetReleaseById {
    private final ReleaseRepository repository;

    public GetReleaseById(ReleaseRepository repository) {
        this.repository = repository;
    }

    public Release execute(int id) {
        return repository.byId(id);
    }
}
