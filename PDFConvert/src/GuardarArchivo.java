
public class GuardarArchivo {

	public static void main(String[] args) {
		try{
			Ole32.CoInitialize();
			DispatchPtr app = new DispatchPtr("Word.Application");
			app.put("Visible", true);
			DispatchPtr docs = (DispatchPtr)docs.invoke("Add");
			doc.put("Content", DOC_TEXT);
			doc.invoke("SaveAs", new File(DOC_FILENAME).getAbsolutePath());
			app.invoke("Quit");
			Ole32.CoUninitialize();
		   }
		catch(Exception e)
		{

			e.printStackTrace();
		}

	}

}

