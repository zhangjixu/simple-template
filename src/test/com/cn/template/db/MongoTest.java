package com.cn.template.db;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import org.junit.Test;

/**
 * @Author: zhangjixu
 * @CreateDate: 2020/03/02 5:04 PM
 * @Description:
 * @Version: 1.0.0
 */
public class MongoTest {

    @Test
    public void testMongo() {
        MongoClientURI mongoClientURI = new MongoClientURI("mongodb://192.168.0.10:27017/?readPreference=SECONDARY");
        MongoClient mongoClient = new MongoClient(mongoClientURI);
        MongoDatabase database = mongoClient.getDatabase("test");
        MongoCollection<Document> collection = database.getCollection("test");

        Document document = new Document();
        document.put("name", "张三");
        document.put("age", 18);

        collection.insertOne(document);


    }

}
