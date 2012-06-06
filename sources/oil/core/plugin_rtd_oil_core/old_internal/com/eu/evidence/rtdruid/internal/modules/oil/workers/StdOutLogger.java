package com.eu.evidence.rtdruid.internal.modules.oil.workers;

import com.eu.evidence.rtdruid.desk.Logger;

public class StdOutLogger implements Logger {
		public void log(String txt) {
			System.out.println(txt);
		}
	};