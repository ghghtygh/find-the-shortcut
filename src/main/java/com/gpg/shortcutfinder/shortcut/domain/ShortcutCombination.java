package com.gpg.shortcutfinder.shortcut.domain;

import com.gpg.shortcutfinder.combination.domain.KeyCombination;
import lombok.Builder;
import lombok.Getter;

@Getter
public class ShortcutCombination {
    private final Long id;
    private final String name;
    private final String description;
    private final OsType osType;
    private final DefaultShortcutCombination defaultShortcutCombination;
    private final UserShortcutCombination userCustomCombination;

    @Builder
    public ShortcutCombination(Long id, String name, String description, OsType osType, DefaultShortcutCombination defaultShortcutCombination, UserShortcutCombination userCustomCombination) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.osType = osType;
        this.defaultShortcutCombination = defaultShortcutCombination;
        this.userCustomCombination = userCustomCombination;
    }

    public ShortcutCombination updateUserShortcutCombination(KeyCombination keyCombination) {

        UserShortcutCombination userShortcutCombination;

        if (this.userCustomCombination == null) {
            userShortcutCombination = UserShortcutCombination.builder()
                    .keyCombination(keyCombination)
                    .build();
        } else {
            userShortcutCombination = userCustomCombination.updateKeyCombination(keyCombination);
        }

        return ShortcutCombination.builder()
                .id(id)
                .name(name)
                .description(description)
                .osType(osType)
                .defaultShortcutCombination(defaultShortcutCombination)
                .userCustomCombination(userShortcutCombination)
                .build();

    }
}
