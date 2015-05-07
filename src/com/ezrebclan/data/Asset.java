package com.ezrebclan.data;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

import org.json.JSONObject;

public abstract class Asset<Type> extends Data {

	private static final long serialVersionUID = 4823876572849305809L;
	private AssetIndex index;
	private Type data;
	
	@Override
	public void load(InputStream loadFrom) throws IOException {
		ZipInputStream zipIS = new ZipInputStream(loadFrom);
		ZipEntry entry1 = zipIS.getNextEntry();
		if(entry1.getName().equals("index.json")) {
			index = loadIndex(zipIS);
			zipIS.closeEntry();
			zipIS.getNextEntry();
			data = loadAsset(zipIS);
		} else {
			data = loadAsset(zipIS);
			zipIS.closeEntry();
			zipIS.getNextEntry();
			index = loadIndex(zipIS);
		}
		zipIS.closeEntry();
		zipIS.close();
		System.out.println(loadFrom.read());
	}
	
	protected AssetIndex loadIndex(ZipInputStream compressed) throws IOException {
		AssetIndex ret;
		BufferedReader br = new BufferedReader(new InputStreamReader(compressed));
		String raw = br.readLine();
		JSONObject json  = new JSONObject(raw);
		ret = new AssetIndex(json);
		return ret;
	}
	
	protected abstract Type loadAsset(InputStream in);

	public AssetIndex getIndex() {
		return index;
	}

	public void setIndex(AssetIndex index) {
		this.index = index;
	}

	public Type getData() {
		return data;
	}

	public void setData(Type data) {
		this.data = data;
	}
	
}
