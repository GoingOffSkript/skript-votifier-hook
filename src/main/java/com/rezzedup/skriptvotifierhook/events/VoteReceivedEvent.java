package com.rezzedup.skriptvotifierhook.events;

import ch.njol.skript.Skript;
import ch.njol.skript.lang.util.SimpleEvent;
import ch.njol.skript.registrations.EventValues;
import com.rezzedup.skriptvotifierhook.GoGetter;
import com.vexsoftware.votifier.model.Vote;
import com.vexsoftware.votifier.model.VotifierEvent;

public class VoteReceivedEvent
{
    public static final String[] PATTERNS = new String[]
    {
        "[(any|every|raw)] [votifier] vote receiv(e|ed)",
        "[(any|every|raw)] votifier vote"
    };
    
    static 
    {
        Skript.registerEvent("On Votifier Vote", SimpleEvent.class, VotifierEvent.class, PATTERNS);
    
        EventValues.registerEventValue
        (
            VotifierEvent.class, Vote.class, new GoGetter<>(VotifierEvent::getVote), 0
        );
    }
}
