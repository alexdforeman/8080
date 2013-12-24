package com.alexdforeman.emu.emulator.opcodes;

import com.alexdforeman.emu.emulator.State;

/**
 * OpCode 0xC3 is JMP adr.
 * Takes next two bytes as the Address to jump to.
 * pc <= adr.
 * @author http://github.com/alexdforeman
 */
public class OpCodeC3 implements IOpCode {

    private static final int _SHIFT = 8;

    /* (non-Javadoc)
     * @see com.alexdforeman.emu.emulator.opcodes.IOpcode#exec(com.alexdforeman.emu.emulator.State)
     */
    @Override
    public final void exec(State state_) {
        int[] memory = state_.getMemory();
        int pc = state_.getPc();
        int byte1 = memory[pc + 1];
        int byte2 = memory[pc + 2];
        int result = (byte2 << _SHIFT) | byte1;
        state_.setPc(result);
    }
}
