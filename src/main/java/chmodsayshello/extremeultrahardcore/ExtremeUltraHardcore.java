//The only reason i have all the EventListeners in the main class is because everything the plugin does is controlled by them
package chmodsayshello.extremeultrahardcore;



import io.papermc.paper.event.player.PlayerTradeEvent;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.*;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.enchantment.EnchantItemEvent;
import org.bukkit.event.entity.CreatureSpawnEvent;
import org.bukkit.event.entity.EntityShootBowEvent;
import org.bukkit.event.entity.ProjectileHitEvent;
import org.bukkit.event.inventory.*;
import org.bukkit.event.player.PlayerBedEnterEvent;
import org.bukkit.event.player.PlayerItemConsumeEvent;
import org.bukkit.event.player.PlayerToggleSprintEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import java.util.Random;


public final class ExtremeUltraHardcore extends JavaPlugin implements Listener {

    public void onEnable() {
        this.getServer().getPluginManager().registerEvents(this, this);
        getLogger().info("Started challange");
        // Plugin startup logic

    }

    @EventHandler
    public void onBlockbreak (BlockBreakEvent e){
        int upper = 4;
        Random random = new Random();
        if (random.nextInt(upper - 0) ==1) {
            org.bukkit.entity.Player p = e.getPlayer();
            e.setCancelled(true);
            p.sendMessage("Looks like you were unlucky");
        }
        upper = 125;
        random = new Random();
        if (random.nextInt(upper - 0) ==1) {
            org.bukkit.entity.Player p = e.getPlayer();
            p.sendMessage("You are now digging since hours and slowy getting tired");
            p.addPotionEffect(new PotionEffect(PotionEffectType.SLOW_DIGGING, 1800, 1));
        }
    }

    @EventHandler
    public void onsleep(PlayerBedEnterEvent e) {
        org.bukkit.entity.Player p = e.getPlayer();
        p.sendMessage("No sleep tonight!");
        e.setCancelled(true); //Verhindert effektiv die Nutzung des Bettes
    }

    @EventHandler
    public void enchant(EnchantItemEvent e){
        Player p =e.getEnchanter();
        p.sendMessage("Enchanting is way too op and complicated for you!");
        e.setCancelled(true);
    }

    @EventHandler
    public void brew(BrewEvent e){
        e.setCancelled(true);
    }

    @EventHandler
    public void furnace(FurnaceBurnEvent e){
        e.setCancelled(true);
    }

    @EventHandler
    public void ontrade(PlayerTradeEvent e){
        Player p = e.getPlayer();
        p.sendMessage("Well, I don't know what to say, no trading, I guess...");
        e.setCancelled(true);
    }


