package chmodsayshello.extremeultrahardcore.Listeners;


import io.papermc.paper.event.entity.EntityMoveEvent;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.attribute.Attribute;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.*;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.CreatureSpawnEvent;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.event.entity.ProjectileHitEvent;
import org.bukkit.inventory.ItemStack;


public class Mob implements Listener {
    @EventHandler
    public void onspawn(CreatureSpawnEvent event){
        if (event.getEntity() instanceof Creeper){
            ((Creeper) event.getEntity()).setPowered(true);
            ((Creeper) event.getEntity()).setExplosionRadius(50);
            event.getEntity().setInvulnerable(true);
            event.getEntity().setCustomName("Boom!");
        }
        else{
            if(event.getEntity() instanceof Zombie) {
                ItemStack Zombieboots = new ItemStack(Material.DIAMOND_BOOTS);
                ItemStack Zombieleggings = new ItemStack(Material.DIAMOND_LEGGINGS);
                ItemStack Zombiechestplate = new ItemStack(Material.DIAMOND_CHESTPLATE);
                ItemStack Zombiehelmet = new ItemStack(Material.DIAMOND_HELMET);
                ItemStack Zombiesword = new ItemStack(Material.DIAMOND_SWORD);
                ItemStack Zombietotem = new ItemStack(Material.TOTEM_OF_UNDYING, 64);
                Zombieboots.addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 4);
                Zombieleggings.addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 4);
                Zombiechestplate.addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 4);
                Zombiehelmet.addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 4);
                Zombiesword.addEnchantment(Enchantment.DAMAGE_ALL, 5);
                ((Zombie) event.getEntity()).getEquipment().setBoots(Zombieboots);
                ((Zombie) event.getEntity()).getEquipment().setLeggings(Zombieleggings);
                ((Zombie) event.getEntity()).getEquipment().setChestplate(Zombiechestplate);
                ((Zombie) event.getEntity()).getEquipment().setHelmet(Zombiehelmet);
                ((Zombie) event.getEntity()).getEquipment().setItemInMainHand(Zombiesword);
                ((Zombie) event.getEntity()).getEquipment().setItemInOffHand(Zombietotem);
                ((Zombie) event.getEntity()).getEquipment().setBootsDropChance(0);
                ((Zombie) event.getEntity()).getEquipment().setLeggingsDropChance(0);
                ((Zombie) event.getEntity()).getEquipment().setChestplateDropChance(0);
                ((Zombie) event.getEntity()).getEquipment().setHelmetDropChance(0);
                ((Zombie) event.getEntity()).getEquipment().setItemInMainHandDropChance(0);
                if (event.getEntity().fromMobSpawner() ==true){
                    event.getEntity().getWorld().spawnEntity(event.getEntity().getLocation().add(0,1,0), EntityType.VEX);
                    event.getEntity().remove();

                }
            }
            else {
                if(event.getEntity() instanceof Skeleton){
                    ItemStack Skeletonboots = new ItemStack(Material.DIAMOND_BOOTS);
                    ItemStack Skeletonleggings = new ItemStack(Material.DIAMOND_LEGGINGS);
                    ItemStack Skeletonchestplate = new ItemStack(Material.DIAMOND_CHESTPLATE);
                    ItemStack Skeletonhelmet = new ItemStack(Material.DIAMOND_HELMET);
                    ItemStack Skeletonbow = new ItemStack(Material.BOW);
                    ItemStack Skeletontotem = new ItemStack(Material.TOTEM_OF_UNDYING, 64);
                    Skeletonboots.addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 4);
                    Skeletonleggings.addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 4);
                    Skeletonchestplate.addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 4);
                    Skeletonhelmet.addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 4);
                    Skeletonbow.addEnchantment(Enchantment.ARROW_DAMAGE, 5);
                    ((Skeleton) event.getEntity()).getEquipment().setBoots(Skeletonboots);
                    ((Skeleton) event.getEntity()).getEquipment().setLeggings(Skeletonleggings);
                    ((Skeleton) event.getEntity()).getEquipment().setChestplate(Skeletonchestplate);
                    ((Skeleton) event.getEntity()).getEquipment().setHelmet(Skeletonhelmet);
                    ((Skeleton) event.getEntity()).getEquipment().setItemInMainHand(Skeletonbow);
                    ((Skeleton) event.getEntity()).getEquipment().setItemInOffHand(Skeletontotem);
                    ((Skeleton) event.getEntity()).getEquipment().setBootsDropChance(0);
                    ((Skeleton) event.getEntity()).getEquipment().setLeggingsDropChance(0);
                    ((Skeleton) event.getEntity()).getEquipment().setChestplateDropChance(0);
                    ((Skeleton) event.getEntity()).getEquipment().setHelmetDropChance(0);
                    ((Skeleton) event.getEntity()).getEquipment().setItemInMainHandDropChance(0);
                    if (event.getEntity().fromMobSpawner() ==true){
                        event.getEntity().getWorld().spawnEntity(event.getEntity().getLocation().add(0,1,0), EntityType.VEX);
                        event.getEntity().remove();
                    }
                }
                else{
                    if(event.getEntity() instanceof Enderman) {

                        event.getEntity().getWorld().spawnEntity(event.getLocation().add(0,1,0), EntityType.SHULKER);
                        event.getEntity().remove();
                    }
                    if(event.getEntity() instanceof  Piglin){
                        ItemStack Piglinboots = new ItemStack(Material.NETHERITE_BOOTS);
                        ItemStack Piglinleggings = new ItemStack(Material.NETHERITE_LEGGINGS);
                        ItemStack Piglinchestplate = new ItemStack(Material.NETHERITE_CHESTPLATE);
                        ItemStack Piglinhelmet = new ItemStack(Material.NETHERITE_CHESTPLATE);
                        ItemStack Piglinsaxe = new ItemStack(Material.IRON_AXE); //Mal ganz ohne Enchantment
                        Piglinboots.addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 4);
                        Piglinleggings.addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 4);
                        Piglinchestplate.addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 4);
                        Piglinhelmet.addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 4);
                        ((Piglin) event.getEntity()).getEquipment().setBoots(Piglinboots);
                        ((Piglin) event.getEntity()).getEquipment().setLeggings(Piglinleggings);
                        ((Piglin) event.getEntity()).getEquipment().setChestplate(Piglinchestplate);
                        ((Piglin) event.getEntity()).getEquipment().setHelmet(Piglinhelmet);
                        ((Piglin) event.getEntity()).getEquipment().setItemInMainHand(Piglinsaxe);
                        ((Piglin) event.getEntity()).getEquipment().setBootsDropChance(0);
                        ((Piglin) event.getEntity()).getEquipment().setLeggingsDropChance(0);
                        ((Piglin) event.getEntity()).getEquipment().setChestplateDropChance(0);
                        ((Piglin) event.getEntity()).getEquipment().setHelmetDropChance(0);
                        ((Piglin) event.getEntity()).getEquipment().setItemInMainHandDropChance(1);
                    }
                    else{
                        if(event.getEntity() instanceof WitherSkeleton){
                            ItemStack Witherskelsword = new ItemStack(Material.NETHERITE_SWORD);
                            ItemStack Witherskeltotem = new ItemStack(Material.TOTEM_OF_UNDYING, 64);
                            Witherskelsword.addEnchantment(Enchantment.DAMAGE_ALL, 5);
                            ((WitherSkeleton) event.getEntity()).getEquipment().setItemInMainHand(Witherskelsword);
                            ((WitherSkeleton) event.getEntity()).getEquipment().setItemInOffHand(Witherskeltotem);
                            ((WitherSkeleton) event.getEntity()).getEquipment().setItemInMainHandDropChance(0);
                        }
                        else{
                            if(event.getEntity() instanceof Spider){
                                if (event.getEntity().fromMobSpawner() ==true){
                                    event.getEntity().getWorld().spawnEntity(event.getEntity().getLocation().add(0,1,0), EntityType.VEX);
                                    event.getEntity().remove();
                                }
                                else{
                                    event.getEntity().getAttribute(Attribute.GENERIC_MOVEMENT_SPEED).setBaseValue(2.0D);
                                }
                            }
                            else{
                                if(event.getEntity() instanceof CaveSpider){
                                    event.getEntity().getWorld().spawnEntity(event.getEntity().getLocation().add(0,1,0), EntityType.VEX);
                                    event.getEntity().remove();
                                }
                                else{
                                    if(event.getEntity() instanceof  Phantom){
                                        Location loc = event.getLocation();
                                        Creeper creep = (Creeper) loc.getWorld().spawnEntity(loc, EntityType.CREEPER);
                                        event.getEntity().setPassenger(creep);
                                    }
                                    else{
                                        if(event.getEntity() instanceof Vex){
                                            Location loc = event.getLocation();
                                            Creeper creep = (Creeper) loc.getWorld().spawnEntity(loc, EntityType.CREEPER);
                                            event.getEntity().setPassenger(creep);
                                        }
                                        else{
                                            if(event.getEntity() instanceof Pillager){
                                                Location loc = event.getLocation();
                                                Ravager ravager = (Ravager) loc.getWorld().spawnEntity(loc, EntityType.RAVAGER);
                                                ravager.setPassenger(event.getEntity());
                                                Evoker evoker = (Evoker) loc.getWorld().spawnEntity(loc, EntityType.EVOKER);
                                                event.getEntity().setPassenger(evoker);

                                                ItemStack totem = new ItemStack(Material.TOTEM_OF_UNDYING, 64);
                                                evoker.getEquipment().setItemInOffHand(totem);
                                                event.getEntity().getEquipment().setItemInOffHand(totem);

                                                event.getEntity().setInvulnerable(true);
                                                ravager.setInvulnerable(true);
                                                evoker.setInvulnerable(true);
                                            }
                                            else{
                                                if(event.getEntity() instanceof Vindicator){
                                                    Location loc = event.getLocation();
                                                    Ravager ravager = (Ravager) loc.getWorld().spawnEntity(loc, EntityType.RAVAGER);
                                                    ravager.setPassenger(event.getEntity());
                                                    Evoker evoker = (Evoker) loc.getWorld().spawnEntity(loc, EntityType.EVOKER);
                                                    event.getEntity().setPassenger(evoker);

                                                    ItemStack totem = new ItemStack(Material.TOTEM_OF_UNDYING, 64);
                                                    evoker.getEquipment().setItemInOffHand(totem);
                                                    event.getEntity().getEquipment().setItemInOffHand(totem);

                                                    event.getEntity().setInvulnerable(true);
                                                    evoker.setInvulnerable(true);
                                                    ravager.setInvulnerable(true);
                                                }
                                                else{
                                                    if(event.getEntity() instanceof Evoker){
                                                        Location loc = event.getLocation();
                                                        Ravager ravager = (Ravager) loc.getWorld().spawnEntity(loc, EntityType.RAVAGER);
                                                        ravager.setPassenger(event.getEntity());
                                                        ravager.setInvulnerable(true);
                                                        event.getEntity().setInvulnerable(true);
                                                        if(event.getSpawnReason().equals(CreatureSpawnEvent.SpawnReason.RAID)){
                                                            Evoker evoker = (Evoker) loc.getWorld().spawnEntity(loc, EntityType.EVOKER);
                                                            event.getEntity().setPassenger(evoker);

                                                            ItemStack totem = new ItemStack(Material.TOTEM_OF_UNDYING, 64);
                                                            evoker.getEquipment().setItemInOffHand(totem);
                                                            event.getEntity().getEquipment().setItemInOffHand(totem);

                                                            evoker.setInvulnerable(true);
                                                        }
                                                    }
                                                    else{
                                                        if(event.getEntity() instanceof Ravager){
                                                            if(event.getSpawnReason().equals(CreatureSpawnEvent.SpawnReason.RAID)){
                                                                Location loc = event.getLocation();
                                                                Ravager ravager = (Ravager) loc.getWorld().spawnEntity(loc, EntityType.RAVAGER);
                                                                ravager.setPassenger(event.getEntity());
                                                                ravager.setInvulnerable(true);
                                                                event.getEntity().setInvulnerable(true);
                                                            }
                                                        }
                                                        else{
                                                            if(event.getEntity() instanceof Witch){
                                                                ItemStack totem = new ItemStack(Material.TOTEM_OF_UNDYING, 64);
                                                                if(event.getSpawnReason().equals(CreatureSpawnEvent.SpawnReason.RAID)){
                                                                    Location loc = event.getLocation();
                                                                    Ravager ravager = (Ravager) loc.getWorld().spawnEntity(loc, EntityType.RAVAGER);
                                                                    ravager.setPassenger(event.getEntity());
                                                                    Evoker evoker = (Evoker) loc.getWorld().spawnEntity(loc, EntityType.EVOKER);
                                                                    event.getEntity().setPassenger(evoker);
                                                                    evoker.getEquipment().setItemInOffHand(totem);
                                                                    event.getEntity().setInvulnerable(true);
                                                                    evoker.setInvulnerable(true);
                                                                    ravager.setInvulnerable(true);
                                                                }
                                                                event.getEntity().getEquipment().setItemInOffHand(totem);
                                                            }
                                                            else{
                                                                if(event.getEntity() instanceof  Cat){
                                                                    Cat cat = (Cat) event.getEntity();
                                                                    cat.setCatType(Cat.Type.BLACK);
                                                                    cat.setCustomName("Katzenfisch07");
                                                                    Location loc = event.getLocation();
                                                                    Fish fish = (Fish) loc.getWorld().spawnEntity(loc, EntityType.SALMON);
                                                                    fish.setInvulnerable(true);
                                                                    cat.setPassenger(fish);
                                                                }
                                                                else{
                                                                    if(event.getEntity() instanceof Wolf){
                                                                        Wolf wolf = (Wolf) event.getEntity();
                                                                        Location loc = event.getLocation();
                                                                        TNTPrimed tnt = (TNTPrimed) loc.getWorld().spawnEntity(loc, EntityType.PRIMED_TNT);
                                                                        tnt.setFuseTicks(20*20); //20 seconds, times 20 because one second is 20 ticks
                                                                        wolf.setPassenger(tnt);
                                                                    }
                                                                    else{
                                                                        if(event.getEntity() instanceof Sheep || event.getEntity() instanceof Cow || event.getEntity() instanceof Pig || event.getEntity() instanceof Rabbit){
                                                                            Location loc = event.getLocation();
                                                                            event.getEntity().remove();
                                                                            Wolf wolf = (Wolf) loc.getWorld().spawnEntity(loc, EntityType.WOLF);
                                                                        }
                                                                    }
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    @EventHandler
    public void onmove(EntityMoveEvent event){
        if (event.getEntity() instanceof Phantom){
            Location loc = event.getEntity().getLocation();
            TNTPrimed tnt = (TNTPrimed) loc.getWorld().spawnEntity(loc, EntityType.PRIMED_TNT);
            tnt.setFuseTicks(5*20);
        }

        if(event.getEntity() instanceof  Cat){
            Cat cat = (Cat) event.getEntity();
            if(!(cat.getCatType() == Cat.Type.BLACK)){
                cat.setCatType(Cat.Type.BLACK);
                cat.setCustomName("Katzenfisch07");
                Location loc = event.getEntity().getLocation();
                Fish fish = (Fish) loc.getWorld().spawnEntity(loc, EntityType.SALMON);
                fish.setInvulnerable(true);
                cat.setPassenger(fish);
            }
        }
        else {
            if (event.getEntity() instanceof Wolf) {
                Wolf wolf = (Wolf) event.getEntity();
                if(wolf.getPassenger() == null){
                    Location loc = event.getEntity().getLocation();
                    TNTPrimed tnt = (TNTPrimed) loc.getWorld().spawnEntity(loc, EntityType.PRIMED_TNT);
                    tnt.setFuseTicks(20 * 20); //20 seconds, times 20 because one second is 20 ticks
                    wolf.setPassenger(tnt);
                }
            } else {
                if (event.getEntity() instanceof Sheep || event.getEntity() instanceof Cow || event.getEntity() instanceof Pig || event.getEntity() instanceof Rabbit) {
                    Location loc = event.getEntity().getLocation();
                    event.getEntity().remove();
                    Wolf wolf = (Wolf) loc.getWorld().spawnEntity(loc, EntityType.WOLF);
                }
            }
        }
    }



    @EventHandler
    public void oncrash(ProjectileHitEvent event) {
        Entity fireball = event.getEntity();
        if(fireball instanceof Fireball){
            Location loc = fireball.getLocation();
            fireball.getWorld().createExplosion(loc,100F);
            event.setCancelled(true);
        }
    }

    @EventHandler
    public void death(EntityDeathEvent event){
        if(event.getEntity() instanceof Creeper){
            Creeper deadcreep = (Creeper) event.getEntity();
            Location loc = deadcreep.getLocation();
            deadcreep.getWorld().createExplosion(loc, 100F);
        }
    }
}
