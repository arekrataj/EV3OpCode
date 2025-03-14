package com.ev3opcode.common.arguments;

import com.ev3opcode.common.ByteCode;

public interface NumberOfReturnValues extends ByteCode {
    int getValue();

    boolean isReference();
}
