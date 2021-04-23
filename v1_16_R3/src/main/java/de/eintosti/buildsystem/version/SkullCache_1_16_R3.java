package de.eintosti.buildsystem.version;

import org.bukkit.Material;
import org.bukkit.craftbukkit.v1_16_R3.inventory.CraftItemStack;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.SkullMeta;

import java.util.HashMap;
import java.util.Map;

/**
 * @author einTosti
 */
public class SkullCache_1_16_R3 implements SkullCache {
    private final Map<String, net.minecraft.server.v1_16_R3.ItemStack> skullCache;

    public SkullCache_1_16_R3() {
        this.skullCache = new HashMap<>();
    }

    @SuppressWarnings("deprecation")
    private ItemStack getPlayerSkull(String name) {
        ItemStack skull = new ItemStack(Material.PLAYER_HEAD, 1);
        SkullMeta skullMeta = (SkullMeta) skull.getItemMeta();

        skullMeta.setOwner(name);
        skull.setItemMeta(skullMeta);

        return skull;
    }

    @Override
    public void cacheSkull(Player player) {
        skullCache.put(player.getName(), CraftItemStack.asNMSCopy(getPlayerSkull(player.getName())));
    }

    @Override
    public ItemStack getCachedSkull(String name) {
        net.minecraft.server.v1_16_R3.ItemStack cachedSkull = this.skullCache.get(name);
        return cachedSkull != null ? CraftItemStack.asBukkitCopy(cachedSkull) : getPlayerSkull(name);
    }
}