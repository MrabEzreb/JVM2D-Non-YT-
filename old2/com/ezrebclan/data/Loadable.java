package com.ezrebclan.data;

import java.io.IOException;
import java.io.InputStream;

public interface Loadable {

	public void load(InputStream loadFrom) throws IOException;
}
