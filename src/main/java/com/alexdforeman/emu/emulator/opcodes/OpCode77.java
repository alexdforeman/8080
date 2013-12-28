package com.alexdforeman.emu.emulator.opcodes;

import com.alexdforeman.emu.emulator.State;

/**
 * OpCode 0x77 MOV M,A.
 * Move A to M or the HL pair.
 * @author http://github.com/alexdforeman
 */
public class OpCode77 implements IOpCode {

    /* (non-Javadoc)
     * @see com.alexdforeman.emu.emulator.opcodes.IOpcode#exec(com.alexdforeman.emu.emulator.State)
     */
    @Override
    public final void exec(State state_) {
        int a = state_.getA();
        state_.setH((a >>> _SHIFT) & _UNSIGNED_MASK);
        state_.setL(a & _UNSIGNED_MASK);
        state_.setPc(state_.getPc() + 1);
    }
}
