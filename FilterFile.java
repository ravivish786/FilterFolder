import java.io.IOException;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
public class FilterFile{

	// file extention
		private String imageExtension[]={".png",".jpg",".jpeg"};
		private String textExtension[]={".txt"};
		private String docExtension[]={".pdf",".doc",".docx"};
		final List<String> imageExt=Arrays.asList(imageExtension);
		final List<String> textExt=Arrays.asList(textExtension);
		final List<String> docExt=Arrays.asList(docExtension);
		
	// create folder 
		void createFolderIfNotExist(String folderName)
		{
			final  File folder=new File(folderName);
			if(!folder.exists())
				folder.mkdir();
		}
	// get file extention
		private String getFileExtention(File fileName)
		{			  
			int index=fileName.toString().lastIndexOf('.'); 
			    if(index > 0) 
			      return fileName.toString().substring(index);
			return "null";
		}
	// move file to folder
		private void moveFileToFolder(String folderName,File fileName) throws IOException
		{
				
				Path temp = Files.move(Paths.get("./"+fileName.toString()),Paths.get("./"+folderName+"/"+fileName.toString())); 
		}
	// main method 
	public static void main(String[] args) throws IOException{
		 final String[] showFolderName={"Image Files","Text Files","Document Files","Other Files"};
	// object of this class 
		FilterFile filterFile=new FilterFile();
	// take cuurent file list
		final File f=new File(".");
		File[] fileList=f.listFiles();
		List<File> onlyFile = new ArrayList<File>();
		      for(File file:fileList) {
		         if(file.isFile())
		         	onlyFile.add(file);
		      }
		onlyFile.remove(new File("./FilterFile.java"));
		onlyFile.remove(new File("./FilterFile.class"));

		if(onlyFile.isEmpty()){
			System.out.println("Files is not Avaliable...	");
			System.out.println(" \n \t\t\t\t Thanks for Using...... ");
			return ;
		}

    // create folder 
		for(String foldername:showFolderName)
			filterFile.createFolderIfNotExist(foldername);
	
	// move file in to folder 
		 for(File file:onlyFile) {
		        if(filterFile.imageExt.contains(filterFile.getFileExtention(file)))
		        	 filterFile.moveFileToFolder(showFolderName[0],file);
		        else if(filterFile.textExt.contains(filterFile.getFileExtention(file)))
		        	 filterFile.moveFileToFolder(showFolderName[1],file);
		        else if(filterFile.docExt.contains(filterFile.getFileExtention(file)))
		        	 filterFile.moveFileToFolder(showFolderName[2],file);
		        else
		        	 filterFile.moveFileToFolder(showFolderName[3],file);
		      }
	// 
		System.out.println(" \n \t\t\t\tThanks for Using...... ");
	}
}