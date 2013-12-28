package com.alexdforeman.emu.emulator.opcodes;

import com.alexdforeman.emu.emulator.State;

/**
 * OpCode 0x74 MOV M,H.
 * Move H to M or the HL pair.
 * @author http://github.com/alexdforeman
 */
public class OpCode74 implements IOpCode {

    /* (non-Javadoc)
     * @see com.alexdforeman.emu.emulator.opcodes.IOpcode#exec(com.alexdforeman.emu.emulator.State)
     */
    @Override
    public final void exec(State state_) {
        int h = state_.getH();
        state_.setH((h >>> _SHIFT) & _UNSIGNED_MASK);
        state_.setL(h & _UNSIGNED_MASK);
        state_.setPc(state_.getPc() + 1);
    }
}
