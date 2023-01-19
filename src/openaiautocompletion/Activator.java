package openaiautocompletion;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.jdt.ui.text.java.ContentAssistInvocationContext;
import org.eclipse.jdt.ui.text.java.IJavaCompletionProposalComputer;
import org.eclipse.jface.text.contentassist.CompletionProposal;
import org.eclipse.jface.text.contentassist.ICompletionProposal;
import org.eclipse.jface.text.contentassist.IContextInformation;
import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.osgi.framework.BundleContext;

/**
 * The activator class controls the plug-in life cycle
 */
public class Activator extends AbstractUIPlugin implements IJavaCompletionProposalComputer {

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
		// TODO Auto-generated method stub

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

}
