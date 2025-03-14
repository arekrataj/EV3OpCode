package com.ev3opcode.commands.program.arguments;

import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

import com.ev3opcode.commands.program.types.ProgramID;
import com.ev3opcode.common.arguments.ArgumentValue;

public final class ProgramIdValue extends ArgumentValue implements ProgramId {
    private ProgramID m_programIdCached;

    public ProgramIdValue(@NotNull ProgramID programId) {
        setProgramID(programId);
    }

    @Contract(pure = true)
    public ProgramID getProgramID() {
        return m_programIdCached;
    }

    public void setProgramID(@NotNull ProgramID programId) {
        super.setValue(programId.getValue());
        m_programIdCached = programId;
    }
}
