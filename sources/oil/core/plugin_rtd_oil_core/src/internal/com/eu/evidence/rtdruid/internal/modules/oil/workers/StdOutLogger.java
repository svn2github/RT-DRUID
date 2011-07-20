package com.eu.evidence.rtdruid.internal.modules.oil.workers;
public class StdOutLogger implements Logger {
		public void log(String txt) {
			System.out.println(txt);
		}
	};