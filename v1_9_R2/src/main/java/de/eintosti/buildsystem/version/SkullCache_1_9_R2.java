package de.eintosti.buildsystem.version;

import org.bukkit.Material;
import org.bukkit.craftbukkit.v1_9_R2.inventory.CraftItemStack;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.SkullMeta;

import java.util.HashMap;
import java.util.Map;

/**
 * @author einTosti
 */
public class SkullCache_1_9_R2 implements SkullCache {
    private final Map<String, net.minecraft.server.v1_9_R2.ItemStack> skullCache;

    public SkullCache_1_9_R2() {
        this.skullCache = new HashMap<>();
    }

    private ItemStack getPlayerSkull(String name) {
        ItemStack skull = new ItemStack(Material.SKULL_ITEM, 1, (short) 3);
        SkullMeta skullMeta = (SkullMeta) skull.getItemMeta();

        skullMeta.setOwner(name);
        skull.setItemMeta(skullMeta);

        return skull;
    }

    @Override
    public void cacheSkull(String name) {
        skullCache.put(name, CraftItemStack.asNMSCopy(getPlayerSkull(name)));
    }

    @Override
    public ItemStack getCachedSkull(String name) {
        net.minecraft.server.v1_9_R2.ItemStack cachedSkull = this.skullCache.get(name);

        if (cachedSkull != null) {
            return CraftItemStack.asBukkitCopy(cachedSkull);
        } else {
            ItemStack skull = getPlayerSkull(name);
            skullCache.put(name, CraftItemStack.asNMSCopy(skull));
            return skull;
        }
    }
}
