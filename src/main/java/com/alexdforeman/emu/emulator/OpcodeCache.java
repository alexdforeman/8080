package com.alexdforeman.emu.emulator;

import java.util.HashMap;
import java.util.Map;

import com.alexdforeman.emu.emulator.opcodes.IOpCode;
import com.alexdforeman.emu.emulator.opcodes.OpCode06;
import com.alexdforeman.emu.emulator.opcodes.OpCode31;
import com.alexdforeman.emu.emulator.opcodes.OpCodeC3;
import com.alexdforeman.emu.emulator.opcodes.OpCodeCD;
import com.alexdforeman.emu.emulator.opcodes.OpCodeNop;

/**
 * A cache for all the Opcode implementations.
 * @author http://github.com/alexdforeman
 */
public final class OpcodeCache {

    private static final Map<Integer, IOpCode> _OPCODES = new HashMap<>();
    static {
        //CHECKSTYLE:OFF
        _OPCODES.put(0x00, new OpCodeNop());
        _OPCODES.put(0x06, new OpCode06());
        _OPCODES.put(0x31, new OpCode31());
        _OPCODES.put(0xC3, new OpCodeC3());
        _OPCODES.put(0xCD, new OpCodeCD());
        //CHECKSTYLE:OFF
    }

    private OpcodeCache() { /* No default Constructor */ }

    /**
     * Get the IOPcode for the current instruction.
     * @param instruction_ Where the state machine pc is at.
     * @return the IOpcode
     */
    public static IOpCode get(final int instruction_) {
        return _OPCODES.get(instruction_);
    }
}
