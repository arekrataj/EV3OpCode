package com.ev3opcode.common.arguments;

import com.ev3opcode.common.tools.DataOptimizer;
import com.ev3opcode.common.types.LongConstant16;
import com.ev3opcode.common.types.LongConstant32;
import com.ev3opcode.common.types.LongConstant8;
import com.ev3opcode.common.types.LongString;
import com.ev3opcode.common.types.ShortConstant;

public abstract class ArgumentValue extends Argument {
    protected void setValue(int value) {
        if (DataOptimizer.canBePackedIn5Bits(value))
            super.m_dataType = new ShortConstant((byte) value);
        else if (DataOptimizer.canBePackedIn8Bits(value))
            super.m_dataType = new LongConstant8((byte) value);
        else if (DataOptimizer.canBePackedIn16Bits(value))
            super.m_dataType = new LongConstant16((short) value);
        else
            super.m_dataType = new LongConstant32(value);
    }

    protected void setValue(String value) {
        super.m_dataType = new LongString(value);
    }
}
