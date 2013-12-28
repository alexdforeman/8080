package com.alexdforeman.emu.emulator.opcodes;

import com.alexdforeman.emu.emulator.State;

/**
 * OpCode 0x11 is LXI D, D16.
 * Loads the D and E registers with the next 16 bits.
 * @author http://github.com/alexdforeman
 */
public class OpCode11 implements IOpCode {

    /* (non-Javadoc)
     * @see com.alexdforeman.emu.emulator.opcodes.IOpcode#exec(com.alexdforeman.emu.emulator.State)
     */
    @Override
    public final void exec(State state_) {
        int[] memory = state_.getMemory();
        int pc = state_.getPc();
        state_.setD(memory[pc + 2]);
        state_.setE(memory[pc + 1]);
        // Now increment the pc by 3
        state_.setPc(pc + _PC_INCR_3);
    }
}
