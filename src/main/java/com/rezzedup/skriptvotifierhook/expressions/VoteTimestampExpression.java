package com.rezzedup.skriptvotifierhook.expressions;

import ch.njol.skript.expressions.base.SimplePropertyExpression;
import com.vexsoftware.votifier.model.Vote;

public class VoteTimestampExpression extends SimplePropertyExpression<Vote, String>
{
    public static final String PATTERN = "[received] [voter] time[(-| )]stamp";
    
    static 
    {
        SimplePropertyExpression.register(VoteTimestampExpression.class, String.class, PATTERN, "vote");
    }
    
    @Override
    public String convert(Vote vote)
    {
        return vote.getTimeStamp();
    }
    
    @Override
    protected String getPropertyName()
    {
        return "timestamp";
    }
    
    @Override
    public Class<? extends String> getReturnType()
    {
        return String.class;
    }
}
