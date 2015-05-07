package com.ezrebclan.dataManagement;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class AssetPackage {


	public AssetPackage(File archive) throws IOException, FileNotFoundException {
		archive.createNewFile();
		zos = new ZipOutputStream(new FileOutputStream(archive));
		Runtime.getRuntime().addShutdownHook(new Thread(new Runnable() {
			
			@Override
			public void run() {
				AssetPackage.this.finish();
			}
		}));
	}
	private ZipOutputStream zos;
	public final void addAsset(Asset<?> asset) throws IOException {
		zos.putNextEntry(new ZipEntry(asset.getIndex().getName()+".asset"));
		asset.writeToStream(zos);
		zos.closeEntry();
		zos.flush();
	}
	public void finish() {
		try {
			zos.flush();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		try {
			zos.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
//	public final FileOutputStream exportPackToFile(File file) throws FileNotFoundException {
//		FileOutputStream fos = new FileOutputStream(file);
//		ZipOutputStream zos = new ZipOutputStream(fos);
//		return fos;
//	}
}
