package com.ezrebclan.data;

import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONString;

public class AssetIndex implements JSONString {

	public AssetIndex(JSONObject source) {
		name = source.getString("name");
		details = new String[source.getJSONArray("details").length()];
		for (int i = 0; i < source.getJSONArray("details").length(); i++) {
			details[i] = source.getJSONArray("details").getString(i);
		}
		storedName = source.getString("storedName");
		
	}
	public AssetIndex() {}
	private String name;
	private String[] details;
	private String storedName;
	
	@Override
	public String toJSONString() {
		JSONObject retVal = new JSONObject();
		retVal.put("name", name);
		retVal.put("details", new JSONArray(details));
		retVal.put("storedName", storedName);
		return retVal.toString();
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String[] getDetails() {
		return details;
	}
	public void setDetails(String[] details) {
		this.details = details;
	}
	public String getStoredName() {
		return storedName;
	}
	public void setStoredName(String storedName) {
		this.storedName = storedName;
	}
}
