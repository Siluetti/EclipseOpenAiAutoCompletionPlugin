package openaiautocompletion;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.jdt.ui.text.java.ContentAssistInvocationContext;
import org.eclipse.jdt.ui.text.java.IJavaCompletionProposalComputer;
import org.eclipse.jface.text.BadLocationException;
import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.text.ITextSelection;
import org.eclipse.jface.text.contentassist.CompletionProposal;
import org.eclipse.jface.text.contentassist.ICompletionProposal;
import org.eclipse.jface.text.contentassist.IContextInformation;
import org.eclipse.swt.custom.StyledText;
import org.eclipse.swt.events.KeyEvent;
import org.eclipse.swt.events.KeyListener;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IStartup;
import org.eclipse.ui.IWindowListener;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.eclipse.ui.texteditor.AbstractTextEditor;
import org.eclipse.ui.texteditor.IDocumentProvider;
import org.eclipse.ui.texteditor.ITextEditor;
import org.osgi.framework.BundleContext;

/**
 * The activator class controls the plug-in life cycle
 */
public class Activator extends AbstractUIPlugin implements IJavaCompletionProposalComputer, IStartup {

	// The plug-in ID
	public static final String PLUGIN_ID = "OpenAiAutoCompletion"; //$NON-NLS-1$

	// The shared instance
	private static Activator plugin;

	/**
	 * The constructor
	 */
	public Activator() {
	}

	@Override
	public List<ICompletionProposal> computeCompletionProposals(ContentAssistInvocationContext context,	IProgressMonitor monitor) {
		List<ICompletionProposal> proposals = new ArrayList<ICompletionProposal>();

		proposals.add(new CompletionProposal("codeandme.blogspot.com", context.getInvocationOffset(), 0, "codeandme.blogspot.com".length()));
		proposals.add(new CompletionProposal("<your proposal here>", context.getInvocationOffset(), 0, "<your proposal here>".length()));

		return proposals;
	}

	@Override
	public void start(BundleContext context) throws Exception {
		super.start(context);
		plugin = this;
	}

	@Override
	public void stop(BundleContext context) throws Exception {
		plugin = null;
		super.stop(context);
	}

	/**
	 * Returns the shared instance
	 *
	 * @return the shared instance
	 */
	public static Activator getDefault() {
		return plugin;
	}

	@Override
	public List<IContextInformation> computeContextInformation(ContentAssistInvocationContext arg0,
			IProgressMonitor arg1) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getErrorMessage() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void sessionEnded() {
		// TODO Auto-generated method stub

	}

	@Override
	public void sessionStarted() {
		// TODO Auto-generated method stub

	}
	
	@Override
	public void earlyStartup() {
		System.out.println("Starting up\n\n=================================\\n\\n=================================\\n\\n=================================\\n\\n=================================\\n\\n=================================Starting up\\n\\n=================================\\n\\n=================================\\n\\n=================================");
		IWorkbench wb = PlatformUI.getWorkbench();
		wb.addWindowListener(generateWindowListener());
	}

	private IWindowListener generateWindowListener() 
	{
		System.out.println("Generating window listener \n\n=================================\\n\\n=================================\\n\\n=================================\\n\\n=================================\\n\\n=================================Starting up\\n\\n=================================\\n\\n=================================\\n\\n=================================");
		return new IWindowListener() {
			@Override
			public void windowOpened(IWorkbenchWindow window) {
				System.out.println("Window opened \n\n=================================\\n\\n=================================\\n\\n=================================\\n\\n=================================\\n\\n=================================Starting up\\n\\n=================================\\n\\n=================================\\n\\n=================================");
				addKeylistenerToWindow(window);
			}

			@Override
			public void windowDeactivated(IWorkbenchWindow window) {
				System.out.println("Window windowDeactivated \n\n=================================\\n\\n=================================\\n\\n=================================\\n\\n=================================\\n\\n=================================Starting up\\n\\n=================================\\n\\n=================================\\n\\n=================================");
				//	            IWorkbenchPage activePage = window.getActivePage(); 
				//	            activePage.removePartListener(generateIPartListener2());
			}

			@Override
			public void windowClosed(IWorkbenchWindow window) {
				System.out.println("Window windowClosed \n\n=================================\\n\\n=================================\\n\\n=================================\\n\\n=================================\\n\\n=================================Starting up\\n\\n=================================\\n\\n=================================\\n\\n=================================");
				//	            IWorkbenchPage activePage = window.getActivePage(); 
				//	            activePage.removePartListener(generateIPartListener2());

			}

			@Override
			public void windowActivated(IWorkbenchWindow window) {
				System.out.println("Window windowActivated \n\n=================================\\n\\n=================================\\n\\n=================================\\n\\n=================================\\n\\n=================================Starting up\\n\\n=================================\\n\\n=================================\\n\\n=================================");
				addKeylistenerToWindow(window);

			}

			private void addKeylistenerToWindow(IWorkbenchWindow window) {
				IWorkbenchPage activePage = window.getActivePage();
				final IEditorPart iep = activePage.getActiveEditor();
				if (!(iep instanceof ITextEditor)) return;
				ITextEditor editor = (ITextEditor)iep;
				((StyledText)editor.getAdapter(org.eclipse.swt.widgets.Control.class)).addKeyListener(new KeyListener() {

					@Override
					public void keyReleased(KeyEvent e) {
						System.out.println("key release ");

						IWorkbench wb = PlatformUI.getWorkbench();
						IWorkbenchWindow win = wb.getActiveWorkbenchWindow();
						IWorkbenchPage page = win.getActivePage();

						IEditorPart part = page.getActiveEditor();
						if (!(part instanceof AbstractTextEditor))
							return;
						ITextEditor editor = (ITextEditor)part;
						
						// get cursor location
						IDocumentProvider provider = editor.getDocumentProvider();
						IDocument document = provider.getDocument(part.getEditorInput());
						ITextSelection textSelection = (ITextSelection) part.getSite().getSelectionProvider().getSelection();
						int start = textSelection.getStartLine();
						int end = textSelection.getEndLine();
						int offset = textSelection.getOffset();
						try {
							int lineNumber = document.getLineOfOffset(offset);
						} catch (BadLocationException e2) {
							// TODO Auto-generated catch block
							e2.printStackTrace();
						}
						// end of get cursor location
						
						
						System.out.println("Start "+start+", end "+end+", offset "+offset);
//						IDocumentProvider dp = editor.getDocumentProvider();
//						IDocument doc = dp.getDocument(editor.getEditorInput());
//						String text = doc.get() + "testtesttest";
//						doc.set(text);
						
						try {
							document.replace(offset, 0, "testtesttest\n");
						} catch (BadLocationException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						
						// doc.set(text) sets the cursor in the start of the file, so set the cursor in the same location it was in
						part.getSite().getSelectionProvider().setSelection(textSelection);
					}

					@Override
					public void keyPressed(KeyEvent e) {
						System.out.println("key pressed ");
					}
				});
			}

		};
	}

}
