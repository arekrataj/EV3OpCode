package com.ev3opcode.common.arguments;

import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

public final class ChainLayerNumberValue extends ArgumentValue implements ChainLayerNumber {
    private com.ev3opcode.common.types.ChainLayerNumber m_layerNumberCached;

    public ChainLayerNumberValue(@NotNull com.ev3opcode.common.types.ChainLayerNumber layerNumber) {
        setLayerNumber(layerNumber);
    }

    @Contract(pure = true)
    public com.ev3opcode.common.types.ChainLayerNumber getLayerNumber() {
        return m_layerNumberCached;
    }

    public void setLayerNumber(@NotNull com.ev3opcode.common.types.ChainLayerNumber layerNumber) {
        super.setValue(layerNumber.getValue());
        m_layerNumberCached = layerNumber;
    }
}
