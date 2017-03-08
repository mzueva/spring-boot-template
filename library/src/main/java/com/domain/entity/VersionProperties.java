package com.domain.entity;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties("service")
public class VersionProperties {
    /**
     * A message for the service.
     */
    private String version;

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }
}
