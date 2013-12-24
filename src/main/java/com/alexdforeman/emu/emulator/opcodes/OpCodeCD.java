package com.alexdforeman.emu.emulator.opcodes;

import com.alexdforeman.emu.emulator.State;

/**
 * OpCode 0xCD is CALL adr
 * Stores current place then Calls memory location requested.
 * (SP-1)<-PC.hi;(SP-2)<-PC.lo;SP<-SP+2;PC=adr
 * @author http://github.com/alexdforeman
 */
public class OpCodeCD implements IOpCode {

    /* (non-Javadoc)
     * @see com.alexdforeman.emu.emulator.opcodes.IOpcode#exec(com.alexdforeman.emu.emulator.State)
     */
    @Override
    public final void exec(State state_) {

        final int[] memory = state_.getMemory();

        final int pc = state_.getPc();

        // Prime the stack
        final int ret = pc + 2; // We need to return to the instruction 2 ahead.
        final int sp = state_.getSp();
        memory[sp - 1] = (ret >>> _SHIFT) & _UNSIGNED_MASK;
        memory[sp - 2] = (ret & _UNSIGNED_MASK);
        state_.setSp(sp - 2);

        // Now go to the called location.
        int byte1 = memory[pc + 1];
        int byte2 = memory[pc + 2];
        state_.setPc((byte2 << _SHIFT) | byte1);
    }
}

