package com.ezrebclan;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

import com.ezrebclan.dataManagement.Asset;
import com.ezrebclan.dataManagement.AssetIndex;
import com.ezrebclan.dataManagement.AssetPackage;

public class Main {

	public static void main(String[] args) {
		Asset<Object> asset = new Asset<Object>() {
			
			@Override
			protected void writeData(OutputStream stream) {
				try {
					stream.write(new byte[] {5});
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			
			@Override
			protected AssetIndex getIndex() {
				AssetIndex ai = new AssetIndex();
				ai.setDetails(new String[]{""});
				ai.setName("test");
				ai.setStoredName("testy");
				return ai;
			}
		};
		Asset<Object> asset2 = new Asset<Object>() {
			
			@Override
			protected void writeData(OutputStream stream) {
				try {
					stream.write(new byte[] {6});
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			
			@Override
			protected AssetIndex getIndex() {
				AssetIndex ai = new AssetIndex();
				ai.setDetails(new String[]{"2"});
				ai.setName("test2");
				ai.setStoredName("testy2");
				return ai;
			}
		};
		File asset1 = new File("asset1.asset");
		try {
			asset1.createNewFile();
		} catch (IOException e2) {
			e2.printStackTrace();
		}
		try {
			asset.writeToStream(new FileOutputStream(asset1));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		File assets = new File("assets.assetpack");
		try {
			assets.createNewFile();
		} catch (IOException e2) {
			e2.printStackTrace();
		}
		AssetPackage ap = null;
		try {
			ap = new AssetPackage(assets);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		try {
			ap.addAsset(asset);
		} catch (IOException e) {
			e.printStackTrace();
		}
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		try {
			ap.addAsset(asset2);
		} catch (IOException e) {
			e.printStackTrace();
		}
//		ap.finish();
//		String[] names = JSONObject.getNames(asset);
//		for (String string : names) {
//			System.out.println(string);
//		}
	}

}
