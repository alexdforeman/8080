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
        int memLocation = (state_.getH() << _SHIFT) | state_.getL();
        state_.getMemory()[memLocation] = state_.getC();
        state_.setPc(state_.getPc() + 1);
    }
}
