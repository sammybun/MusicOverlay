package com.sammybun.MusicOverlayPlugin;

import net.runelite.client.config.Config;
import net.runelite.client.config.ConfigGroup;
import net.runelite.client.config.ConfigItem;

@ConfigGroup("musicOverlay")
public interface MusicOverlayConfig  extends Config {
    @ConfigItem(
            keyName = "muteHide",
            name = "Hide Overlay on Mute",
            description = "If the music volume is muted, the overlay will be hidden.",
            position = 1
    )
    default boolean muteHide()
    {
        return false;
    }
}
