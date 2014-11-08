package worldTakeOver;

import org.eclipse.swt.*;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.RowLayout;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.SWT;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.eclipse.swt.widgets.DateTime;

public class MainInterface {

	protected Shell shell;
	private final FormToolkit formToolkit = new FormToolkit(Display.getDefault());

	
	

	/**
	 * Open the window.
	 */
	public void open() {
		Display display = Display.getDefault();
		createContents();

		shell.open();
		shell.layout();
		DateTime calendar = new DateTime (shell, SWT.CALENDAR);
		DateTime time = new DateTime (shell, SWT.TIME);
		
		
		
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}

	/**
	 * Create contents of the window.
	 */
	protected void createContents() {
		shell = new Shell();
		shell.setSize(450, 300);
		shell.setText("SWT Application");

	}

	/**
	 * Launch the application.
	 * @param args
	 */
	
	/*
	public static void main(String[] args) {
		try {
			MainInterface window = new MainInterface();
			window.open();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	*/
	
	public static void main (String [] args) {
		Display display = new Display ();
		Shell shell = new Shell (display);
		shell.setLayout (new RowLayout ());
		shell.setSize(600, 300);
		DateTime calendar = new DateTime (shell, SWT.CALENDAR);
		calendar.addSelectionListener (new SelectionAdapter () {
			@Override
			public void widgetSelected (SelectionEvent e) {
				System.out.println ("calendar date changed");
			}
		});

		DateTime time = new DateTime (shell, SWT.TIME);
		time.addSelectionListener (new SelectionAdapter () {
			@Override
			public void widgetSelected (SelectionEvent e) {
				System.out.println ("time changed");
			}
		});

		shell.pack ();
		shell.open ();
		while (!shell.isDisposed ()) {
			if (!display.readAndDispatch ()) display.sleep ();
		}
		display.dispose ();
	}
}
