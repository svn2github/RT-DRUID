package com.eu.evidence.rtdruid.vartree.tools;

import java.util.ArrayList;

public interface ITaskUtility {

	public abstract void removeTasks(ArrayList<String> names);

	public abstract void createTasks(ArrayList<String> names);

	public abstract void createTask(String name);

}