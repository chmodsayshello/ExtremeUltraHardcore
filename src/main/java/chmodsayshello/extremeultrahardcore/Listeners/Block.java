package chmodsayshello.extremeultrahardcore.Listeners;

import chmodsayshello.extremeultrahardcore.ExtremeUltraHardcore;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.entity.Wither;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.*;
import org.bukkit.event.enchantment.EnchantItemEvent;
import org.bukkit.event.entity.ItemSpawnEvent;
import org.bukkit.event.inventory.BrewEvent;
import org.bukkit.event.inventory.FurnaceBurnEvent;
import org.bukkit.event.inventory.PrepareAnvilEvent;
import org.bukkit.event.inventory.SmithItemEvent;
import org.bukkit.event.player.PlayerBedEnterEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.Random;

public class Block implements Listener {
    @EventHandler
    public void onBlockbreak (BlockBreakEvent event){
        if(event.getBlock().getType() == Material.WITHER_ROSE){
            Location loc = event.getBlock().getLocation();
            Wither wither = (Wither) loc.getWorld().spawnEntity(loc, EntityType.WITHER);
            event.setCancelled(true);
            Player p = event.getPlayer();
            p.sendMessage("<Wither> Stop breaking my rose!");
        }else{
            int upper = 4;
            Random random = new Random();
            if (random.nextInt(upper - 0) ==1) {
                org.bukkit.entity.Player p = event.getPlayer();
                event.setCancelled(true);
                p.sendMessage("Looks like you were unlucky");
            }
            upper = 125;
            random = new Random();
            if (random.nextInt(upper - 0) ==1) {
                org.bukkit.entity.Player p = event.getPlayer();
                p.sendMessage("You are now digging since hours and slowy getting tired");
                p.addPotionEffect(new PotionEffect(PotionEffectType.SLOW_DIGGING, 1800, 1));
            }
        }
    }

    @EventHandler
    public void onsleep(PlayerBedEnterEvent event) {
        Player p = event.getPlayer();
        p.sendMessage("No sleep tonight!");
        event.setCancelled(true); //Verhindert effektiv die Nutzung des Bettes
    }

    @EventHandler
    public void enchant(EnchantItemEvent event){
        Player p =event.getEnchanter();
        p.sendMessage("Enchanting is way too op and complicated for you!");
        event.setCancelled(true);
    }

    @EventHandler
    public void brew(BrewEvent event){
        event.setCancelled(true);
    }

    @EventHandler
    public void furnace(FurnaceBurnEvent event){
        event.setCancelled(true);
    }

    @EventHandler
    public void onplace(BlockPlaceEvent event) {
        int upper = 2;
        Random random = new Random();
        if (random.nextInt(upper - 0) ==1) {
            org.bukkit.entity.Player p = event.getPlayer();
            p.sendMessage("CAUTION: Your block just melted somehow?!");
            Location loc= event.getBlock().getLocation();
            loc.getBlock().setType(Material.LAVA);
        }
    }

    @EventHandler
    public void onanvil(PrepareAnvilEvent event){
        Location loc = event.getInventory().getLocation();
        loc.getBlock().setType(Material.AIR);
        loc.getWorld().playSound(loc, Sound.BLOCK_ANVIL_BREAK, 3.0F, 0.5F);
        loc.getWorld().createExplosion(loc, 100F);
    }

    @EventHandler
    public void onsmithing(SmithItemEvent event){
        Location loc = event.getInventory().getLocation();
        loc.getBlock().setType(Material.AIR);
        loc.getWorld().playSound(loc, Sound.BLOCK_WOOD_BREAK, 3.0f, 0.5f);
        loc.getWorld().createExplosion(loc, 100F);
        event.setCancelled(true);
    }

    @EventHandler
    public void containeruse(PlayerInteractEvent event){
        if(event.getAction() == Action.LEFT_CLICK_BLOCK || event.getAction() == Action.RIGHT_CLICK_BLOCK) {
            Location loc = event.getClickedBlock().getLocation();
            Player p = event.getPlayer();
            if (event.getClickedBlock().getType() == Material.CHEST || event.getClickedBlock().getType() == Material.TRAPPED_CHEST || event.getClickedBlock().getType() == Material.BARREL || event.getClickedBlock().getType() == Material.SHULKER_BOX || event.getClickedBlock().getType() == Material.ENDER_CHEST || event.getClickedBlock().getType() == Material.HOPPER || event.getClickedBlock().getType() == Material.DROPPER || event.getClickedBlock().getType() == Material.DISPENSER) {
                if (!loc.getWorld().getWorldFolder().getName().endsWith("end")) {
                    loc.getWorld().createExplosion(loc, 100F);
                    p.sendMessage("Looks like this was a suitcase bomb of massive proportions that had devastating consequences");
                }
            }

        }
    }


    //They are here because thw wither rose if being dropped by a block, but i might add a class item.java later
    @EventHandler
    public void ondrop(ItemSpawnEvent event){
        if(event.getEntity().getItemStack().equals((new ItemStack(Material.WITHER_ROSE, event.getEntity().getItemStack().getAmount())))){
            new BukkitRunnable(){
                @Override
                public void run(){
                    event.getEntity().remove();
                }
            }.runTaskLater(ExtremeUltraHardcore.getPlugin(ExtremeUltraHardcore.class), 15*20);
        }
    }

    @EventHandler
    public void ondispense(BlockDispenseEvent event){
        Location loc = event.getBlock().getLocation();
        loc.getWorld().createExplosion(loc, 100F);
    }
}
