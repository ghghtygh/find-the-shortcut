package com.gpg.shortcutfinder.shortcut.domain;

import com.gpg.shortcutfinder.application.domain.Application;
import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Getter
public class ApplicationShortcut {
    private final Application application;
    private final List<ShortcutCombination> shortcutCombinationList;

    @Builder
    public ApplicationShortcut(Application application, List<ShortcutCombination> shortcutCombinationList) {
        this.application = application;
        this.shortcutCombinationList = shortcutCombinationList;
    }
}
