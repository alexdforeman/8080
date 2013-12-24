package com.alexdforeman.emu.emulator.opcodes;

import com.alexdforeman.emu.emulator.State;

/**
 * OpCode 0x06 is MVI B, D8
 * Loads the B register with the next byte.
 * @author http://github.com/alexdforeman
 */
public class OpCode06 implements IOpCode {

    /* (non-Javadoc)
     * @see com.alexdforeman.emu.emulator.opcodes.IOpcode#exec(com.alexdforeman.emu.emulator.State)
     */
    @Override
    public final void exec(State state_) {
        int[] memory = state_.getMemory();
        int pc = state_.getPc();
        int result = memory[pc + 1];
        state_.setB(result);
        state_.setPc(pc + _PC_INCR_2);
    }
}
