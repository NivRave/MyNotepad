package OnclickFunctions;

import java.awt.FileDialog;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;

import Window.MyJFrame;

public class FileFunctions {

	MyJFrame window;
	String fileName;
	String filePath;

	public FileFunctions(MyJFrame window) {
		this.window = window;
	}

	public void newFile() {
		window.getPanel().clear();
		window.setTitle("New File (Unsaved)");
		fileName = null;
		filePath = null;
	}

	@SuppressWarnings("static-access")
	public void openFile() {
		FileDialog fileDialog = new FileDialog(window, "Open", FileDialog.LOAD);
		fileDialog.setVisible(true);

		if (fileDialog.getFile() != null) {
			fileName = fileDialog.getFile();
			filePath = fileDialog.getDirectory();
			window.setTitle(fileName);
		}
		try {
			BufferedReader bufferReader = new BufferedReader(new FileReader(filePath + fileName));
			window.getPanel().clear();
			String line;

			while ((line = bufferReader.readLine()) != null) {
				window.getPanel().append(line + "\n");
			}
			bufferReader.close();
		} catch (Exception e) {
			// CREATE SPECIAL EXCEPTION
		}
	}

	@SuppressWarnings("static-access")
	public void saveFile() {
		if (fileName != null) {
			try {
				System.out.println(filePath + fileName);
				FileWriter fileWriter = new FileWriter(filePath + fileName);
				fileWriter.write(window.getPanel().getText());
				fileWriter.close();
			} catch (Exception e) {
				// CREATE SPECIAL EXCEPTION
			}
		} else {
			saveFileAs();
		}
	}

	@SuppressWarnings("static-access")
	public void saveFileAs() {
		FileDialog fileDialog = new FileDialog(window, "Save", FileDialog.SAVE);
		fileDialog.setVisible(true);

		if (fileDialog.getFile() != null) {
			fileName = fileDialog.getFile();
			filePath = fileDialog.getDirectory();
			window.setTitle(fileName);
		}
		try {
			FileWriter fileWriter = new FileWriter(filePath + fileName + ".txt");
			fileWriter.write(window.getPanel().getText());
			fileWriter.close();
		} catch (Exception e) {
			// CREATE SPECIAL EXCEPTION
		}
	}

	public void exit() {
		System.exit(0);
	}
}