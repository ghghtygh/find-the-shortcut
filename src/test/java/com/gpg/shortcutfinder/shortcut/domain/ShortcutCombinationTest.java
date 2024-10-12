package com.gpg.shortcutfinder.shortcut.domain;

import com.gpg.shortcutfinder.combination.domain.Key;
import com.gpg.shortcutfinder.combination.domain.KeyCombination;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@Slf4j
class ShortcutCombinationTest {

    @Test
    @DisplayName("유저 키 조합을 추가 할 수 있다")
    void createUserShortCutCombinationTest() {
        //given
        ShortcutCombination shortcutCombination = ShortcutCombination.builder()
                .id(1L)
                .name("복사")
                .description("복사")
                .osType(OsType.WINDOW)
                .defaultShortcutCombination(
                        DefaultShortcutCombination.builder()
                                .id(1L)
                                .keyCombination(
                                        KeyCombination.builder()
                                                .keyList(
                                                    List.of(
                                                        Key.builder().name("ctrl").build(),
                                                        Key.builder().name("c").build()
                                                    )
                                                )
                                                .build()
                                )
                                .build()
                )
                .build();

        KeyCombination keyCombination = KeyCombination.builder()
                .keyList(
                        List.of(
                            Key.builder().name("alt").build(),
                            Key.builder().name("c").build()
                        )
                )
                .build();

        //when
        ShortcutCombination result = shortcutCombination.updateUserShortcutCombination(keyCombination);

        //then
        assertThat(result.getId()).isEqualTo(1L);
        assertThat(result.getName()).isEqualTo("복사");
        assertThat(result.getDescription()).isEqualTo("복사");
        assertThat(result.getOsType()).isEqualTo(OsType.WINDOW);
        assertThat(result.getUserCustomCombination()).isNotNull();
        assertThat(result.getUserCustomCombination().getId()).isNull();
        assertThat(result.getUserCustomCombination().getKeyCombination()).isNotNull();
        assertThat(result.getUserCustomCombination().getKeyCombination().getKeyList())
                .extracting("name")
                .containsOnly("alt", "c");

    }

    @Test
    @DisplayName("유저 키 조합을 업데이트 할 수 있다")
    void updateUserShortCutCombinationTest() {
        //given
        ShortcutCombination shortcutCombination = ShortcutCombination.builder()
                .id(1L)
                .name("복사")
                .description("복사")
                .osType(OsType.MAC)
                .defaultShortcutCombination(
                        DefaultShortcutCombination.builder()
                                .id(1L)
                                .keyCombination(
                                        KeyCombination.builder()
                                                .keyList(
                                                        List.of(
                                                                Key.builder().name("ctrl").build(),
                                                                Key.builder().name("c").build()
                                                        )
                                                )
                                                .build()
                                )
                                .build())
                .userCustomCombination(UserShortcutCombination.builder()
                                .id(1L)
                                .keyCombination(
                                        KeyCombination.builder()
                                                .keyList(
                                                        List.of(
                                                                Key.builder().name("command").build(),
                                                                Key.builder().name("c").build()
                                                        )
                                                )
                                                .build()
                                )
                                .build()
                )
                .build();

        KeyCombination keyCombination = KeyCombination.builder()
                .keyList(
                        List.of(
                                Key.builder().name("option").build(),
                                Key.builder().name("c").build()
                        )
                )
                .build();

        //when
        ShortcutCombination result = shortcutCombination.updateUserShortcutCombination(keyCombination);

        //then
        assertThat(result.getId()).isEqualTo(1L);
        assertThat(result.getName()).isEqualTo("복사");
        assertThat(result.getDescription()).isEqualTo("복사");
        assertThat(result.getOsType()).isEqualTo(OsType.MAC);
        assertThat(result.getUserCustomCombination()).isNotNull();
        assertThat(result.getUserCustomCombination().getId()).isEqualTo(1L);
        assertThat(result.getUserCustomCombination().getKeyCombination()).isNotNull();
        assertThat(result.getUserCustomCombination().getKeyCombination().getKeyList())
                .extracting("name")
                .containsOnly("option", "c");

    }
}