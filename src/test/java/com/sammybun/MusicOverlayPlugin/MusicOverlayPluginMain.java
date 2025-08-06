package com.sammybun.MusicOverlayPlugin;

import net.runelite.client.RuneLite;
import net.runelite.client.externalplugins.ExternalPluginManager;

public class MusicOverlayPluginMain
{
	public static void main(String[] args) throws Exception
	{
		ExternalPluginManager.loadBuiltin(MusicOverlayPlugin.class);
		RuneLite.main(args);
	}
}