package com.rezzedup.skriptvotifierhook.expressions;

import ch.njol.skript.expressions.base.SimplePropertyExpression;
import com.vexsoftware.votifier.model.Vote;

public class VoterUsernameExpression extends SimplePropertyExpression<Vote, String>
{
    public static final String PATTERN = "[voter] user[(-| )]name";
    
    static 
    {
        SimplePropertyExpression.register(VoterUsernameExpression.class, String.class, PATTERN, "vote");
    }
    
    @Override
    public String convert(Vote vote)
    {
        return vote.getUsername();
    }
    
    @Override
    protected String getPropertyName()
    {
        return "username";
    }
    
    @Override
    public Class<? extends String> getReturnType()
    {
        return String.class;
    }
}
