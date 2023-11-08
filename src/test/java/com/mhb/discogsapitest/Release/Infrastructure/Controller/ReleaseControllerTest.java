package com.mhb.discogsapitest.Release.Infrastructure.Controller;

import static org.assertj.core.api.Assertions.assertThat;

import com.mhb.discogsapitest.Release.Infrastructure.Http.Controllers.ReleaseController;
import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SmokeTest {

    @Autowired
    private ReleaseController controller;

    @Test
    void contextLoads() throws Exception {
        assertThat(controller).isNotNull();
    }
}
