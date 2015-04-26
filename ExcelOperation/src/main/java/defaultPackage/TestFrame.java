package defaultPackage;
import java.awt.Frame;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class TestFrame extends Frame {
	public TestFrame() {
	}

	/**
	 * 
	 */

	private static final long serialVersionUID = 1L;

	public static void main(String args[]) {
		TestFrame testFrame = new TestFrame();
		testFrame.setVisible(true);
		testFrame.setSize(800, 600);
		testFrame.setResizable(false);
		testFrame.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
		MenuUp testMenu = new MenuUp();
		testFrame.setMenuBar(testMenu);
	}
}
