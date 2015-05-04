package com.ezrebclan.dataManagement;

import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONString;

public class AssetIndex implements JSONString {

	private String name;
	private String[] details;
	private String storedName;
	
	private JSONObject serialize() {
		JSONObject retVal = new JSONObject();
		retVal.put("name", name);
		retVal.put("details", new JSONArray(details));
		retVal.put("storedName", storedName);
		return retVal;
	}

	@Override
	public String toJSONString() {
		return serialize().toString();
	}
	
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return the details
	 */
	public String[] getDetails() {
		return details;
	}
	/**
	 * @param details the details to set
	 */
	public void setDetails(String[] details) {
		this.details = details;
	}
	/**
	 * @return the storedName
	 */
	public String getStoredName() {
		return storedName;
	}
	/**
	 * @param storedName the storedName to set
	 */
	public void setStoredName(String storedName) {
		this.storedName = storedName;
	}
}
