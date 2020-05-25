package com.pthariensflame.satnq_clause.nodes;

import com.oracle.truffle.api.CompilerDirectives;
import com.oracle.truffle.api.source.Source;
import com.oracle.truffle.api.source.SourceSection;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.Nullable;
import org.jetbrains.annotations.Range;

@CompilerDirectives.ValueType
public final class PreSourceSection {
    public final @Range(from = 0, to = Integer.MAX_VALUE)
    int start;

    public final @Range(from = 0, to = Integer.MAX_VALUE)
    int length;

    public PreSourceSection(
            @Range(from = 0, to = Integer.MAX_VALUE) int start,
            @Range(from = 0, to = Integer.MAX_VALUE) int length
    ) {
        this.start = start;
        this.length = length;
    }

    @Contract("null -> null; !null -> !null")
    @Nullable
    public SourceSection asSectionOf(@Nullable Source source) {
        if (source != null)
            return source.createSection(start, length);
        else return null;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        else if (o == null || getClass() != o.getClass()) return false;
        else {
            PreSourceSection that = (PreSourceSection) o;
            return start == that.start &&
                    length == that.length;
        }
    }

    @Override
    public int hashCode() {
        int result = start;
        result = 31 * result + length;
        return result;
    }
}
