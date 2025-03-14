package com.ev3opcode.common.types;

import org.jetbrains.annotations.Contract;

import java.util.HashMap;
import java.util.Map;

public enum ChainLayerNumber {
    ZERO((byte) 0x0),
    ONE((byte) 0x1),
    TWO((byte) 0x2),
    THREE((byte) 0x3);

    private static Map<Byte, ChainLayerNumber> m_map = new HashMap<>();
    static {
        for (ChainLayerNumber layerNumber : ChainLayerNumber.values())
            m_map.put(layerNumber.m_value, layerNumber);
    }

    private Byte m_value;

    @Contract(pure = true)
    ChainLayerNumber(Byte value) {
        m_value = value;
    }

    public static ChainLayerNumber getValueOf(Byte value) {
        return (ChainLayerNumber) m_map.get(value);
    }

    @Contract(pure = true)
    public Byte getValue() {
        return m_value;
    }
}