    @EventHandler
    public void onspawn(CreatureSpawnEvent e){
        if (e.getEntity() instanceof Creeper){
            ((Creeper) e.getEntity()).setPowered(true);
        }
        else{
            if(e.getEntity() instanceof Zombie) {
                ItemStack Zombieboots = new ItemStack(Material.DIAMOND_BOOTS);
                ItemStack Zombieleggings = new ItemStack(Material.DIAMOND_LEGGINGS);
                ItemStack Zombiechestplate = new ItemStack(Material.DIAMOND_CHESTPLATE);
                ItemStack Zombiehelmet = new ItemStack(Material.DIAMOND_HELMET);
                ItemStack Zombiesword = new ItemStack(Material.DIAMOND_SWORD);
                Zombieboots.addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 4);
                Zombieleggings.addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 4);
                Zombiechestplate.addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 4);
                Zombiehelmet.addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 4);
                Zombiesword.addEnchantment(Enchantment.DAMAGE_ALL, 5);
                ((Zombie) e.getEntity()).getEquipment().setBoots(Zombieboots);
                ((Zombie) e.getEntity()).getEquipment().setLeggings(Zombieleggings);
                ((Zombie) e.getEntity()).getEquipment().setChestplate(Zombiechestplate);
                ((Zombie) e.getEntity()).getEquipment().setHelmet(Zombiehelmet);
                ((Zombie) e.getEntity()).getEquipment().setItemInMainHand(Zombiesword);
                ((Zombie) e.getEntity()).getEquipment().setBootsDropChance(0);
                ((Zombie) e.getEntity()).getEquipment().setLeggingsDropChance(0);
                ((Zombie) e.getEntity()).getEquipment().setChestplateDropChance(0);
                ((Zombie) e.getEntity()).getEquipment().setHelmetDropChance(0);
                ((Zombie) e.getEntity()).getEquipment().setItemInMainHandDropChance(0);
                if (e.getEntity().fromMobSpawner() ==true){
                    e.getEntity().getWorld().spawnEntity(e.getEntity().getLocation().add(0,1,0), EntityType.VEX);
                    e.getEntity().remove();

                }
            }
            else {
                if(e.getEntity() instanceof  Skeleton){
                    ItemStack Skeletonboots = new ItemStack(Material.DIAMOND_BOOTS);
                    ItemStack Skeletonleggings = new ItemStack(Material.DIAMOND_LEGGINGS);
                    ItemStack Skeletonchestplate = new ItemStack(Material.DIAMOND_CHESTPLATE);
                    ItemStack Skeletonhelmet = new ItemStack(Material.DIAMOND_HELMET);
                    ItemStack Skeletonbow = new ItemStack(Material.BOW);
                    Skeletonboots.addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 4);
                    Skeletonleggings.addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 4);
                    Skeletonchestplate.addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 4);
                    Skeletonhelmet.addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 4);
                    Skeletonbow.addEnchantment(Enchantment.ARROW_DAMAGE, 5);
                    ((Skeleton) e.getEntity()).getEquipment().setBoots(Skeletonboots);
                    ((Skeleton) e.getEntity()).getEquipment().setLeggings(Skeletonleggings);
                    ((Skeleton) e.getEntity()).getEquipment().setChestplate(Skeletonchestplate);
                    ((Skeleton) e.getEntity()).getEquipment().setHelmet(Skeletonhelmet);
                    ((Skeleton) e.getEntity()).getEquipment().setItemInMainHand(Skeletonbow);
                    ((Skeleton) e.getEntity()).getEquipment().setBootsDropChance(0);
                    ((Skeleton) e.getEntity()).getEquipment().setLeggingsDropChance(0);
                    ((Skeleton) e.getEntity()).getEquipment().setChestplateDropChance(0);
                    ((Skeleton) e.getEntity()).getEquipment().setHelmetDropChance(0);
                    ((Skeleton) e.getEntity()).getEquipment().setItemInMainHandDropChance(0);
                    if (e.getEntity().fromMobSpawner() ==true){
                        e.getEntity().getWorld().spawnEntity(e.getEntity().getLocation().add(0,1,0), EntityType.VEX);
                        e.getEntity().remove();
                    }
                }
                else{
                    if(e.getEntity() instanceof Enderman) {

                        e.getEntity().getWorld().spawnEntity(e.getLocation().add(0,1,0), EntityType.SHULKER);
                        e.getEntity().remove();
                    }
                    if(e.getEntity() instanceof  Piglin){
                        ItemStack Piglinboots = new ItemStack(Material.NETHERITE_BOOTS);
                        ItemStack Piglinleggings = new ItemStack(Material.NETHERITE_LEGGINGS);
                        ItemStack Piglinchestplate = new ItemStack(Material.NETHERITE_CHESTPLATE);
                        ItemStack Piglinhelmet = new ItemStack(Material.NETHERITE_CHESTPLATE);
                        ItemStack Piglinsaxe = new ItemStack(Material.IRON_AXE); //Mal ganz ohne Enchantment
                        Piglinboots.addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 4);
                        Piglinleggings.addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 4);
                        Piglinchestplate.addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 4);
                        Piglinhelmet.addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 4);
                        ((Piglin) e.getEntity()).getEquipment().setBoots(Piglinboots);
                        ((Piglin) e.getEntity()).getEquipment().setLeggings(Piglinleggings);
                        ((Piglin) e.getEntity()).getEquipment().setChestplate(Piglinchestplate);
                        ((Piglin) e.getEntity()).getEquipment().setHelmet(Piglinhelmet);
                        ((Piglin) e.getEntity()).getEquipment().setItemInMainHand(Piglinsaxe);
                        ((Piglin) e.getEntity()).getEquipment().setBootsDropChance(0);
                        ((Piglin) e.getEntity()).getEquipment().setLeggingsDropChance(0);
                        ((Piglin) e.getEntity()).getEquipment().setChestplateDropChance(0);
                        ((Piglin) e.getEntity()).getEquipment().setHelmetDropChance(0);
                        ((Piglin) e.getEntity()).getEquipment().setItemInMainHandDropChance(1);
                    }
                    else{
                        if(e.getEntity() instanceof WitherSkeleton){
                            ItemStack Witherskelsword = new ItemStack(Material.NETHERITE_SWORD);
                            Witherskelsword.addEnchantment(Enchantment.DAMAGE_ALL, 5);
                            ((WitherSkeleton) e.getEntity()).getEquipment().setItemInMainHand(Witherskelsword);
                            ((WitherSkeleton) e.getEntity()).getEquipment().setItemInMainHandDropChance(0);
                        }
                        else{
                            if(e.getEntity() instanceof Spider){
                                if (e.getEntity().fromMobSpawner() ==true){
                                    e.getEntity().getWorld().spawnEntity(e.getEntity().getLocation().add(0,1,0), EntityType.VEX);
                                    e.getEntity().remove();

                                }
                            }
                            else{
                                if(e.getEntity() instanceof CaveSpider){
                                    e.getEntity().getWorld().spawnEntity(e.getEntity().getLocation().add(0,1,0), EntityType.VEX);
                                    e.getEntity().remove();
                                }
                            }
                        }
                    }
                }
            }
        }
    }
    @EventHandler
    public void oneat(PlayerItemConsumeEvent e){
        int upper = 4;
        Random random = new Random();
        if (random.nextInt(upper - 0) >1) {
            org.bukkit.entity.Player p = e.getPlayer();
            p.sendMessage("You always wolf down your food like that! Try it again slower and enjoy it.");
            e.setCancelled(true);
        }
    }

    @EventHandler
    public void onshot(EntityShootBowEvent e){
        if (e.getEntity() instanceof org.bukkit.entity.Player){
            int upper = 4;
            Random random = new Random();
            if (random.nextInt(upper - 0) >1) {
                org.bukkit.entity.Player p = ((org.bukkit.entity.Player) e.getEntity()).getPlayer();
                p.sendMessage("Oh man, you're always in such a hurry and you don't even draw your bow correctly, you have to shoot the arrow again.");
                e.setCancelled(true);
            }
        }
    }

    @EventHandler
    public void onplace(BlockPlaceEvent e) {
        int upper = 2;
        Random random = new Random();
        if (random.nextInt(upper - 0) ==1) {
            org.bukkit.entity.Player p = e.getPlayer();
            p.sendMessage("CAUTION: Your block just melted somehow?!");
            Location loc= e.getBlock().getLocation();
            loc.getBlock().setType(Material.LAVA);
        }
    }

    @EventHandler
    public void onsprint(PlayerToggleSprintEvent e) {
        int upper = 2;
        Random random = new Random();
        if (random.nextInt(upper - 0) ==1){
            org.bukkit.entity.Player p = e.getPlayer();
            p.sendMessage("Have you really forgot that you felt very ill this morning and your doctor said no sport?");
            p.addPotionEffect(new PotionEffect(PotionEffectType.HUNGER, 1800, 1));
            p.addPotionEffect(new PotionEffect(PotionEffectType.CONFUSION, 1800, 1));

        }
    }
    
    @EventHandler
    public void oncrash(ProjectileHitEvent e) {
        Entity fireball = e.getEntity();
        if(fireball instanceof Fireball){
            Location loc = fireball.getLocation();
            fireball.getWorld().createExplosion(loc,100F);
            e.setCancelled(true);
        }
    }


    public void onDisable() {
        // Plugin shutdown logic
    }
}
