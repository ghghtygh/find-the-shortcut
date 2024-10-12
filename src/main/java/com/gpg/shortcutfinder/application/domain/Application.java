package com.gpg.shortcutfinder.application.domain;

import lombok.Builder;
import lombok.Getter;

@Getter
public class Application {
    private final Long id;
    private final String name;
    private final String logoUrl;

    @Builder
    public Application(Long id, String name, String logoUrl) {
        this.id = id;
        this.name = name;
        this.logoUrl = logoUrl;
    }

}
