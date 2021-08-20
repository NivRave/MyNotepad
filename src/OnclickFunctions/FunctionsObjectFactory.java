package OnclickFunctions;

import Window.MyJFrame;

public class FunctionsObjectFactory {

	// Get the desired functions object
	public FunctionsObject getObject(String type, MyJFrame window) {
		if (type == null) {
			return null;
		} else if (type.equalsIgnoreCase("FILE")) {
			return new FileFunctions(window);
		} else if (type.equalsIgnoreCase("EDIT")) {
			return new EditFunctions(window);
		} else if (type.equalsIgnoreCase("FORMAT")) {
			return new FormatFunctions(window);
		} else if (type.equalsIgnoreCase("VIEW")) {
			return new ViewFunctions(window);
		}
		return null;
	}
}
