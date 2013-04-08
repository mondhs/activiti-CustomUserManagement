package org.activiti.custom.identity;

import org.activiti.engine.identity.Group;
/**
 * Custom Group implementaiton that it is not used in this sample 
 * @author mondhs
 *
 */
public class CustomGroup implements Group{

	/**
	 * 
	 */
	private static final long serialVersionUID = 7027363138258964237L;
	private String id;
	private String type;

	public CustomGroup(String id, String type) {
		this.id = id;
		this.type = type;
	}
	
	@Override
	public String getId() {
		return id;
	}

	@Override
	public void setId(String id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String getName() {
		return id;
	}

	@Override
	public void setName(String name) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String getType() {
		return this.type;
	}

	@Override
	public void setType(String string) {
		// TODO Auto-generated method stub
		
	}

}
