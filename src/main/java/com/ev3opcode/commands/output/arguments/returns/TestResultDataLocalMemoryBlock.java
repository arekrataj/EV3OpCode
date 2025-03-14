package com.ev3opcode.commands.output.arguments.returns;

import org.jetbrains.annotations.Contract;

import com.ev3opcode.common.tools.DataOptimizer;
import com.ev3opcode.common.types.LongLocalVariable8;
import com.ev3opcode.common.types.ShortLocalVariable;

public final class TestResultDataLocalMemoryBlock extends TestResultDataMemoryBlock {
    private int m_testResultOffsetCached;

    public TestResultDataLocalMemoryBlock(int testResultDataOffset) {
        if (DataOptimizer.canBePackedIn5Bits(testResultDataOffset))
            super.m_testResultOffset = new ShortLocalVariable((byte) testResultDataOffset);
        else if (DataOptimizer.canBePackedIn8Bits(testResultDataOffset))
            super.m_testResultOffset = new LongLocalVariable8((byte) testResultDataOffset);

        m_testResultOffsetCached = testResultDataOffset;
    }

    @Contract(pure = true)
    @Override
    public boolean isGlobal() {
        return false;
    }

    @Contract(pure = true)
    @Override
    public int getTestResultOffset() {
        return m_testResultOffsetCached;
    }
}
