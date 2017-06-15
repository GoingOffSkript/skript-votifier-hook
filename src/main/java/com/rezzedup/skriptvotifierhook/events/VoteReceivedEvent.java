package com.rezzedup.skriptvotifierhook.events;

import ch.njol.skript.Skript;
import ch.njol.skript.lang.util.SimpleEvent;
import ch.njol.skript.registrations.EventValues;
import com.rezzedup.skriptvotifierhook.GoGetter;
import com.vexsoftware.votifier.model.Vote;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

public class VoteReceivedEvent extends Event
{
    private static final HandlerList HANDLERS = new HandlerList();
    
    public static final String[] PATTERNS = new String[]
    {
        "[raw] [votifier] vote receiv(e|ed)",
        "[raw] votifier vote"
    };
    
    static 
    {
        Skript.registerEvent("On Vote Received", SimpleEvent.class, VoteReceivedEvent.class, PATTERNS);
    
        EventValues.registerEventValue
        (
            VoteReceivedEvent.class, Vote.class, new GoGetter<>(VoteReceivedEvent::getVote), 0
        );
    }
    
    private final Vote vote;
    
    public VoteReceivedEvent(Vote vote)
    {
        this.vote = vote;
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
