package de.eintosti.buildsystem.inventory;

import de.eintosti.buildsystem.BuildSystem;
import de.eintosti.buildsystem.manager.InventoryManager;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;

/**
 * @author einTosti
 */
public class BlocksInventory {
    private final BuildSystem plugin;
    private final InventoryManager inventoryManager;

    public BlocksInventory(BuildSystem plugin) {
        this.plugin = plugin;
        this.inventoryManager = plugin.getInventoryManager();
    }

    private Inventory getInventory(Player player) {
        Inventory inventory = Bukkit.createInventory(null, 45, plugin.getString("blocks_title"));
        fillGuiWithGlass(player, inventory);

        inventoryManager.addUrlSkull(inventory, 1, plugin.getString("blocks_full_oak_barch"), "http://textures.minecraft.net/texture/22e4bb979efefd2ddb3f8b1545e59cd360492e12671ec371efc1f88af21ab83");
        inventoryManager.addUrlSkull(inventory, 2, plugin.getString("blocks_full_spruce_barch"), "http://textures.minecraft.net/texture/966cbdef8efb914d43a213be66b5396f75e5c1b9124f76f67d7cd32525748");
        inventoryManager.addUrlSkull(inventory, 3, plugin.getString("blocks_full_birch_barch"), "http://textures.minecraft.net/texture/a221f813dacee0fef8c59f76894dbb26415478d9ddfc44c2e708a6d3b7549b");
        inventoryManager.addUrlSkull(inventory, 4, plugin.getString("blocks_full_jungle_barch"), "http://textures.minecraft.net/texture/1cefc19380683015e47c666e5926b15ee57ab33192f6a7e429244cdffcc262");
        inventoryManager.addUrlSkull(inventory, 5, plugin.getString("blocks_full_acacia_barch"), "http://textures.minecraft.net/texture/96a3bba2b7a2b4fa46945b1471777abe4599695545229e782259aed41d6");
        inventoryManager.addUrlSkull(inventory, 6, plugin.getString("blocks_full_dark_oak_barch"), "http://textures.minecraft.net/texture/cde9d4e4c343afdb3ed68038450fc6a67cd208b2efc99fb622c718d24aac");

        inventoryManager.addUrlSkull(inventory, 10, plugin.getString("blocks_red_mushroom"), "http://textures.minecraft.net/texture/732dbd6612e9d3f42947b5ca8785bfb334258f3ceb83ad69a5cdeebea4cd65");
        inventoryManager.addUrlSkull(inventory, 11, plugin.getString("blocks_brown_mushroom"), "http://textures.minecraft.net/texture/fa49eca0369d1e158e539d78149acb1572949b88ba921d9ee694fea4c726b3");
        inventoryManager.addUrlSkull(inventory, 12, plugin.getString("blocks_full_mushroom_stem"), "http://textures.minecraft.net/texture/f55fa642d5ebcba2c5246fe6499b1c4f6803c10f14f5299c8e59819d5dc");
        inventoryManager.addUrlSkull(inventory, 13, plugin.getString("blocks_mushroom_stem"), "http://textures.minecraft.net/texture/84d541275c7f924bcb9eb2dbbf4b866b7649c330a6a013b53d584fd4ddf186ca");
        inventoryManager.addUrlSkull(inventory, 14, plugin.getString("blocks_mushroom_block"), "http://textures.minecraft.net/texture/3fa39ccf4788d9179a8795e6b72382d49297b39217146eda68ae78384355b13");

        inventoryManager.addUrlSkull(inventory, 19, plugin.getString("blocks_smooth_stone"), "http://textures.minecraft.net/texture/8dd0cd158c2bb6618650e3954b2d29237f5b4c0ddc7d258e17380ab6979f071");
        inventoryManager.addUrlSkull(inventory, 20, plugin.getString("blocks_double_stone_slab"), "http://textures.minecraft.net/texture/151e70169ea00f04a9439221cf33770844159dd775fc8830e311fd9b5ccd2969");
        inventoryManager.addUrlSkull(inventory, 21, plugin.getString("blocks_smooth_sandstone"), "http://textures.minecraft.net/texture/38fffbb0b8fdec6f62b17c451ab214fb86e4e355b116be961a9ae93eb49a43");
        inventoryManager.addUrlSkull(inventory, 22, plugin.getString("blocks_smooth_red_sandstone"), "http://textures.minecraft.net/texture/a2da7aa1ae6cc9d6c36c18a460d2398162edc2207fdfc9e28a7bf84d7441b8a2");

        inventoryManager.addUrlSkull(inventory, 28, plugin.getString("blocks_powered_redstone_lamp"), "http://textures.minecraft.net/texture/7eb4b34519fe15847dbea7229179feeb6ea57712d165dcc8ff6b785bb58911b0");
        inventoryManager.addUrlSkull(inventory, 29, plugin.getString("blocks_burning_furnace"), "http://textures.minecraft.net/texture/d17b8b43f8c4b5cfeb919c9f8fe93f26ceb6d2b133c2ab1eb339bd6621fd309c");
        inventoryManager.addUrlSkull(inventory, 30, plugin.getString("blocks_command_block"), "http://textures.minecraft.net/texture/8514d225b262d847c7e557b474327dcef758c2c5882e41ee6d8c5e9cd3bc914");
        inventoryManager.addUrlSkull(inventory, 31, plugin.getString("blocks_barrier"), "http://textures.minecraft.net/texture/3ed1aba73f639f4bc42bd48196c715197be2712c3b962c97ebf9e9ed8efa025");

        inventoryManager.addUrlSkull(inventory, 37, plugin.getString("blocks_mob_spawner"), "http://textures.minecraft.net/texture/db6bd9727abb55d5415265789d4f2984781a343c68dcaf57f554a5e9aa1cd");
        inventoryManager.addUrlSkull(inventory, 38, plugin.getString("blocks_nether_portal"), "http://textures.minecraft.net/texture/b0bfc2577f6e26c6c6f7365c2c4076bccee653124989382ce93bca4fc9e39b");
        inventoryManager.addUrlSkull(inventory, 39, plugin.getString("blocks_end_portal"), "http://textures.minecraft.net/texture/7840b87d52271d2a755dedc82877e0ed3df67dcc42ea479ec146176b02779a5");
        inventoryManager.addUrlSkull(inventory, 40, plugin.getString("blocks_dragon_egg"), "http://textures.minecraft.net/texture/3c151fb54b21fe5769ffb4825b5bc92da73657f214380e5d0301e45b6c13f7d");

        return inventory;
    }

    public void openInventory(Player player) {
        player.openInventory(getInventory(player));
    }

    private void fillGuiWithGlass(Player player, Inventory inventory) {
        int[] glassSlots = {0, 8, 9, 17, 18, 26, 27, 35, 36, 44};
        for (int i : glassSlots) {
            inventoryManager.addGlassPane(plugin, player, inventory, i);
        }
    }
}
