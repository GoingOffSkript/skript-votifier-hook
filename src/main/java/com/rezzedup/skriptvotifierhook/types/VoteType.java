package com.rezzedup.skriptvotifierhook.types;

import ch.njol.skript.classes.ClassInfo;
import ch.njol.skript.classes.Parser;
import ch.njol.skript.expressions.base.EventValueExpression;
import ch.njol.skript.lang.ParseContext;
import ch.njol.skript.registrations.Classes;
import com.vexsoftware.votifier.model.Vote;

public class VoteType
{
    static 
    {
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
    }
}
