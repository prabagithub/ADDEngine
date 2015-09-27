package com.add.db;

import org.bson.Document;

import com.add.domain.Client;
import com.add.domain.User;
import com.mongodb.BasicDBObject;
import com.mongodb.MongoClient;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;

public class MongoDBDAO {

	private static MongoClient mongoClient;
	private static MongoDatabase mongoDatabase;
	
	static{
		try{
			initDBConnection();
		} catch(Exception e){
			throw e;
		}
	}
	
	private static void initDBConnection(){
		try{
			mongoClient = new MongoClient("localhost", 27017);
			if(null != mongoClient){
				mongoDatabase = mongoClient.getDatabase("Client");	
			}
			
			System.out.println("Connection success");
		}catch(Exception e){
			throw e;
		}
	}
	
	
	
	
	/**
	 * This method is used to insert advertisement details into database
	 * @param client
	 * @return
	 */
	public boolean insertADDDetails(Client client ){
		boolean result = true;
		MongoCursor<Document> curso = null;
		try{
			MongoCollection<Document> collection = mongoDatabase.getCollection("adddb");
			Document doc = new Document();
			doc.put("OrgName", client.getOrgName());
			doc.put("addressL1", client.getAddr1());
			doc.put("addressL2", client.getAddr2());
			doc.put("addressL3", client.getAddr3());
			doc.put("city", client.getCity());
			doc.put("state", client.getState());
			doc.put("country", client.getCountry());
			doc.put("pincode", client.getPostalCode());
			doc.put("desc", client.getAddDesc());	
			doc.put("username", client.getUserName());
			collection.insertOne(doc);
			
			BasicDBObject basic = new BasicDBObject("username",client.getUserName());
			FindIterable<Document> cursor = collection.find(basic);
			if(null != cursor){
				curso = cursor.iterator();
				while(curso.hasNext()){
					System.out.println(curso.next());
				}
			}
			
		} catch(Exception e){
			result = false;
			throw e;
		}
		finally{
				curso.close();
		}
		
		return result;
	}
	
	public boolean checkUser(User user){
		boolean result = false;
		MongoCursor<Document> cur = null;
		try{
			MongoCollection<Document> collection = mongoDatabase.getCollection("users");
			BasicDBObject basic   = new BasicDBObject ("userName", user.getUsername());
			FindIterable<Document> cursor = collection.find(basic);
			if(null != cursor){
				cur = cursor.iterator();
				while(cur.hasNext()){
					Document doc = cur.next();
					String pwd = (String) doc.get("pwd");
					if(null != pwd && pwd.equalsIgnoreCase(user.getPassword())){
						result = true;
					}
				}
			}
			
			
			
		}catch(Exception e){
			throw e;
		}
		return result;
	}
	
	public boolean registerUser(User user ){
		boolean result = true;
		//MongoCursor<Document> curso = null;
		try{
			MongoCollection<Document> collection = mongoDatabase.getCollection("users");
			Document doc = new Document();
			doc.put("userName", user.getUsername());
			doc.put("pwd", user.getPassword());					
			collection.insertOne(doc);
						
		} catch(Exception e){
			result = false;
			throw e;
		}		
		return result;
	}
	
}
