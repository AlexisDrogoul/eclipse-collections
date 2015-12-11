/*******************************************************************************
 * Copyright (c) 2015 Goldman Sachs.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * and Eclipse Distribution License v. 1.0 which accompany this distribution.
 * The Eclipse Public License is available at http://www.eclipse.org/legal/epl-v10.html
 * and the Eclipse Distribution License is available at
 * http://www.eclipse.org/org/documents/edl-v10.php.
 *******************************************************************************/

package org.eclipse.collections.impl.list.fixed;

import org.eclipse.collections.api.factory.list.FixedSizeListFactory;
import org.eclipse.collections.api.list.FixedSizeList;
import org.eclipse.collections.impl.utility.Iterate;
import net.jcip.annotations.Immutable;

@Immutable
public class FixedSizeListFactoryImpl implements FixedSizeListFactory
{
    private static final FixedSizeList<?> EMPTY_LIST = new EmptyList<Object>();

    public <T> FixedSizeList<T> empty()
    {
        return (FixedSizeList<T>) FixedSizeListFactoryImpl.EMPTY_LIST;
    }

    public <T> FixedSizeList<T> of()
    {
        return this.empty();
    }

    public <T> FixedSizeList<T> with()
    {
        return this.empty();
    }

    public <T> FixedSizeList<T> of(T one)
    {
        return this.with(one);
    }

    public <T> FixedSizeList<T> with(T one)
    {
        return new SingletonList<T>(one);
    }

    public <T> FixedSizeList<T> of(T one, T two)
    {
        return this.with(one, two);
    }

    public <T> FixedSizeList<T> with(T one, T two)
    {
        return new DoubletonList<T>(one, two);
    }

    public <T> FixedSizeList<T> of(T one, T two, T three)
    {
        return this.with(one, two, three);
    }

    public <T> FixedSizeList<T> with(T one, T two, T three)
    {
        return new TripletonList<T>(one, two, three);
    }

    public <T> FixedSizeList<T> of(T one, T two, T three, T four)
    {
        return this.with(one, two, three, four);
    }

    public <T> FixedSizeList<T> with(T one, T two, T three, T four)
    {
        return new QuadrupletonList<T>(one, two, three, four);
    }

    public <T> FixedSizeList<T> of(T one, T two, T three, T four, T five)
    {
        return this.with(one, two, three, four, five);
    }

    public <T> FixedSizeList<T> with(T one, T two, T three, T four, T five)
    {
        return new QuintupletonList<T>(one, two, three, four, five);
    }

    public <T> FixedSizeList<T> of(T one, T two, T three, T four, T five, T six)
    {
        return this.with(one, two, three, four, five, six);
    }

    public <T> FixedSizeList<T> with(T one, T two, T three, T four, T five, T six)
    {
        return new SextupletonList<T>(one, two, three, four, five, six);
    }

    public <T> FixedSizeList<T> of(T... items)
    {
        return this.with(items);
    }

    public <T> FixedSizeList<T> with(T... items)
    {
        switch (items.length)
        {
            case 0:
                return this.of();
            case 1:
                return this.of(items[0]);
            case 2:
                return this.of(items[0], items[1]);
            case 3:
                return this.of(items[0], items[1], items[2]);
            case 4:
                return this.of(items[0], items[1], items[2], items[3]);
            case 5:
                return this.of(items[0], items[1], items[2], items[3], items[4]);
            case 6:
                return this.of(items[0], items[1], items[2], items[3], items[4], items[5]);
            default:
                return ArrayAdapter.newArrayWith(items);
        }
    }

    public <T> FixedSizeList<T> ofAll(Iterable<? extends T> items)
    {
        return this.withAll(items);
    }

    public <T> FixedSizeList<T> withAll(Iterable<? extends T> items)
    {
        return this.of((T[]) Iterate.toArray(items));
    }
}