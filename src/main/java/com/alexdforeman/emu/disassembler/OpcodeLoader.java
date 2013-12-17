package com.alexdforeman.emu.disassembler;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.Map;

/**
 * Loads the opcodes from hard data opcodes.
 * @author http://github.com/alexdforeman
 */
public final class OpcodeLoader {

    private OpcodeLoader() { /* No default Constructor */ }

	private static final int _OPCODE_LOC = 0;
	private static final int _INSTR_LOC = 1;
	private static final int _SIZE_LOC = 2;
	private static final int _FLAGS_LOC = 3;
	private static final int _FUNCTION_LOC = 4;

	/**
	 * Grabs the opcodes.
	 * @param stream_ an InputStream
	 * @return Map<Integer, Opcode>
	 * @throws IOException if something goes wrong
	 */
	public static Map<Integer, Opcode> getOpcodes(final InputStream stream_) throws IOException {

		final Map<Integer, Opcode> opcodes = new HashMap<Integer, Opcode>(256, 1f);

		try (BufferedReader br = new BufferedReader(new InputStreamReader(stream_, Charset.forName("UTF-8")))) {

		    for (String line; (line = br.readLine()) != null;) {
		    	String[] split = line.split(":");
		    	final Integer opcode = Integer.decode(split[_OPCODE_LOC]);
		    	opcodes.put(opcode, new Opcode(opcode,
		    			split[_INSTR_LOC],
		    			split[_SIZE_LOC],
		    			split[_FLAGS_LOC],
		    			split[_FUNCTION_LOC]));
		    }
		}
		return opcodes;
	}
}
