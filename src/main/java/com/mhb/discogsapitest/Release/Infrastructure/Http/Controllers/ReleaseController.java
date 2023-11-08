package com.mhb.discogsapitest.Release.Infrastructure.Http.Controllers;

import com.mhb.discogsapitest.Release.Application.UseCase.GetReleaseById;
import com.mhb.discogsapitest.Release.Application.UseCase.GetReleases;
import com.mhb.discogsapitest.Release.Application.UseCase.GetReleasesByBarCode;
import com.mhb.discogsapitest.Release.Domain.Release;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
public class ReleaseController {
    @Getter
    private GetReleaseById getReleaseById;

    @Getter
    private GetReleases getReleases;

    @Getter
    private GetReleasesByBarCode getReleasesByBarCode;

    @GetMapping("/releases/{id}")
    public Release getReleaseById(@PathVariable int id) {
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

    @GetMapping("/healthcheck")
    public String healthCheck() {
        return "OK";
    }

}
