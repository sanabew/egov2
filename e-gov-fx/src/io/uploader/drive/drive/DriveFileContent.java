

package io.uploader.drive.drive;


import com.google.api.client.http.AbstractInputStreamContent;
import com.google.api.client.util.Preconditions;

import io.uploader.drive.util.FileUtils;
import io.uploader.drive.util.FileUtils.InputStreamProgressFilter;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

/**
 * Concrete implementation of {@link AbstractInputStreamContent} that generates repeatable input
 * streams based on the contents of a file.
 *
 * <p>
 * Sample use:
 * </p>
 *
 * <pre>
 * <code>
  private static void setRequestJpegContent(HttpRequest request, File jpegFile) {
    request.setContent(new FileContent("image/jpeg", jpegFile));
  }
 * </code>
 * </pre>
 *
 * <p>
 * Implementation is not thread-safe.
 * </p>
 *
 * @since 1.4
 * @author moshenko@google.com (Jacob Moshenko), Loic Merckel
 */
public final class DriveFileContent extends AbstractInputStreamContent {

  private final File file;
  private final InputStreamProgressFilter.StreamProgressCallback progressCallback ;

  /**
   * @param type Content type or {@code null} for none
   * @param file file
   * @since 1.5
   */
  public DriveFileContent(String type, File file, InputStreamProgressFilter.StreamProgressCallback progressCallback) {
    super(type);
    this.file = Preconditions.checkNotNull(file);
    this.progressCallback = progressCallback ;
  }

  public long getLength() {
    return file.length();
  }

  public boolean retrySupported() {
    return true;
  }

  @Override
  public InputStream getInputStream() throws FileNotFoundException {
	  if (progressCallback == null) {
		  return new FileInputStream(file) ;
	  } else {
		  return FileUtils.getInputStreamWithProgressFilter(progressCallback, file.length(), new FileInputStream(file)) ;
	  }
  }

  /**
   * Returns the file.
   *
   * @since 1.5
   */
  public File getFile() {
    return file;
  }

  @Override
  public DriveFileContent setType(String type) {
    return (DriveFileContent) super.setType(type);
  }

  @Override
  public DriveFileContent setCloseInputStream(boolean closeInputStream) {
    return (DriveFileContent) super.setCloseInputStream(closeInputStream);
  }
}
