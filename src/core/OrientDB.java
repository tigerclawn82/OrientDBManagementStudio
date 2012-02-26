package core;

import java.util.Arrays;
import java.util.List;

import com.orientechnologies.orient.core.db.document.ODatabaseDocumentTx;
import com.orientechnologies.orient.core.record.impl.ODocument;
import com.orientechnologies.orient.core.sql.query.OSQLSynchQuery;

public class OrientDB {
	
	public static void main(String[] args) {
		
		ODatabaseDocumentTx db = null;
		String dbName = "AMS";
		String path = System.getProperty("user.dir") + "/" + dbName;
		String URL = "local:/" + path;
		
		System.out.println(URL);
		
		try {
			
			db = new ODatabaseDocumentTx (URL).create();
			
		} catch (Exception e) {
			
			db = new ODatabaseDocumentTx (URL).open("admin", "admin");
		}
		
		/*ODocument animal = new ODocument(db, "PERSON");
		animal.field( "name", "Waqas Ahmed" );
		animal.field( "father", "Muhammad Ashraf" );
		animal.save();*/
		
		List<ODocument> result = db.query(new OSQLSynchQuery<ODocument>("select * from PERSON"));
		
		ODocument oDocument = result.get(0);
		
		System.out.println(oDocument.field("name"));
		System.out.println("Hi, It's Boxcar Testing stuff ...");
			  
		
	}

}
