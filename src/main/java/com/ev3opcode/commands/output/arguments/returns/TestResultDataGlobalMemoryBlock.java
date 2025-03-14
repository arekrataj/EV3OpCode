package com.ev3opcode.commands.output.arguments.returns;

import org.jetbrains.annotations.Contract;

import com.ev3opcode.common.tools.DataOptimizer;
import com.ev3opcode.common.types.LongGlobalVariable8;
import com.ev3opcode.common.types.ShortGlobalVariable;

public final class TestResultDataGlobalMemoryBlock extends TestResultDataMemoryBlock {
    private int m_testResultOffsetCached;

    public TestResultDataGlobalMemoryBlock(int testResultDataOffset) {
        if (DataOptimizer.canBePackedIn5Bits(testResultDataOffset))
            super.m_testResultOffset = new ShortGlobalVariable((byte) testResultDataOffset);
        else if (DataOptimizer.canBePackedIn8Bits(testResultDataOffset))
            super.m_testResultOffset = new LongGlobalVariable8((byte) testResultDataOffset);

        m_testResultOffsetCached = testResultDataOffset;
    }

    @Contract(pure = true)
    @Override
    public boolean isGlobal() {
        return true;
    }

    @Contract(pure = true)
    @Override
    public int getTestResultOffset() {
        return m_testResultOffsetCached;
    }
}
