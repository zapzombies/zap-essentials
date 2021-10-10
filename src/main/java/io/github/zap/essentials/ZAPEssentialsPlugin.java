package io.github.zap.essentials;

import io.github.zap.commons.ZapPlugin;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.TextComponent;
import net.kyori.adventure.text.event.ClickEvent;
import net.kyori.adventure.text.format.NamedTextColor;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.Plugin;
import org.jetbrains.annotations.NotNull;

/**
 * Plugin for general utilities for ZAP
 */
public class ZAPEssentialsPlugin extends ZapPlugin {

    @Override
    public void doEnable() {
        this.getCommand("serializestack").setExecutor((sender, command, label, args) -> {
            if (sender instanceof Player player) {
                ItemStack itemStack = player.getInventory().getItemInMainHand();
                FileConfiguration config = new YamlConfiguration();
                config.set("stack", itemStack);
                player.sendMessage(TextComponent.ofChildren(
                        Component.text("Click ", NamedTextColor.YELLOW),
                        Component.text("here", NamedTextColor.RED).clickEvent(
                                ClickEvent.copyToClipboard(config.saveToString())
                        ),
                        Component.text(" to copy!", NamedTextColor.YELLOW)
                ));
            }

            return true;
        });
        this.getCommand("lemmesee").setExecutor((sender, command, label, args) -> {
            if (args.length < 1 || !(sender instanceof Player player)) {
                return true;
            }

            Player show = Bukkit.getPlayer(args[0]);
            if (show == null) {
                return true;
            }

            for (Plugin plugin : this.getServer().getPluginManager().getPlugins()) {
                player.showPlayer(plugin, show);
            }

            return true;
        });
    }

    @Override
    public void doLoad() {

    }

    @Override
    public void doDisable() {

    }

}
