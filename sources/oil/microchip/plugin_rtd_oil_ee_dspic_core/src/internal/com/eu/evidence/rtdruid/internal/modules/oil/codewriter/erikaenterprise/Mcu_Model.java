package com.eu.evidence.rtdruid.internal.modules.oil.codewriter.erikaenterprise;
class Mcu_Model {
		public final String name;
		public final String model;
		public final String ee_opt;
		public final String linkerScript;
		public final String dev_lib;
		public final String include_c;
		public final String include_s;
		Mcu_Model(String name, String model, String ee_opt, String linker, String dev, String inc_c, String inc_s) {
			this.name = name;
			this.model = model;
			this.ee_opt = ee_opt;
			this.linkerScript = linker;
			this.dev_lib = dev;
			this.include_c = inc_c;
			this.include_s = inc_s;
		}
	}