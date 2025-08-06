package com.sammybun.MusicOverlayPlugin;

import javax.inject.Inject;

import com.google.inject.Provides;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;
import net.runelite.client.ui.overlay.OverlayManager;

@PluginDescriptor(
		name = "Music Track Overlay"
)
public class MusicOverlayPlugin extends Plugin
{
	@Inject
	private OverlayManager overlayManager;
	@Inject
	private MusicPluginOverlay overlay;

	@Inject
	private ConfigManager configManager;


	@Provides
	MusicOverlayConfig provideConfig(ConfigManager configManager)
	{
		return configManager.getConfig(MusicOverlayConfig.class);
	}
	@Override
	protected void startUp()
	{
		overlayManager.add(overlay); // Add :)
	}

	@Override
	protected void shutDown()
	{
		overlayManager.remove(overlay); // Remove :)
	}
}