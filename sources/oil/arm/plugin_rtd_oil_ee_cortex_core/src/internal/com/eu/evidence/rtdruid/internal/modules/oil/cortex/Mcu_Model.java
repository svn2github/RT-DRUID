package com.eu.evidence.rtdruid.internal.modules.oil.cortex;
class Mcu_Model {
		public final String name;
		public final String model;
		public final String ee_opt;
		public final String linkerScript;
		public final String include_h;
		Mcu_Model(String name, String model, String ee_opt, String linker, String inc_h) {
			this.name = name;
			this.model = model;
			this.ee_opt = ee_opt;
			this.linkerScript = linker;
			this.include_h = inc_h;
		}
	}