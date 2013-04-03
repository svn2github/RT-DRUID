package com.eu.evidence.rtdruid.internal.modules.oil.workers;

import com.eu.evidence.rtdruid.desk.Logger;
import com.eu.evidence.rtdruid.desk.Messages;

public class StdOutLogger implements Logger {
		public void log(String txt) {
			if (Messages.LogLevel.info.enabled()) {
				System.out.println(txt);
			}
		}
	};