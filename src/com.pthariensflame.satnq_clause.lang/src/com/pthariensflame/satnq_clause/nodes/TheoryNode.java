package com.pthariensflame.satnq_clause.nodes;

import com.oracle.truffle.api.dsl.CachedContext;
import com.oracle.truffle.api.dsl.GenerateNodeFactory;
import com.oracle.truffle.api.dsl.NodeChild;
import com.oracle.truffle.api.dsl.NodeField;
import com.oracle.truffle.api.dsl.Specialization;
import com.oracle.truffle.api.frame.FrameDescriptor;
import com.oracle.truffle.api.frame.VirtualFrame;
import com.oracle.truffle.api.instrumentation.GenerateWrapper;
import com.oracle.truffle.api.instrumentation.ProbeNode;
import com.oracle.truffle.api.instrumentation.StandardTags;
import com.oracle.truffle.api.instrumentation.Tag;
import com.oracle.truffle.api.interop.InteropLibrary;
import com.oracle.truffle.api.library.ExportLibrary;
import com.oracle.truffle.api.nodes.ExecutableNode;
import com.oracle.truffle.api.nodes.NodeInfo;
import com.oracle.truffle.api.nodes.RootNode;
import com.oracle.truffle.api.source.Source;
import com.oracle.truffle.api.source.SourceSection;
import com.pthariensflame.satnq_clause.lang.SatNQClauseContext;
import com.pthariensflame.satnq_clause.lang.SatNQClauseLanguage;
import com.pthariensflame.satnq_clause.values.PreSourceSection;
import org.jetbrains.annotations.ApiStatus;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@NodeInfo(
        shortName = "theory",
        description = "A SaTNQClause theory"
)
@GenerateWrapper
@GenerateNodeFactory
@NodeChild(value = "body", type = ExecutableNode.class)
@NodeField(name = "source", type = Source.class)
@NodeField(name = "preSourceSection", type = PreSourceSection.class)
@NodeField(name = "theoryName", type = String.class)
@ExportLibrary(InteropLibrary.class)
@ApiStatus.NonExtendable
public abstract class TheoryNode extends RootNode implements SatNQClauseNode {
    protected TheoryNode() {
        this(null);
    }

    protected TheoryNode(@Nullable SatNQClauseLanguage language) {
        super(language);
    }

    protected TheoryNode(@Nullable SatNQClauseLanguage language, @Nullable FrameDescriptor frameDescriptor) {
        super(language, frameDescriptor);
    }

    @Specialization
    @Contract(value = "_, _, _ -> this")
    @NotNull
    protected TheoryNode evalTheory(
            @NotNull VirtualFrame frame,
            @NotNull SatNQClauseNode body,
            @CachedContext(SatNQClauseLanguage.class)
            @NotNull SatNQClauseContext cxt) {
        final @NotNull TheoryNode self = this;
        return cxt.withTheories(theories -> {
            theories.put(getTheoryName(), self);
            return self;
        });
    }

    @Contract("_ -> new")
    @NotNull
    @Override
    public WrapperNode createWrapper(@NotNull ProbeNode probeNode) {
        return new TheoryNodeWrapper(this, probeNode);
    }

    @Contract(value = "-> true", pure = true)
    @Override
    public boolean isInstrumentable() {
        return true;
    }

    @Contract(pure = true)
    @Override
    public boolean hasTag(Class<? extends Tag> tag) {
        return tag == StandardTags.RootTag.class;
    }

    @Override
    @Contract(pure = true)
    @Nullable
    public abstract Source getSource();

    @Override
    @Contract(pure = true)
    @Nullable
    public abstract PreSourceSection getPreSourceSection();

    @Contract(pure = true)
    @NotNull
    protected abstract String getTheoryName();

    @Nullable
    @Override
    public SourceSection getSourceSection() {
        if (getSource() == null) return null;
        else if (getPreSourceSection() != null)
            return getPreSourceSection().asSectionOf(getSource());
        else return getSource().createUnavailableSection();
    }
}
