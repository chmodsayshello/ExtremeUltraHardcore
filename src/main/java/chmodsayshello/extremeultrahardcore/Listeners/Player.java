package chmodsayshello.extremeultrahardcore.Listeners;

import io.papermc.paper.event.player.PlayerTradeEvent;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.*;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityShootBowEvent;
import org.bukkit.event.player.PlayerFishEvent;
import org.bukkit.event.player.PlayerInteractEntityEvent;
import org.bukkit.event.player.PlayerItemConsumeEvent;
import org.bukkit.event.player.PlayerToggleSprintEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import java.util.Random;

public class Player implements Listener {

    @EventHandler
    public void ontrade(PlayerTradeEvent event){
        org.bukkit.entity.Player p = event.getPlayer();
        p.sendMessage("Well, I don't know what to say, no trading, I guess...");
        event.setCancelled(true);
    }
    @EventHandler
    public void oneat(PlayerItemConsumeEvent event){
        int upper = 4;
        Random random = new Random();
        if(event.getItem().getType() == Material.MILK_BUCKET){
            org.bukkit.entity.Player p = event.getPlayer();
            p.sendMessage("Nah, it really is not healthy to drink 1000 liters of milk...");
            event.setCancelled(true);
        }

        if (random.nextInt(upper - 0) >1) {
            org.bukkit.entity.Player p = event.getPlayer();
            p.sendMessage("You always wolf down your food like that! Try it again slower and enjoy it.");
            event.setCancelled(true);
        }
    }

    @EventHandler
    public void onshot(EntityShootBowEvent event){
        if (event.getEntity() instanceof org.bukkit.entity.Player){
            int upper = 4;
            Random random = new Random();
            if (random.nextInt(upper - 0) >1) {
                org.bukkit.entity.Player p = ((org.bukkit.entity.Player) event.getEntity()).getPlayer();
                p.sendMessage("Oh man, you're always in such a hurry and you don't even draw your bow correctly, you have to shoot the arrow again.");
                event.setCancelled(true);
            }
        }
    }

    @EventHandler
    public void onsprint(PlayerToggleSprintEvent event) {
        int upper = 2;
        Random random = new Random();
        if (random.nextInt(upper - 0) ==1){
            org.bukkit.entity.Player p = event.getPlayer();
            p.sendMessage("Have you really forgot that you felt very ill this morning and your doctor said no sport?");
            p.addPotionEffect(new PotionEffect(PotionEffectType.HUNGER, 1800, 1));
            p.addPotionEffect(new PotionEffect(PotionEffectType.CONFUSION, 1800, 1));

        }
    }

    @EventHandler
    public void onfish(PlayerFishEvent event){
        org.bukkit.entity.Player p = event.getPlayer();
        Location ploc = p.getLocation();
        Location loc = event.getCaught().getLocation();
        LightningStrike strike = (LightningStrike) p.getWorld().spawnEntity(ploc, EntityType.LIGHTNING);
        p.sendMessage("He said 'You are more likely to be struck by lightning before you hit the jackpot in the lottery!', should I play the lottery now?");
        int upper = 4;
        Random random = new Random();
        if(random.nextInt(upper - 1) == 1){
            Ravager ravager = (Ravager) p.getWorld().spawnEntity(ploc, EntityType.RAVAGER);
            ElderGuardian elder = (ElderGuardian) p.getWorld().spawnEntity(ploc, EntityType.ELDER_GUARDIAN);
            ravager.setPassenger(elder);
            p.sendMessage("RUN!");
        }
    }

    @EventHandler
    public void onride(PlayerInteractEntityEvent event){
        Entity e = event.getRightClicked();
        org.bukkit.entity.Player p = event.getPlayer();
        Location loc = e.getLocation();
        if (e instanceof Horse || e instanceof Donkey || e instanceof Mule || e instanceof Llama){
            p.sendMessage("Oh no, that was a Trojan horse!");
            for(int i = 0; i < 10; ++i){
                Zombie zombie = (Zombie) e.getWorld().spawnEntity(loc, EntityType.ZOMBIE);
                Skeleton skeleton = (Skeleton) e.getWorld().spawnEntity(loc, EntityType.SKELETON);
                Illusioner illusioner = (Illusioner) e.getWorld().spawnEntity(loc, EntityType.ILLUSIONER);
                zombie.setInvulnerable(true);
                skeleton.setInvulnerable(true);
                illusioner.setInvulnerable(true);
                event.setCancelled(true);
            }
        }
    }
}
