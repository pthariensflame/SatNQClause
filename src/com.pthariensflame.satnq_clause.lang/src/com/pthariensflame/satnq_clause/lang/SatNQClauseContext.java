package com.pthariensflame.satnq_clause.lang;

import com.oracle.truffle.api.TruffleLanguage.Env;
import com.oracle.truffle.api.profiles.ConditionProfile;
import com.oracle.truffle.api.utilities.AssumedValue;
import com.pthariensflame.satnq_clause.nodes.TheoryNode;
import org.graalvm.collections.EconomicMap;
import org.graalvm.collections.Equivalence;
import org.graalvm.collections.UnmodifiableEconomicMap;
import org.jetbrains.annotations.ApiStatus;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.io.InputStream;
import java.io.OutputStream;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.ToDoubleFunction;
import java.util.function.ToIntFunction;
import java.util.function.ToLongFunction;

public final class SatNQClauseContext {
    private final @NotNull
    EconomicMap<@NotNull String, @NotNull TheoryNode> theories =
            EconomicMap.create(Equivalence.DEFAULT);

    private final @NotNull
    ReentrantReadWriteLock theoriesSynchGuard = new ReentrantReadWriteLock();
    private final @NotNull
    ReentrantReadWriteLock.ReadLock theoriesSynchGuardRead = theoriesSynchGuard.readLock();
    private final @NotNull
    ReentrantReadWriteLock.WriteLock theoriesSynchGuardWrite = theoriesSynchGuard.writeLock();

    @Contract(pure = true)
    @NotNull
    protected EconomicMap<@NotNull String, @NotNull TheoryNode> getTheories() {
        return theories;
    }

    public <R> R withTheories(
            @NotNull Function<@NotNull EconomicMap<@NotNull String, @NotNull TheoryNode>, R> fn
    ) {
        theoriesSynchGuardWrite.lock();
        try {
            return fn.apply(getTheories());
        } finally {
            theoriesSynchGuardWrite.unlock();
        }
    }

    public void withTheoriesToVoid(
            @NotNull Consumer<@NotNull EconomicMap<@NotNull String, @NotNull TheoryNode>> fn
    ) {
        theoriesSynchGuardWrite.lock();
        try {
            fn.accept(getTheories());
        } finally {
            theoriesSynchGuardWrite.unlock();
        }
    }

    public boolean withTheoriesToBool(
            @NotNull Predicate<@NotNull EconomicMap<@NotNull String, @NotNull TheoryNode>> fn
    ) {
        theoriesSynchGuardWrite.lock();
        try {
            return fn.test(getTheories());
        } finally {
            theoriesSynchGuardWrite.unlock();
        }
    }

    public int withTheoriesToInt(
            @NotNull ToIntFunction<@NotNull EconomicMap<@NotNull String, @NotNull TheoryNode>> fn
    ) {
        theoriesSynchGuardWrite.lock();
        try {
            return fn.applyAsInt(getTheories());
        } finally {
            theoriesSynchGuardWrite.unlock();
        }
    }

    public long withTheoriesToLong(
            @NotNull ToLongFunction<@NotNull EconomicMap<@NotNull String, @NotNull TheoryNode>> fn
    ) {
        theoriesSynchGuardWrite.lock();
        try {
            return fn.applyAsLong(getTheories());
        } finally {
            theoriesSynchGuardWrite.unlock();
        }
    }

    public double withTheoriesToDouble(
            @NotNull ToDoubleFunction<@NotNull EconomicMap<@NotNull String, @NotNull TheoryNode>> fn
    ) {
        theoriesSynchGuardWrite.lock();
        try {
            return fn.applyAsDouble(getTheories());
        } finally {
            theoriesSynchGuardWrite.unlock();
        }
    }

    public <R> R withTheoriesView(
            @NotNull Function<@NotNull UnmodifiableEconomicMap<@NotNull String, @NotNull ? extends TheoryNode>, R> fn
    ) {
        theoriesSynchGuardRead.lock();
        try {
            return fn.apply(getTheories());
        } finally {
            theoriesSynchGuardRead.unlock();
        }
    }

    public void withTheoriesViewToVoid(
            @NotNull Consumer<@NotNull UnmodifiableEconomicMap<@NotNull String, @NotNull ? extends TheoryNode>> fn
    ) {
        theoriesSynchGuardRead.lock();
        try {
            fn.accept(getTheories());
        } finally {
            theoriesSynchGuardRead.unlock();
        }
    }

    public boolean withTheoriesViewToBool(
            @NotNull Predicate<@NotNull UnmodifiableEconomicMap<@NotNull String, @NotNull ? extends TheoryNode>> fn
    ) {
        theoriesSynchGuardRead.lock();
        try {
            return fn.test(getTheories());
        } finally {
            theoriesSynchGuardRead.unlock();
        }
    }

    public int withTheoriesViewToInt(
            @NotNull ToIntFunction<@NotNull UnmodifiableEconomicMap<@NotNull String, @NotNull ? extends TheoryNode>> fn
    ) {
        theoriesSynchGuardRead.lock();
        try {
            return fn.applyAsInt(getTheories());
        } finally {
            theoriesSynchGuardRead.unlock();
        }
    }

    public long withTheoriesViewToLong(
            @NotNull ToLongFunction<@NotNull UnmodifiableEconomicMap<@NotNull String, @NotNull ? extends TheoryNode>> fn
    ) {
        theoriesSynchGuardRead.lock();
        try {
            return fn.applyAsLong(getTheories());
        } finally {
            theoriesSynchGuardRead.unlock();
        }
    }

    public double withTheoriesViewToDouble(
            @NotNull ToDoubleFunction<@NotNull UnmodifiableEconomicMap<@NotNull String, @NotNull ? extends TheoryNode>> fn
    ) {
        theoriesSynchGuardRead.lock();
        try {
            return fn.applyAsDouble(getTheories());
        } finally {
            theoriesSynchGuardRead.unlock();
        }
    }

    private final @NotNull
    AssumedValue<@NotNull Env> envVal;

    @ApiStatus.Internal
    public SatNQClauseContext(@NotNull Env env) {
        this.envVal = new AssumedValue<>("env", env);
    }

    @Contract(pure = true)
    public @NotNull Env getEnv() {
        return envVal.get();
    }

    @Contract(mutates = "this")
    @ApiStatus.Internal
    public void setEnv(@NotNull Env env) {
        this.envVal.set(env);
    }

    @NotNull
    public InputStream getInStream() {
        return getEnv().in();
    }

    @NotNull
    public OutputStream getOutStream() {
        return getEnv().out();
    }

    @NotNull
    public OutputStream getErrStream() {
        return getEnv().err();
    }

    private final @NotNull
    ConditionProfile polyglotBindingsAvailableProfile =
            ConditionProfile.createBinaryProfile();

    @Nullable
    public Object getPolyglotBindingsOrNull() {
        if (polyglotBindingsAvailableProfile.profile(getEnv().isPolyglotBindingsAccessAllowed())) {
            return getEnv().getPolyglotBindings();
        } else {
            return null;
        }
    }
}
