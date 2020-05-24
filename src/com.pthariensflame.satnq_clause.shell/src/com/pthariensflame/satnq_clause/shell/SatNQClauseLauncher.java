package com.pthariensflame.satnq_clause.shell;

import org.graalvm.launcher.AbstractLanguageLauncher;
import org.graalvm.options.OptionCategory;
import org.graalvm.polyglot.Context;
import org.intellij.lang.annotations.Flow;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

import java.util.List;
import java.util.Map;

public final class SatNQClauseLauncher extends AbstractLanguageLauncher {
    public static void main(@NotNull String @NotNull [] args) {
        new SatNQClauseLauncher().launch(args);
    }

    private SatNQClauseLauncher() {
        super();
    }

    @Contract(pure = true)
    @Override
    protected @NotNull List<@NotNull String> preprocessArguments(
            @Flow(
                    sourceIsContainer = true,
                    target = Flow.RETURN_METHOD_TARGET,
                    targetIsContainer = true
            ) @NotNull List<@NotNull String> arguments,
            @NotNull Map<@NotNull String, @NotNull String> polyglotOptions
    ) {
        // TODO
        return arguments;
    }

    @Override
    protected void launch(Context.Builder contextBuilder) {
        // TODO
    }

    @Contract(pure = true)
    @Override
    protected @NotNull String getLanguageId() {
        return "SatNQClause";
    }

    @Override
    protected void printHelp(@NotNull OptionCategory maxCategory) {
        // TODO
    }
}
