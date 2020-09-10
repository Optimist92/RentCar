package org.gocar.ui;

import java.util.LinkedHashMap;
import java.util.Map;

import org.gocar.Factory;
import org.gocar.logic.LogicException;

public class CommandManager implements Command, AutoCloseable{
	private Factory factory = new Factory();
	private Map<String, Command> commands = new LinkedHashMap<>();
	
	/*public CommandManager() throws LogicException{
		commands.put("help", this);
		commands.put("list", factory.getProductListCommand());
		commands.put("save", factory.getProductSaveCommand());
		commands.put("delete", factory.getProductDeleteCommand());
		commands.put("exit", new ExitCommand());
	}*/

	@Override
	public void close() throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean exec(String[] args) {
		// TODO Auto-generated method stub
		return false;
	}
	
}
