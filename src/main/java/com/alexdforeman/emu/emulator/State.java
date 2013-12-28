package com.alexdforeman.emu.emulator;

/**
 * The State of the program.
 * @author http://github.com/alexdforeman
 */
public class State {

    private int _a; // should be a byte
    private int _b; // should be a byte
    private int _c; // should be a byte
    private int _d; // should be a byte
    private int _e; // should be a byte
    private int _h; // should be a byte
    private int _l; // should be a byte
    private int _sp; // should be a byte
    private int _pc; // should be a byte
    private int[] _memory; // should be byte array

    /**
     * Constructor.
     * @param memory_ int[]
     */
    public State(int[] memory_) {
        _memory = memory_.clone();
    }

    /**
     * Getter.
     * @return int
     */
    public final int getA() {
        return _a;
    }
    /**
     * Setter.
     * @param a_ int
     */
    public final void setA(int a_) {
        _a = a_;
    }
    /**
     * Getter.
     * @return int
     */
    public final int getB() {
        return _b;
    }
    /**
     * Setter.
     * @param b_ int
     */
    public final void setB(int b_) {
        _b = b_;
    }
    /**
     * Getter.
     * @return int
     */
    public final int getC() {
        return _c;
    }
    /**
     * Setter.
     * @param c_ int
     */
    public final void setC(int c_) {
        _c = c_;
    }
    /**
     * Getter.
     * @return int
     */
    public final int getD() {
        return _d;
    }
    /**
     * Setter.
     * @param d_ int
     */
    public final void setD(int d_) {
        _d = d_;
    }
    /**
     * Getter.
     * @return int
     */
    public final int getE() {
        return _e;
    }
    /**
     * Setter.
     * @param e_ int
     */
    public final void setE(int e_) {
        _e = e_;
    }
    /**
     * Getter.
     * @return int
     */
    public final int getH() {
        return _h;
    }
    /**
     * Setter.
     * @param h_ int
     */
    public final void setH(int h_) {
        _h = h_;
    }
    /**
     * Getter.
     * @return int
     */
    public final int getL() {
        return _l;
    }
    /**
     * Setter.
     * @param l_ int
     */
    public final void setL(int l_) {
        _l = l_;
    }
    /**
     * Getter.
     * @return int
     */
    public final int getSp() {
        return _sp;
    }
    /**
     * Setter.
     * @param sp_ int
     */
    public final void setSp(int sp_) {
        _sp = sp_;
    }
    /**
     * Getter.
     * @return int
     */
    public final int getPc() {
        return _pc;
    }
    /**
     * Setter.
     * @param pc_ int
     */
    public final void setPc(int pc_) {
        _pc = pc_;
    }
    /**
     * Getter.
     * @return int[]
     */
    //CHECKSTYLE:OFF
    public final int[] getMemory() {
        return _memory;
    }
    //CHECKSTYLE:ON
    /**
     * Setter.
     * @param memory_ int[]
     */
    public final void setMemory(int[] memory_) {
        _memory = memory_.clone();
    }
}
