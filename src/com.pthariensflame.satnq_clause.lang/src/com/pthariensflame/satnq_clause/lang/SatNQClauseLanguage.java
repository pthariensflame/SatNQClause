package com.pthariensflame.satnq_clause.lang;

import com.oracle.truffle.api.CallTarget;
import com.oracle.truffle.api.CompilerDirectives;
import com.oracle.truffle.api.Scope;
import com.oracle.truffle.api.TruffleLanguage;
import com.oracle.truffle.api.frame.Frame;
import com.oracle.truffle.api.nodes.ExecutableNode;
import com.oracle.truffle.api.nodes.Node;
import com.pthariensflame.satnq_clause.nodes.SatNQClauseContext;
import org.graalvm.options.OptionDescriptors;
import org.graalvm.options.OptionValues;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@TruffleLanguage.Registration(
        id = SatNQClauseLanguage.LANGUAGE_NAME,
        name = SatNQClauseLanguage.LANGUAGE_NAME,
        implementationName = SatNQClauseLanguage.LANGUAGE_NAME,
        version = SatNQClauseLanguage.LANGUAGE_VERSION,
        byteMimeTypes = {},
        characterMimeTypes = {
                SatNQClauseLanguage.THEORY_MIME_TYPE,
                SatNQClauseLanguage.QUERY_MIME_TYPE
        },
        defaultMimeType = SatNQClauseLanguage.QUERY_MIME_TYPE,
        interactive = true,
        internal = false,
        dependentLanguages = {},
        contextPolicy = TruffleLanguage.ContextPolicy.SHARED,
        services = {},
        fileTypeDetectors = {
                SatNQClauseFileDetector.class
        }
)
public final class SatNQClauseLanguage extends TruffleLanguage<SatNQClauseContext> {
    public static final @NotNull String LANGUAGE_NAME = "SatNQClause";
    public static final @NotNull String LANGUAGE_VERSION = "0.0.1";

    public static final @NotNull String THEORY_MIME_TYPE = "text/x-satnqclause-theory";
    public static final @NotNull String QUERY_MIME_TYPE = "text/x-satnqclause-query";

    @Contract(pure = true)
    @NotNull
    @Override
    protected OptionDescriptors getOptionDescriptors() {
        return OptionDescriptors.EMPTY; // TODO
    }

    @Contract(pure = true)
    @Override
    protected boolean areOptionsCompatible(@NotNull OptionValues firstOptions, @NotNull OptionValues newOptions) {
        return true; // TODO
    }

    @Contract(value = "_ -> new", pure = true)
    @Override
    protected @NotNull SatNQClauseContext createContext(@NotNull Env env) {
        return new SatNQClauseContext(env);
    }

    @Override
    protected void initializeContext(@NotNull SatNQClauseContext context) {
        // TODO
    }

    @Override
    protected void initializeMultipleContexts() {
        // TODO
    }

    @Contract(mutates = "param1")
    @CompilerDirectives.TruffleBoundary
    @Override
    protected boolean patchContext(@NotNull SatNQClauseContext context, @NotNull Env newEnv) {
        context.setEnv(newEnv);
        return true;
    }

    @Override
    protected void finalizeContext(@NotNull SatNQClauseContext context) {
        // TODO
    }

    @Override
    protected void disposeContext(@NotNull SatNQClauseContext context) {
        // TODO
    }

    @Contract(value = "_, _ -> true", pure = true)
    @Override
    protected boolean isThreadAccessAllowed(@NotNull Thread thread, boolean singleThreaded) {
        return true;
    }

    @Override
    protected void initializeThread(@NotNull SatNQClauseContext context, @NotNull Thread thread) {
        // TODO
    }

    @Override
    protected void initializeMultiThreading(@NotNull SatNQClauseContext context) {
        // TODO
    }

    @Override
    protected void disposeThread(@NotNull SatNQClauseContext context, @NotNull Thread thread) {
        // TODO
    }

    @Override
    protected boolean isVisible(@NotNull SatNQClauseContext context, @NotNull Object value) {
        return true; // TODO
    }

    @Override
    protected Iterable<Scope> findTopScopes(SatNQClauseContext context) {
        return super.findTopScopes(context); // TODO
    }

    @Override
    protected Iterable<Scope> findLocalScopes(SatNQClauseContext context, Node node, Frame frame) {
        return super.findLocalScopes(context, node, frame); // TODO
    }

    @Override
    protected Object getLanguageView(@NotNull SatNQClauseContext context, @Nullable Object value) {
        return super.getLanguageView(context, value); // TODO
    }

    @Override
    protected Object getScopedView(SatNQClauseContext context, Node location, Frame frame, Object value) {
        return super.getScopedView(context, location, frame, value); // TODO
    }

    @Override
    protected CallTarget parse(ParsingRequest request) throws Exception {
        return super.parse(request);
    }

    @Override
    protected ExecutableNode parse(InlineParsingRequest request) throws Exception {
        return super.parse(request);
    }
}
