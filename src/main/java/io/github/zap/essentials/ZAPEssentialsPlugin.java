package io.github.zap.essentials;

import io.github.zap.commons.BaseZapPlugin;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.TextComponent;
import net.kyori.adventure.text.event.ClickEvent;
import net.kyori.adventure.text.format.NamedTextColor;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

/**
 * Plugin for general utilities for ZAP
 */
public class ZAPEssentialsPlugin extends BaseZapPlugin {

    @Override
    public void doEnable() {
        this.getCommand("serializestack").setExecutor((commandSender, command, s, strings) -> {
            if (commandSender instanceof Player player) {
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
    }

    @Override
    public void doLoad() {

    }

    @Override
    public void doDisable() {

    }

}
