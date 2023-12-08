package com.mhb.discogsapitest;

import org.junit.platform.suite.api.SelectPackages;
import org.junit.platform.suite.api.Suite;

@Suite
@SelectPackages(
        {
                "com.mhb.discogsapitest.Artist.Domain",
                "com.mhb.discogsapitest.Artist.Application",
                "com.mhb.discogsapitest.Release.Domain",
                "com.mhb.discogsapitest.Release.Application",
                "com.mhb.discogsapitest.Shared.Domain"
        }
)
public class UnitTestSuite {
}
