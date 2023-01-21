package openaiautocompletion;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.jdt.ui.text.java.ContentAssistInvocationContext;
import org.eclipse.jdt.ui.text.java.IJavaCompletionProposalComputer;
import org.eclipse.jface.text.DocumentEvent;
import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.text.IDocumentListener;
import org.eclipse.jface.text.contentassist.CompletionProposal;
import org.eclipse.jface.text.contentassist.ICompletionProposal;
import org.eclipse.jface.text.contentassist.IContextInformation;
import org.eclipse.jface.util.IPropertyChangeListener;
import org.eclipse.jface.util.PropertyChangeEvent;
import org.eclipse.swt.custom.StyledText;
import org.eclipse.swt.events.KeyEvent;
import org.eclipse.swt.events.KeyListener;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IPageListener;
import org.eclipse.ui.IPartListener2;
import org.eclipse.ui.IPropertyListener;
import org.eclipse.ui.IStartup;
import org.eclipse.ui.IWindowListener;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.IWorkbenchPartReference;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.part.FileEditorInput;
import org.eclipse.ui.plugin.AbstractUIPlugin;
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

//	@Override
//	public void textChanged(TextEvent arg0) {
//		System.out.println("textchanged");
//		 IWorkbench wb = PlatformUI.getWorkbench();
//		   IWorkbenchWindow win = wb.getActiveWorkbenchWindow();
//		   IWorkbenchPage page = win.getActivePage();
//		
//		IEditorPart part = page.getActiveEditor();
//		if (!(part instanceof AbstractTextEditor))
//				return;
//		ITextEditor editor = (ITextEditor)part;
//		IDocumentProvider dp = editor.getDocumentProvider();
//		IDocument doc = dp.getDocument(editor.getEditorInput());
//		int offset;
//		try {
//			offset = doc.getLineOffset(doc.getNumberOfLines()-4);
//			doc.replace(offset, 0, "testtesttest\n");
//		} catch (BadLocationException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//			throw new RuntimeException(e);
//		}
//
//	}

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
	            IWorkbenchPage activePage = window.getActivePage(); 
	            activePage.addPartListener(generateIPartListener2());
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
	            IWorkbenchPage activePage = window.getActivePage();
	            activePage.getActivePart().addPropertyListener(generatePropertyListener());
	            activePage.addPartListener(generateIPartListener2());
	            
	            final IEditorPart iep = activePage.getActiveEditor();
	            if (!(iep instanceof ITextEditor)) return;
	            ITextEditor editor = (ITextEditor)iep;
	         // ITextEditor editor;
	            ((StyledText)editor.getAdapter(org.eclipse.swt.widgets.Control.class)).addKeyListener(new KeyListener() {
	            	
	            	@Override
	            	public void keyReleased(KeyEvent e) {
	            		System.out.println("key release ");
	            	}
	            	
	            	@Override
	            	public void keyPressed(KeyEvent e) {
	            		System.out.println("key pressed ");
	            	}
	            });
	            
	        }

	    };
	}

	private IPropertyListener generatePropertyListener() {
		System.out.println("generatePropertyListener called \n\n=================================\\n\\n=================================\\n\\n=================================\\n\\n=================================\\n\\n=================================Starting up\\n\\n=================================\\n\\n=================================\\n\\n=================================");
		return new IPropertyListener() {
			
			@Override
			public void propertyChanged(Object arg0, int arg1) {
				System.out.println("propertyChanged called \n\n=================================\\n\\n=================================\\n\\n=================================\\n\\n=================================\\n\\n=================================Starting up\\n\\n=================================\\n\\n=================================\\n\\n=================================");
				
				System.out.println("Argument: "+arg0.toString()+", class: "+arg0.getClass());
				System.out.println("ArgumentInt: "+arg1);
			}
		};
	}

	private IPartListener2 generateIPartListener2() 
	{
		System.out.println("generateIPartListener2 called \n\n=================================\\n\\n=================================\\n\\n=================================\\n\\n=================================\\n\\n=================================Starting up\\n\\n=================================\\n\\n=================================\\n\\n=================================");
	    return new IPartListener2() {

	        private void checkPart(IWorkbenchPartReference partRef) {
	        IWorkbenchPart part = partRef.getPart(false);
	            if (part instanceof IEditorPart)
	            {
	        		System.out.println("part was instance of IEditorPart \n\n=================================\\n\\n=================================\\n\\n=================================\\n\\n=================================\\n\\n=================================Starting up\\n\\n=================================\\n\\n=================================\\n\\n=================================");
	                IEditorPart editor = (IEditorPart) part;
	                IEditorInput input = editor.getEditorInput();
	                if (editor instanceof ITextEditor && input instanceof FileEditorInput)  //double check.  Error Editors can also bring up this call
	                {
		        		System.out.println("part was instance of ITextEditor and input was FileEditorInput \n\n=================================\\n\\n=================================\\n\\n=================================\\n\\n=================================\\n\\n=================================Starting up\\n\\n=================================\\n\\n=================================\\n\\n=================================");
	                    IDocument document=(((ITextEditor)editor).getDocumentProvider()).getDocument(input);
	                    
	                    document.addDocumentListener(new IDocumentListener() {

								@Override
								public void documentAboutToBeChanged(DocumentEvent arg0) {
		                    		System.out.println("documentAboutToBeChanged called \n\n=================================\\n\\n=================================\\n\\n=================================\\n\\n=================================\\n\\n=================================Starting up\\n\\n=================================\\n\\n=================================\\n\\n=================================");
								}
	
								@Override
								public void documentChanged(DocumentEvent arg0) {
		                    		System.out.println("documentChanged called \n\n=================================\\n\\n=================================\\n\\n=================================\\n\\n=================================\\n\\n=================================Starting up\\n\\n=================================\\n\\n=================================\\n\\n=================================");
								}
		                    }
	                    );
	                }
	            }
	        }

	        @Override
	        public void partOpened(IWorkbenchPartReference partRef) {
	    		System.out.println("partOpened called \n\n=================================\\n\\n=================================\\n\\n=================================\\n\\n=================================\\n\\n=================================Starting up\\n\\n=================================\\n\\n=================================\\n\\n=================================");
	            checkPart(partRef);
	        }

	        @Override
	        public void partInputChanged(IWorkbenchPartReference partRef) 
	        {
	    		System.out.println("partInputChanged called \n\n=================================\\n\\n=================================\\n\\n=================================\\n\\n=================================\\n\\n=================================Starting up\\n\\n=================================\\n\\n=================================\\n\\n=================================");
	            checkPart(partRef);
	        }           

	        @Override
	        public void partVisible(IWorkbenchPartReference partRef){
	    		System.out.println("partVisible called \n\n=================================\\n\\n=================================\\n\\n=================================\\n\\n=================================\\n\\n=================================Starting up\\n\\n=================================\\n\\n=================================\\n\\n=================================");
	        	
	        }

	        @Override
	        public void partHidden(IWorkbenchPartReference partRef) {
	    		System.out.println("partHidden called \n\n=================================\\n\\n=================================\\n\\n=================================\\n\\n=================================\\n\\n=================================Starting up\\n\\n=================================\\n\\n=================================\\n\\n=================================");

	        }

	        @Override
	        public void partDeactivated(IWorkbenchPartReference partRef)  {
	    		System.out.println("partDeactivated called \n\n=================================\\n\\n=================================\\n\\n=================================\\n\\n=================================\\n\\n=================================Starting up\\n\\n=================================\\n\\n=================================\\n\\n=================================");

	        }

	        @Override
	        public void partClosed(IWorkbenchPartReference partRef) {
	    		System.out.println("partClosed called \n\n=================================\\n\\n=================================\\n\\n=================================\\n\\n=================================\\n\\n=================================Starting up\\n\\n=================================\\n\\n=================================\\n\\n=================================");
	        	
	        }

	        @Override
	        public void partBroughtToTop(IWorkbenchPartReference partRef) {
	    		System.out.println("partBroughtToTop called \n\n=================================\\n\\n=================================\\n\\n=================================\\n\\n=================================\\n\\n=================================Starting up\\n\\n=================================\\n\\n=================================\\n\\n=================================");
	        	
	        }

	        @Override
	        public void partActivated(IWorkbenchPartReference partRef) {
	    		System.out.println("partActivated called \n\n=================================\\n\\n=================================\\n\\n=================================\\n\\n=================================\\n\\n=================================Starting up\\n\\n=================================\\n\\n=================================\\n\\n=================================");
	        }
	    };
	}
	
}
