package com.alexdforeman.emu.emulator.opcodes;

import com.alexdforeman.emu.emulator.State;

/**
 * OpCode 0x71 MOV M,C.
 * Move C to M or the HL pair.
 * @author http://github.com/alexdforeman
 */
public class OpCode71 implements IOpCode {

    /* (non-Javadoc)
     * @see com.alexdforeman.emu.emulator.opcodes.IOpcode#exec(com.alexdforeman.emu.emulator.State)
     */
    @Override
    public final void exec(State state_) {
        int c = state_.getC();
        state_.setH((c >>> _SHIFT) & _UNSIGNED_MASK);
        state_.setL(c & _UNSIGNED_MASK);
        state_.setPc(state_.getPc() + 1);
    }
}
