package com.sammybun.MusicOverlayPlugin;

import javax.inject.Inject;
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