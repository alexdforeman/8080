package com.alexdforeman.emu.emulator.opcodes;

import com.alexdforeman.emu.emulator.State;

/**
 * OpCode 0x70 MOV M,B.
 * Move A to M or the HL pair.
 * @author http://github.com/alexdforeman
 */
public class OpCode70 implements IOpCode {

    /* (non-Javadoc)
     * @see com.alexdforeman.emu.emulator.opcodes.IOpcode#exec(com.alexdforeman.emu.emulator.State)
     */
    @Override
    public final void exec(State state_) {
        int b = state_.getB();
        state_.setH((b >>> _SHIFT) & _UNSIGNED_MASK);
        state_.setL(b & _UNSIGNED_MASK);
        state_.setPc(state_.getPc() + 1);
    }
}
