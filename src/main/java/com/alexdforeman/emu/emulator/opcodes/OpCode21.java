package com.alexdforeman.emu.emulator.opcodes;

import com.alexdforeman.emu.emulator.State;

/**
 * OpCode 0x11 is LXI H, D16.
 * Loads the H and L registers with the next 16 bits.
 * @author http://github.com/alexdforeman
 */
public class OpCode21 implements IOpCode {

    /* (non-Javadoc)
     * @see com.alexdforeman.emu.emulator.opcodes.IOpcode#exec(com.alexdforeman.emu.emulator.State)
     */
    @Override
    public final void exec(State state_) {
        int[] memory = state_.getMemory();
        int pc = state_.getPc();
        state_.setH(memory[pc + 2]);
        state_.setL(memory[pc + 1]);
        // Now increment the pc by 3
        state_.setPc(pc + _PC_INCR_3);
    }
}
