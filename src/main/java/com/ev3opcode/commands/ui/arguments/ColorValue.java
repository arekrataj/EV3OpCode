package com.ev3opcode.commands.ui.arguments;

import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

import com.ev3opcode.common.arguments.ArgumentValue;

public final class ColorValue extends ArgumentValue implements Color {
    private com.ev3opcode.commands.ui.types.Color m_colorCached;

    public ColorValue(@NotNull com.ev3opcode.commands.ui.types.Color color) {
        setColor(color);
    }

    @Contract(pure = true)
    public com.ev3opcode.commands.ui.types.Color getColor() {
        return m_colorCached;
    }

    public void setColor(@NotNull com.ev3opcode.commands.ui.types.Color color) {
        super.setValue(color.getValue());
        m_colorCached = color;
    }
}
