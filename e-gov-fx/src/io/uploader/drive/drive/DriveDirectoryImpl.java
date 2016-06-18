
package io.uploader.drive.drive;


public class DriveDirectoryImpl implements DriveDirectory {

	private final String title ;
	private final String id  ;
	
	public DriveDirectoryImpl (String title) {
		this (title, null) ;
	}
	
	public DriveDirectoryImpl (String title, String id) {
		super () ;
		if (org.apache.commons.lang3.StringUtils.isEmpty(title)) {
			throw new IllegalArgumentException () ;
		}
		this.title = title ;
		this.id = id ;
	}
	
	public static DriveDirectoryImpl newDriveDirectory (String title, String id) {
		return new DriveDirectoryImpl (title, id) ;
	}
	
	public static DriveDirectoryImpl newDriveDirectory (String title) {
		return new DriveDirectoryImpl (title) ;
	}
	
	@Override
	public String getId() {
		return id;
	}

	@Override
	public String getTitle() {
		return title;
	}
}
