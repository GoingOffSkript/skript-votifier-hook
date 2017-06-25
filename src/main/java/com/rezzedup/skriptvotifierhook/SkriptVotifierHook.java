package com.rezzedup.skriptvotifierhook;

import ch.njol.skript.Skript;
import ch.njol.skript.SkriptAddon;
import com.rezzedup.skriptvotifierhook.events.OnlinePlayerVoteEvent;
import com.vexsoftware.votifier.model.Vote;
import com.vexsoftware.votifier.model.VotifierEvent;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.IOException;

public class SkriptVotifierHook extends JavaPlugin implements Listener
{
    @Override
    public void onEnable()
    {
        try
        {
            Skript.registerAddon(this).loadClasses
            (
                "com.rezzedup.skriptvotifierhook", "types", "events", "expressions"
            );
        }
        catch (IOException io)
        {
            io.printStackTrace();
        }
        
        getServer().getPluginManager().registerEvents(this, this);
    }
    
    @EventHandler
    public void on(VotifierEvent event)
    {
        Vote vote = event.getVote();
        Player player = getServer().getPlayerExact(vote.getUsername());
        
        if (player != null)
        {
            getServer().getPluginManager().callEvent(new OnlinePlayerVoteEvent(player, vote));
        }
    }
}
