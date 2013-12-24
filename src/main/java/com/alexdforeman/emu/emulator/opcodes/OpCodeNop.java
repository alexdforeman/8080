package com.alexdforeman.emu.emulator.opcodes;

import com.alexdforeman.emu.emulator.State;

/**
 * This is a NOP.
 * @author http://github.com/alexdforeman
 */
public class OpCodeNop implements IOpCode {

    /* (non-Javadoc)
     * @see com.alexdforeman.emu.emulator.IOpcode#exec(com.alexdforeman.emu.emulator.State)
     */
    @Override
    public final void exec(State state_) {
        // NOP Just advance.
        state_.setPc(state_.getPc() + 1);
    }
}
