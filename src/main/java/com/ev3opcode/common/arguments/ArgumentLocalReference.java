package com.ev3opcode.common.arguments;

import com.ev3opcode.common.tools.DataOptimizer;
import com.ev3opcode.common.types.LongLocalVariable16;
import com.ev3opcode.common.types.LongLocalVariable32;
import com.ev3opcode.common.types.LongLocalVariable8;
import com.ev3opcode.common.types.ShortLocalVariable;

public abstract class ArgumentLocalReference extends Argument {
    protected ArgumentLocalReference(int value) {
        if (DataOptimizer.canBePackedIn5Bits(value))
            super.m_dataType = new ShortLocalVariable((byte) value);
        else if (DataOptimizer.canBePackedIn8Bits(value))
            super.m_dataType = new LongLocalVariable8((byte) value);
        else if (DataOptimizer.canBePackedIn16Bits(value))
            super.m_dataType = new LongLocalVariable16((short) value);
        else
            super.m_dataType = new LongLocalVariable32(value);
    }
}
