package com.domain.entity;

import org.springframework.stereotype.Component;

@Component
public class Version {

    private final String version;
    private String name;

    public Version() {
        this.version = "";
    }

    public Version(String version) {
        this.version = version;
    }

    public String version() {
        return this.version;
    }

    public String getName() {
        return name;
    }

    public String getVersion() {
        return version;
    }

    public void setName(String name) {
        this.name = name;
    }
}
