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

    private final @NotNull ReentrantReadWriteLock theoriesSynchGuard = new ReentrantReadWriteLock();

    @Contract(pure = true)
    @NotNull
    protected EconomicMap<@NotNull String, @NotNull TheoryNode> getTheories() {
        return theories;
    }

    public <R> R withTheories(
            @NotNull Function<@NotNull EconomicMap<@NotNull String, @NotNull TheoryNode>, R> fn
    ) {
        theoriesSynchGuard.writeLock().lock();
        try {
            return fn.apply(getTheories());
        } finally {
            theoriesSynchGuard.writeLock().unlock();
        }
    }

    public void withTheoriesToVoid(
            @NotNull Consumer<@NotNull EconomicMap<@NotNull String, @NotNull TheoryNode>> fn
    ) {
        theoriesSynchGuard.writeLock().lock();
        try {
            fn.accept(getTheories());
        } finally {
            theoriesSynchGuard.writeLock().unlock();
        }
    }

    public boolean withTheoriesToBool(
            @NotNull Predicate<@NotNull EconomicMap<@NotNull String, @NotNull TheoryNode>> fn
    ) {
        theoriesSynchGuard.writeLock().lock();
        try {
            return fn.test(getTheories());
        } finally {
            theoriesSynchGuard.writeLock().unlock();
        }
    }

    public int withTheoriesToInt(
            @NotNull ToIntFunction<@NotNull EconomicMap<@NotNull String, @NotNull TheoryNode>> fn
    ) {
        theoriesSynchGuard.writeLock().lock();
        try {
            return fn.applyAsInt(getTheories());
        } finally {
            theoriesSynchGuard.writeLock().unlock();
        }
    }

    public long withTheoriesToLong(
            @NotNull ToLongFunction<@NotNull EconomicMap<@NotNull String, @NotNull TheoryNode>> fn
    ) {
        theoriesSynchGuard.writeLock().lock();
        try {
            return fn.applyAsLong(getTheories());
        } finally {
            theoriesSynchGuard.writeLock().unlock();
        }
    }

    public double withTheoriesToDouble(
            @NotNull ToDoubleFunction<@NotNull EconomicMap<@NotNull String, @NotNull TheoryNode>> fn
    ) {
        theoriesSynchGuard.writeLock().lock();
        try {
            return fn.applyAsDouble(getTheories());
        } finally {
            theoriesSynchGuard.writeLock().unlock();
        }
    }

    public <R> R withTheoriesView(
            @NotNull Function<@NotNull UnmodifiableEconomicMap<@NotNull String, @NotNull ? extends TheoryNode>, R> fn
    ) {
        theoriesSynchGuard.readLock().lock();
        try {
            return fn.apply(getTheories());
        } finally {
            theoriesSynchGuard.readLock().unlock();
        }
    }

    public void withTheoriesViewToVoid(
            @NotNull Consumer<@NotNull UnmodifiableEconomicMap<@NotNull String, @NotNull ? extends TheoryNode>> fn
    ) {
        theoriesSynchGuard.readLock().lock();
        try {
            fn.accept(getTheories());
        } finally {
            theoriesSynchGuard.readLock().unlock();
        }
    }

    public boolean withTheoriesViewToBool(
            @NotNull Predicate<@NotNull UnmodifiableEconomicMap<@NotNull String, @NotNull ? extends TheoryNode>> fn
    ) {
        theoriesSynchGuard.readLock().lock();
        try {
            return fn.test(getTheories());
        } finally {
            theoriesSynchGuard.readLock().unlock();
        }
    }

    public int withTheoriesViewToInt(
            @NotNull ToIntFunction<@NotNull UnmodifiableEconomicMap<@NotNull String, @NotNull ? extends TheoryNode>> fn
    ) {
        theoriesSynchGuard.readLock().lock();
        try {
            return fn.applyAsInt(getTheories());
        } finally {
            theoriesSynchGuard.readLock().unlock();
        }
    }

    public long withTheoriesViewToLong(
            @NotNull ToLongFunction<@NotNull UnmodifiableEconomicMap<@NotNull String, @NotNull ? extends TheoryNode>> fn
    ) {
        theoriesSynchGuard.readLock().lock();
        try {
            return fn.applyAsLong(getTheories());
        } finally {
            theoriesSynchGuard.readLock().unlock();
        }
    }

    public double withTheoriesViewToDouble(
            @NotNull ToDoubleFunction<@NotNull UnmodifiableEconomicMap<@NotNull String, @NotNull ? extends TheoryNode>> fn
    ) {
        theoriesSynchGuard.readLock().lock();
        try {
            return fn.applyAsDouble(getTheories());
        } finally {
            theoriesSynchGuard.readLock().unlock();
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
