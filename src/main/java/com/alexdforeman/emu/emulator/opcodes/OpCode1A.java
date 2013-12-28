package com.alexdforeman.emu.emulator.opcodes;

import com.alexdforeman.emu.emulator.State;

/**
 * OpCode 0x1A is LDAX D.
 * Copies D&E pair into Accumulator.
 * A <- (DE)
 * @author http://github.com/alexdforeman
 */
public class OpCode1A implements IOpCode {

    /* (non-Javadoc)
     * @see com.alexdforeman.emu.emulator.opcodes.IOpcode#exec(com.alexdforeman.emu.emulator.State)
     */
    @Override
    public final void exec(State state_) {
        state_.setA((state_.getD() << _SHIFT) | state_.getE());
        state_.setPc(state_.getPc() + 1);
    }
}
