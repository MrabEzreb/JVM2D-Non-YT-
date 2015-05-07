package com.ezrebclan.dataManagement;

import java.io.IOException;
import java.io.OutputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public abstract class Asset<Type> {

	protected Type data;
	
	public final void writeToStream(OutputStream stream) throws IOException {
		ZipOutputStream zos = new ZipOutputStream(stream);
		zos.putNextEntry(new ZipEntry(getIndex().getStoredName()));
		writeData(zos);
		zos.flush();
		zos.closeEntry();
		zos.flush();
		zos.putNextEntry(new ZipEntry("index.json"));
		zos.write(getIndex().toJSONString().getBytes());
		zos.closeEntry();
		zos.finish();
	}
	/**
	 * Subclasses of Asset should use this method to write the contained data to an outputstream.
	 * This method is called during export after the index has been exported.
	 */
	protected abstract void writeData(OutputStream stream);
	
	/**
	 * Subclasses of Asset should override this method to return the "index" of the asset.
	 * The index of an asset would include things such as:
	 * <ul>
	 * <li>The name of the asset</li>
	 * <li>Specific details about the asset</li>
	 * <li>The name of the asset in the asset file</li>
	 * </ul>
	 * @return an AssetIndex to be used as the index.
	 */
	protected abstract AssetIndex getIndex();
}
