package com.sammybun.MusicOverlayPlugin;

import java.awt.Dimension;
import java.awt.Graphics2D;
import javax.inject.Inject;
import static net.runelite.api.MenuAction.RUNELITE_OVERLAY_CONFIG;
import static net.runelite.client.ui.overlay.OverlayManager.OPTION_CONFIGURE;
import net.runelite.api.Client;
import net.runelite.client.ui.overlay.OverlayPanel;
import net.runelite.client.ui.overlay.OverlayPosition;
import net.runelite.client.ui.overlay.components.TitleComponent;

class MusicPluginOverlay extends OverlayPanel
{
    private static final int MUSIC_TRACK_WIDGET_ID = 15663113;
    private final Client client;
    private final MusicOverlayConfig config;

    @Inject
    private MusicPluginOverlay(MusicOverlayPlugin plugin, MusicOverlayConfig config, Client client)
    {
        super(plugin);
        this.client = client;
        setPosition(OverlayPosition.DYNAMIC);
        setMovable(true);
        setResizable(false);
        setSnappable(true);
        this.config = config;
        addMenuEntry(RUNELITE_OVERLAY_CONFIG, OPTION_CONFIGURE, "Music Overlay");
    }

    @Override
    public Dimension render(Graphics2D graphics)
    {
        var musicWidget = client.getWidget(MUSIC_TRACK_WIDGET_ID);
        if(musicWidget == null) return null;
        final var currentTrackString = "Current Track : " + musicWidget.getText();
            if(client.getMusicVolume() == 0 && config.muteHide()) return null;
            panelComponent.getChildren().add((TitleComponent.builder())
                    .text(currentTrackString)
                    .build());
            panelComponent.setPreferredSize(new Dimension(
                    graphics.getFontMetrics().stringWidth(currentTrackString) + 10,
                    0));
            return super.render(graphics);
    }
}