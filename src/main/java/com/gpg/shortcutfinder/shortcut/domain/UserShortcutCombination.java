 package com.gpg.shortcutfinder.shortcut.domain;

import com.gpg.shortcutfinder.combination.domain.KeyCombination;
import lombok.Builder;
import lombok.Getter;

@Getter
public class UserShortcutCombination {
    private final Long id;
    private final KeyCombination keyCombination;

    @Builder
    public UserShortcutCombination(Long id, KeyCombination keyCombination) {
        this.id = id;
        this.keyCombination = keyCombination;
    }

    public UserShortcutCombination updateKeyCombination(KeyCombination keyCombination) {
        return UserShortcutCombination.builder()
                .id(id)
                .keyCombination(keyCombination)
                .build();
    }
}
