package com.eu.evidence.rtdruid.modules.oil.ui.builder;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Properties;

import org.eclipse.core.resources.ICommand;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IProjectDescription;
import org.eclipse.core.runtime.CoreException;

import com.eu.evidence.rtdruid.desk.RtdruidLog;


/**
 * TODO: sistemare meglio. Lavora sui parametri del builder che pero' e' definito in un plugin che dipende da questo oggetto
 * 
 * @author Nicola Serreli
 *
 */
public class OilBuilderParameters {
	
	// TODO: this should be not used 
	private final static String OIL_BUILDER_ID = "com.eu.evidence.rtdruid.oil.cdt.ui.oil_builder"; 

	protected final IProject project;
	
	public OilBuilderParameters(IProject prj) {
		project = prj;
	}
	
	public boolean canSave() {
		return getOilBuilderCommand() != null;
	}
	
	
	public void getParameters(Properties storage) {
		ICommand command = getOilBuilderCommand();
		if (command != null) {
			Map<String,String> args = command.getArguments();
			if (args != null) {
				storage.putAll(args);
			}
		}
	}

	/**
	 * This function remove all keys in remove list from project parameters
	 * before add all parameters specified in storage list
	 * 
	 * @param storage
	 * @param remove
	 */
	public void setParameters(Properties storage, List<String> remove) {
		ICommand command = getOilBuilderCommand();
		if (command != null) {
			Map<String,String> args = command.getArguments();
			if (args == null) {
				args = new HashMap<String,String>();
			}
			
			if (remove != null) {
				for (String key: remove) {
					args.remove(key);
				}
			}

			if (storage != null) {
				for (Entry<Object, Object> entry: storage.entrySet()) {
					Object key = entry.getKey();
					Object value = entry.getValue();
					if (key instanceof String && value instanceof String) {
						args.put((String) key, (String) value);
					}
				}
			}

			command.setArguments(args);
			setOilBuilderCommand(command);
		}
		
	}
	
	/**
	 * 
	 * @return the OilBuilder command, or null if not found
	 */
	protected ICommand getOilBuilderCommand() {
		
		ICommand answer = null;
        if (project != null && project.isOpen()) {
        	IProjectDescription description;
			try {
				description = project.getDescription();
			} catch (CoreException e) {
				RtdruidLog.log(e);
				return answer; // exit
			}
			
    		ICommand[] commands = description.getBuildSpec();
    		for (int i = 0; i < commands.length; ++i) {
    			if (commands[i].getBuilderName().equals(OIL_BUILDER_ID)) {
    				answer = commands[i];
    			}
    		}
        }
        return answer;
	}
	
	/**
	 * Update the Builder command in the build spec (replace existing one if
	 * present, add one first if none).
	 */
	protected void setOilBuilderCommand(ICommand newCommand) {

        if (project != null && project.isOpen()) {
	
			IProjectDescription description;
			try {
				description = project.getDescription();
			} catch (CoreException e) {
				RtdruidLog.log(e);
				return;
			}
			ICommand[] oldCommands = description.getBuildSpec();
	
			if (oldCommands != null) {
				boolean found = false;
					
				for (int i = 0, max = oldCommands.length; i < max && !found; i++) {
					if (oldCommands[i].getBuilderName().equals(
							newCommand.getBuilderName())) {
						oldCommands[i] = newCommand;
						found = true;;
					}
				}
		
				if (found) {
					// Commit the spec change into the project
					description.setBuildSpec(oldCommands);
					try {
						project.setDescription(description, null);
					} catch (CoreException e) {
						RtdruidLog.log(e);
						return;
					}
				}
			}
        }
	}

}
