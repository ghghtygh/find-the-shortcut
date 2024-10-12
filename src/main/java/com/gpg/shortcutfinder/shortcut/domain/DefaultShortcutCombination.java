package com.gpg.shortcutfinder.shortcut.domain;

import com.gpg.shortcutfinder.combination.domain.KeyCombination;
import lombok.Builder;
import lombok.Getter;

@Getter
public class DefaultShortcutCombination {
    private final Long id;
    private final KeyCombination keyCombination;

    @Builder
    public DefaultShortcutCombination(Long id, KeyCombination keyCombination) {
        this.id = id;
        this.keyCombination = keyCombination;
    }
}
