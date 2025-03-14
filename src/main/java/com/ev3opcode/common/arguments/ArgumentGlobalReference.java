package com.ev3opcode.common.arguments;

import com.ev3opcode.common.tools.DataOptimizer;
import com.ev3opcode.common.types.LongGlobalVariable16;
import com.ev3opcode.common.types.LongGlobalVariable32;
import com.ev3opcode.common.types.LongGlobalVariable8;
import com.ev3opcode.common.types.ShortGlobalVariable;

public abstract class ArgumentGlobalReference extends Argument {
    protected ArgumentGlobalReference(int value) {
        if (DataOptimizer.canBePackedIn5Bits(value))
            super.m_dataType = new ShortGlobalVariable((byte) value);
        else if (DataOptimizer.canBePackedIn8Bits(value))
            super.m_dataType = new LongGlobalVariable8((byte) value);
        else if (DataOptimizer.canBePackedIn16Bits(value))
            super.m_dataType = new LongGlobalVariable16((short) value);
        else
            super.m_dataType = new LongGlobalVariable32(value);
    }
}
