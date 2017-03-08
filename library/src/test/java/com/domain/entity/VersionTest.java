package com.domain.entity;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest("service.version=1.2.3")
public class VersionTest {

    @Autowired
    private Version version;

    @Test
    public void contextLoads() {
        Assert.assertNotNull(version.version());
    }

    @SpringBootApplication
    @Import(VersionConfiguration.class)
    static class TestConfiguration {
    }

}
