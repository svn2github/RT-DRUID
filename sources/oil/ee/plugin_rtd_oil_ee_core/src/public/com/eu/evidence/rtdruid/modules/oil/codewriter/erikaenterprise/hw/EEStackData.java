package com.eu.evidence.rtdruid.modules.oil.codewriter.erikaenterprise.hw;

/**
 * This class contains some computed informations about stack.
 * 
 */
public final class EEStackData {
    final public long[] size; // = 14848;
    final public String[] baseAddressTxt;// = "0x7C000-14848";
//    final public long[] baseAddress; // =0x7C000-14848;
    /** Only up and Down */
    final public boolean directDown; // = "DOWN";
    final public int stackID; //= 5;
    
    public EEStackData(int id, long[] size, long base[], String[] baseTxt, boolean directionDown) {
    	this.stackID = id;
    	this.size = size;
//    	this.baseAddress = base;
    	this.baseAddressTxt = baseTxt;
    	this.directDown = directionDown;
    }
    public EEStackData(int id, long[] size, String[] baseTxt, boolean directionDown) {
    	this.stackID = id;
    	this.size = size;
//    	this.baseAddress = base;
    	this.baseAddressTxt = baseTxt;
    	this.directDown = directionDown;
    }

}