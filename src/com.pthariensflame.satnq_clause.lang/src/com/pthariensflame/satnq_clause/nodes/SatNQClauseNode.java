package com.pthariensflame.satnq_clause.nodes;

import com.oracle.truffle.api.dsl.ReportPolymorphism;
import com.oracle.truffle.api.instrumentation.InstrumentableNode;
import com.oracle.truffle.api.instrumentation.ProbeNode;
import com.oracle.truffle.api.interop.TruffleObject;
import com.oracle.truffle.api.nodes.NodeInfo;
import com.oracle.truffle.api.source.Source;
import com.oracle.truffle.api.source.SourceSection;
import com.pthariensflame.satnq_clause.lang.SatNQClauseLanguage;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@NodeInfo(
        language = SatNQClauseLanguage.LANGUAGE_NAME
)
@ReportPolymorphism
interface SatNQClauseNode extends InstrumentableNode, TruffleObject {
    @Contract("_ -> new")
    @NotNull
    @Override
    WrapperNode createWrapper(@NotNull ProbeNode probe);

    @Contract(value = "-> true", pure = true)
    @Override
    default boolean isInstrumentable() {
        return true;
    }

    @Contract(value = "-> this", pure = true)
    @Override
    default TruffleObject getNodeObject() {
        return this;
    }

    @Contract(pure = true)
    @Nullable
    Source getSource();

    @Contract(pure = true)
    @Nullable
    PreSourceSection getPreSourceSection();

    @Nullable
    default SourceSection getSourceSection() {
        {
            if (getSource() == null) return null;
            else if (getPreSourceSection() != null)
                return getPreSourceSection().asSectionOf(getSource());
            else return getSource().createUnavailableSection();
        }
    }
}
