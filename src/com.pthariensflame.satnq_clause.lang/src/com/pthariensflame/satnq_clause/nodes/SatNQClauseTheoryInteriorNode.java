package com.pthariensflame.satnq_clause.nodes;

import com.oracle.truffle.api.dsl.NodeField;
import com.oracle.truffle.api.instrumentation.ProbeNode;
import com.oracle.truffle.api.interop.InteropLibrary;
import com.oracle.truffle.api.library.ExportLibrary;
import com.oracle.truffle.api.nodes.Node;
import com.oracle.truffle.api.nodes.NodeInfo;
import com.oracle.truffle.api.nodes.RootNode;
import com.oracle.truffle.api.source.Source;
import com.oracle.truffle.api.source.SourceSection;
import com.pthariensflame.satnq_clause.values.PreSourceSection;
import org.jetbrains.annotations.ApiStatus;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@NodeInfo(
        description = "An element of a SaTNQClause theory"
)
@NodeField(name = "preSourceSection", type = PreSourceSection.class)
@ExportLibrary(InteropLibrary.class)
@ApiStatus.NonExtendable
public abstract class SatNQClauseTheoryInteriorNode extends Node implements SatNQClauseNode {
    @Contract("_ -> new")
    @NotNull
    @Override
    public abstract WrapperNode createWrapper(@NotNull ProbeNode probe);

    @Contract(value = "-> true", pure = true)
    @Override
    public boolean isInstrumentable() {
        return true;
    }

    @Nullable
    @Override
    public final Source getSource() {
        final RootNode r = getRootNode();
        if (r == null) return null;
        final SourceSection ss = r.getSourceSection();
        if (ss == null) return null;
        return ss.getSource();
    }

    @Nullable
    @Override
    public abstract PreSourceSection getPreSourceSection();

    @Nullable
    @Override
    public SourceSection getSourceSection() {
        final @Nullable Source s = getSource();
        final @Nullable PreSourceSection pss = getPreSourceSection();
        if (s == null) return null;
        else if (pss != null) return pss.asSectionOf(s);
        else return s.createUnavailableSection();
    }
}
