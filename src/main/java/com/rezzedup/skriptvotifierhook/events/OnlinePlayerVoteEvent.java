package com.rezzedup.skriptvotifierhook.events;

import ch.njol.skript.Skript;
import ch.njol.skript.lang.util.SimpleEvent;
import ch.njol.skript.registrations.EventValues;
import com.rezzedup.skriptvotifierhook.GoGetter;
import com.vexsoftware.votifier.model.Vote;
import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

public class OnlinePlayerVoteEvent extends Event
{
    private static final HandlerList HANDLERS = new HandlerList();
    
    public static final String[] PATTERNS = new String[]
    {
        "[online] [player] vote"
    };
    
    static 
    {
        Skript.registerEvent("On Vote", SimpleEvent.class, OnlinePlayerVoteEvent.class, PATTERNS);
    
        EventValues.registerEventValue
        (
            OnlinePlayerVoteEvent.class, Player.class, new GoGetter<>(OnlinePlayerVoteEvent::getPlayer), 0
        );
        
        EventValues.registerEventValue
        (
            OnlinePlayerVoteEvent.class, Vote.class, new GoGetter<>(OnlinePlayerVoteEvent::getVote), 0
        );
    }
    
    private final Player player;
    private final Vote vote;
    
    public OnlinePlayerVoteEvent(Player player, Vote vote)
    {
        this.player = player;
        this.vote = vote;
    }
    
    public Player getPlayer()
    {
        return player;
    }
    
    public Vote getVote()
    {
        return vote;
    }
    
    @Override
    public HandlerList getHandlers()
    {
        return HANDLERS;
    }
    
    public static HandlerList getHandlerList()
    {
        return HANDLERS;
    }
}
