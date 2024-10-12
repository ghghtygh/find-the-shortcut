package com.gpg.shortcutfinder.combination.domain;

import lombok.Builder;
import lombok.Getter;

@Getter
public class Key {
    private final Long id;
    private final String name;
    private final String imageUrl;

    @Builder
    public Key(Long id, String name, String imageUrl) {
        this.id = id;
        this.name = name;
        this.imageUrl = imageUrl;
    }
}
