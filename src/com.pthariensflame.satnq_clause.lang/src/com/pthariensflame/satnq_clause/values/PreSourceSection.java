package com.pthariensflame.satnq_clause.values;

import com.oracle.truffle.api.CompilerDirectives;
import com.oracle.truffle.api.interop.ArityException;
import com.oracle.truffle.api.interop.InteropLibrary;
import com.oracle.truffle.api.interop.TruffleObject;
import com.oracle.truffle.api.interop.UnknownIdentifierException;
import com.oracle.truffle.api.interop.UnsupportedTypeException;
import com.oracle.truffle.api.library.ExportLibrary;
import com.oracle.truffle.api.library.ExportMessage;
import com.oracle.truffle.api.source.Source;
import com.oracle.truffle.api.source.SourceSection;
import org.graalvm.polyglot.proxy.ProxyArray;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.jetbrains.annotations.Range;

@ExportLibrary(InteropLibrary.class)
@CompilerDirectives.ValueType
public final class PreSourceSection implements TruffleObject, Cloneable {
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

    @NotNull
    @Override
    protected PreSourceSection clone() {
        try {
            return (PreSourceSection) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException("Impossible case", e);
        }
    }

    private static final String[] MEMBER_NAMES = new String[]{
            "start",
            "length",
            "copy"
    };

    @ExportMessage
    @Contract(value = "-> true", pure = true)
    public boolean hasMembers() {
        return true;
    }

    @ExportMessage
    @Contract(pure = true)
    @NotNull
    public ProxyArray getMembers(@SuppressWarnings("unused") boolean includeInternal) {
        return ProxyArray.fromArray((Object[]) MEMBER_NAMES);
    }

    @ExportMessage
    @Contract(pure = true)
    public boolean isMemberReadable(@NotNull String member) {
        return member.equals("start") || member.equals("length");
    }

    @ExportMessage
    public int readMember(@NotNull String member) throws UnknownIdentifierException {
        switch (member) {
            case "start":
                return start;
            case "length":
                return length;
            default:
                throw UnknownIdentifierException.create(member);
        }
    }

    @ExportMessage
    @Contract(pure = true)
    public boolean isMemberInvocable(@NotNull String member) {
        return member.equals("copy");
    }

    @ExportMessage
    @NotNull
    public PreSourceSection invokeMember(@NotNull String member, @Nullable Object... arguments) throws ArityException, UnknownIdentifierException, UnsupportedTypeException {
        if (!member.equals("copy")) throw UnknownIdentifierException.create(member);
        else switch (arguments.length) {
            case 0:
                return clone();
            case 2:
                if (arguments[0] instanceof Integer && arguments[1] instanceof Integer)
                    return new PreSourceSection((Integer) arguments[0], (Integer) arguments[1]);
                else throw UnsupportedTypeException.create(arguments, "\"copy\" requires 0 or 2 ints");
            default:
                throw ArityException.create(2, arguments.length);
        }
    }
}
