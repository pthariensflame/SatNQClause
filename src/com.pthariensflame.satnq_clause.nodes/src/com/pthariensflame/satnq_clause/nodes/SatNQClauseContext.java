package com.pthariensflame.satnq_clause.nodes;

import com.oracle.truffle.api.TruffleLanguage.Env;
import com.oracle.truffle.api.profiles.ConditionProfile;
import com.oracle.truffle.api.utilities.AssumedValue;
import org.jetbrains.annotations.ApiStatus;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.io.InputStream;
import java.io.OutputStream;

public final class SatNQClauseContext {
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
    ConditionProfile polyglotBindingsAvailableProfile = ConditionProfile.createBinaryProfile();

    @Nullable
    public Object getPolyglotBindingsOrNull() {
        if (polyglotBindingsAvailableProfile.profile(getEnv().isPolyglotBindingsAccessAllowed())) {
            return getEnv().getPolyglotBindings();
        } else {
            return null;
        }
    }
}
