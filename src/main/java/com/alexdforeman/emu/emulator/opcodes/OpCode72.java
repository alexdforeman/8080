package com.alexdforeman.emu.emulator.opcodes;

import com.alexdforeman.emu.emulator.State;

/**
 * OpCode 0x72 MOV M,D.
 * Move D to M or the HL pair.
 * @author http://github.com/alexdforeman
 */
public class OpCode72 implements IOpCode {

    /* (non-Javadoc)
     * @see com.alexdforeman.emu.emulator.opcodes.IOpcode#exec(com.alexdforeman.emu.emulator.State)
     */
    @Override
    public final void exec(State state_) {
        int d = state_.getD();
        state_.setH((d >>> _SHIFT) & _UNSIGNED_MASK);
        state_.setL(d & _UNSIGNED_MASK);
        state_.setPc(state_.getPc() + 1);
    }
}
