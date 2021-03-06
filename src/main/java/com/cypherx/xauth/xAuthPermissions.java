package com.cypherx.xauth;

import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;

import com.nijiko.permissions.PermissionHandler;
import com.nijikokun.bukkit.Permissions.Permissions;

public class xAuthPermissions {
	private static PermissionHandler permissionHandler;

	public static void setup(xAuth plugin) {
		Plugin permissionsPlugin = plugin.getServer().getPluginManager().getPlugin("Permissions");

		if (permissionHandler == null) {
			if (permissionsPlugin != null) {
				permissionHandler = ((Permissions) permissionsPlugin).getHandler();
				xAuthLog.info("'Permission' support enabled");
			} else
				xAuthLog.warning("Permission system not detected, defaulting to OP");
		}
	}

	public static boolean has(Player player, String permission) {
		if (permissionHandler == null)
			return player.isOp();

		return permissionHandler.has(player, permission);
	}
}