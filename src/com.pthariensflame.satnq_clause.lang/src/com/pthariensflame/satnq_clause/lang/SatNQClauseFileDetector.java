package com.pthariensflame.satnq_clause.lang;

import com.oracle.truffle.api.TruffleFile;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

public final class SatNQClauseFileDetector implements TruffleFile.FileTypeDetector {
    @Contract(pure = true)
    @Nullable
    @Override
    public String findMimeType(@NotNull TruffleFile file) {
        final @Nullable String fileName = file.getName();
        if (fileName == null) return null;
        else if (fileName.endsWith(".thr.snq")) return SatNQClauseLanguage.THEORY_MIME_TYPE;
        else if (fileName.endsWith(".qry.snq")) return SatNQClauseLanguage.QUERY_MIME_TYPE;
        else return null;
    }

    @Contract(pure = true)
    @NotNull
    @Override
    public Charset findEncoding(@NotNull TruffleFile file) {
        return StandardCharsets.UTF_8;
    }
}
