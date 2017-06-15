package com.rezzedup.skriptvotifierhook;

import ch.njol.skript.util.Getter;

import java.util.function.Function;

public class GoGetter<O, I> extends Getter<O, I>
{
    private final Function<I, O> getter;
    
    public GoGetter(Function<I, O> getter)
    {
        this.getter = getter;
    }
    
    @Override
    public O get(I input)
    {
        return getter.apply(input);
    }
}
