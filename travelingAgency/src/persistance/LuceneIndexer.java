package persistance;


import java.io.File;
import java.io.FileFilter;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Path;

import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.document.Field;
import org.apache.lucene.document.FieldType;
import org.apache.lucene.document.TextField;
import org.apache.lucene.index.CorruptIndexException;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.index.IndexWriterConfig;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.FSDirectory;


public class LuceneIndexer {

   private IndexWriter writer;

public LuceneIndexer(String indexDirectoryPath) throws IOException{
      //this directory will contain the indexes
	   Path path= FileSystems.getDefault().getPath(indexDirectoryPath);
      Directory indexDirectory = 
         FSDirectory.open(path);
      Analyzer analyzer = new StandardAnalyzer();
      //create the indexer
      IndexWriterConfig config = new IndexWriterConfig(analyzer);
      writer = new IndexWriter(indexDirectory,config);
   }

   public void close() throws CorruptIndexException, IOException{
      writer.close();
   }

   private Document getDocument(File file) throws IOException{
      Document document = new Document();
      FieldType ft = new FieldType(TextField.TYPE_STORED);
      //index file contents
      /*Field contentField = new Field(LuceneConstants.CONTENTS, 
         new FileReader(file), ft);*/
      TextField contentField = new TextField(LuceneConstants.CONTENTS, 
    	         new FileReader(file));
      //index file name
      Field fileNameField = new Field(LuceneConstants.FILE_NAME,
         file.getName(),
         ft);
      //index file path
      Field filePathField = new Field(LuceneConstants.FILE_PATH,
         file.getCanonicalPath(),
         ft);

      document.add(contentField);
      document.add(fileNameField);
      document.add(filePathField);

      return document;
   }   

   private void indexFile(File file) throws IOException{
      System.out.println("Indexing "+file.getCanonicalPath());
      Document document = getDocument(file);
      writer.addDocument(document);
   }

   public int createIndex(String dataDirPath, FileFilter filter) 
      throws IOException{
      //get all files in the data directory
      File[] files = new File(dataDirPath).listFiles();

      for (File file : files) {
         if(!file.isDirectory()
            && !file.isHidden()
            && file.exists()
            && file.canRead()
            && filter.accept(file)
         ){
            indexFile(file);
         }
      }
      return writer.numDocs();
   }
}
