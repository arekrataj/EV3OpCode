package com.ev3opcode.common.types;

public abstract class VariableDataType<T> extends DataType<T> {
    public abstract void setValue(T value);
}
