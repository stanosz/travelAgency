package persistance;

import java.io.IOException;
import java.util.List;

import org.apache.lucene.queryparser.classic.ParseException;

import model.Excursion;

public class LucenePersistance {
	
	public String persisExcursion(){
	   LuceneIndexer tester;
	   String numfile="";
	      try {
	         tester = new LuceneIndexer(LuceneConstants.INDEX_FOLDER);
	         numfile=tester.search("agung");
	      } catch (IOException e) {
	         e.printStackTrace();
	      } catch (ParseException e) {
	         e.printStackTrace();
	      }
	      return numfile;
	   }

  //This method do a corelation between Excursion text files with the database
	public void MatchExcursion(){
		String LuceneElement=this.persisExcursion();
		  JdbcPersistance jdbc= new JdbcPersistance();
	      List<Excursion>le=jdbc.ListExcursion();
		  for(Excursion elem: le){
			  if (Integer.valueOf(LuceneElement)==elem.getId()){
			  System.out.println(elem);
			  }
		  }
	}
	
}


