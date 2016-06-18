
package io.uploader.drive.gui.factory;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.cell.ProgressBarTableCell;
import javafx.util.Callback;

public class CellDriveTaskProgressFactory <S, T> implements Callback<TableColumn<S, T>, TableCell<S, T>> {

	private static final Logger logger = LoggerFactory.getLogger(CellDriveTaskProgressFactory.class);
	
	// http://stackoverflow.com/questions/16721380/javafx-update-progressbar-in-tableview-from-task
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public TableCell<S, T> call(final TableColumn<S, T> arg0) {

		logger.info("Cell factory");
		return new ProgressBarTableCell () ;
	}
	
	

}
