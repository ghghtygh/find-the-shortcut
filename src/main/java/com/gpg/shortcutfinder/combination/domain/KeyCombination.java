package com.gpg.shortcutfinder.combination.domain;

import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Getter
public class KeyCombination {
    private final Long id;
    private final List<Key> keyList;

    @Builder
    public KeyCombination(Long id, List<Key> keyList) {
        this.id = id;
        this.keyList = keyList;
    }
}
