package com.ezrebclan.data;

import java.io.Serializable;

import org.json.JSONString;

public abstract class Data implements JSONString, Serializable, Saveable, Loadable {

	private static final long serialVersionUID = -5084702468682234931L;

}
