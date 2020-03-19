
public class SeparatedFiles {
	private String fileName;
	private int fileSize;
	private String separator;
	
	public SeparatedFiles(String file, int size, String separate) {
		this.fileName = file;
		this.fileSize = size;
		this.separator = separate;
	
	}
	
	public String getFilename ()
	{
		return this.fileName;
	}

	public int getFileSize ()
	{
		return this.fileSize;
	}
	
	public String printSeparator ()
	{
		return this.separator;
	}
	
}
