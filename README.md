Seuraavat askeleet (kohdat 6 ja 7):
https://www.vogella.com/tutorials/EclipseEditors/article.html








Adding dep to Eclipse Plugin:

https://stackoverflow.com/questions/2319340/how-to-add-plug-in-dependency-in-eclipse



https://stackoverflow.com/questions/12952083/eclipse-custom-content-assist-based-on-default-java-content-assist-results



https://help.eclipse.org/latest/index.jsp?topic=/org.eclipse.jdt.doc.isv/reference/extension-points/org_eclipse_jdt_ui_javaCompletionProposalComputer.html

https://www.google.com/search?q=extending-the-content-assist-capabilities-of-the-eclipse-xml-editor&rlz=1C1GCEB_enFI982FI982&oq=extending-the-content-assist-capabilities-of-the-eclipse-xml-editor&aqs=chrome..69i57.751j0j4&sourceid=chrome&ie=UTF-8


Examples:

https://github.com/trylimits/Eclipse-Postfix-Code-Completion/tree/master/org.eclipse.jdt.postfixcompletion/src/org/eclipse/jdt/postfixcompletion/core


https://www.tabnine.com/code/java/methods/org.eclipse.jdt.internal.ui.text.JavaCommentScanner/getPreferenceStore


https://wiki.eclipse.org/FAQ_How_do_I_add_Content_Assist_to_my_editor%3F


<extension point="org.eclipse.wst.jsdt.ui.javaCompletionProposalComputer"
	   id="openai_textual_proposals"
	   name="Openai Text Proposals">
	
	</extension>
	<extension point="org.eclipse.wst.jsdt.ui.javaCompletionProposalComputer"
	   id="NodeclipseProposals"
	   name="Nodeclipse Proposals">
	   <javaCompletionProposalComputer
	      class="test.AiTestCompletionProposalComputer"
	      categoryId="org.eclipse.ui.texteditor.textual_proposals">
	      <partition type="__java_javadoc"/>
	   </javaCompletionProposalComputer>
	</extension>
	
	
	https://stackoverflow.com/questions/20779899/content-assist-with-javacompletionproposalcomputer-for-eclipse-jsdt-gives-no-pro
	
	
	http://codeandme.blogspot.com/2014/05/extending-jsdt-adding-your-own-content.html