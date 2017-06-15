package com.rezzedup.skriptvotifierhook;

import ch.njol.skript.Skript;
import ch.njol.skript.SkriptAddon;
import ch.njol.skript.classes.ClassInfo;
import ch.njol.skript.classes.Parser;
import ch.njol.skript.expressions.base.EventValueExpression;
import ch.njol.skript.lang.ParseContext;
import ch.njol.skript.registrations.Classes;
import com.rezzedup.skriptvotifierhook.events.OnlinePlayerVoteEvent;
import com.rezzedup.skriptvotifierhook.events.VoteReceivedEvent;
import com.vexsoftware.votifier.model.Vote;
import com.vexsoftware.votifier.model.VotifierEvent;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.IOException;

public class SkriptVotifierHook extends JavaPlugin implements Listener
{
    @Override
    public void onEnable()
    {
        SkriptAddon addon = Skript.registerAddon(this);
    
        Classes.registerClass
        (
            new ClassInfo<>(Vote.class, "vote")
                .user("vote")
                .name("Vote")
                .description("A vote from votifier.")
                .since("1.0.0")
                .defaultExpression(new EventValueExpression<Vote>(Vote.class))
                .parser(new Parser<Vote>() 
                {
                    @Override
                    public Vote parse(String s, ParseContext context)
                    {
                        return null;
                    }
    
                    @Override
                    public boolean canParse(ParseContext context)
                    {
                        return false;
                    }
    
                    @Override
                    public String toString(Vote vote, int i)
                    {
                        return vote.toString();
                    }
    
                    @Override
                    public String toVariableNameString(Vote vote)
                    {
                        return toString(vote, 0);
                    }
    
                    @Override
                    public String getVariableNamePattern()
                    {
                        return ".+";
                    }
                })
        );
        
        try
        {
            addon.loadClasses("com.rezzedup.skriptvotifierhook", "events", "expressions");
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
        PluginManager manager = getServer().getPluginManager();
        Vote vote = event.getVote();
    
        manager.callEvent(new VoteReceivedEvent(vote));
        
        Player player = getServer().getPlayerExact(vote.getUsername());
        
        if (player != null)
        {
            manager.callEvent(new OnlinePlayerVoteEvent(player, vote));
        }
    }
}
