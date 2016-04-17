package cn.longyt.test;

import org.bson.BsonDocument;
import org.bson.BsonString;
import org.bson.Document;
import org.junit.Test;

import com.mongodb.MongoClient;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;

public class MongoDBJavaTest {

    /**
     * 创建数据库连接（2.5.3版本）
     */
    /*@Test
    public void getConnection() {
        try {
            // 连接到 mongodb 服务
            Mongo mongo = new Mongo("localhost", 27017); 
            // 连接到数据库
            DB db = mongo.getDB("test");
            System.out.println("Connect to database successfully");
            boolean auth = db.authenticate("root", "root".toCharArray());
            System.out.println("Authentication: "+auth);
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
        }
    }*/
    
    /**
     * 创建数据库连接（3.1.0版本）
     */
    @Test
    public void getConnection() {
        try {
            // 连接到 mongodb 服务
            MongoClient mongoClient = new MongoClient("localhost", 27017);
            // 连接到数据库
            MongoDatabase db = mongoClient.getDatabase("test");
            System.out.println("Connect to database successfully");
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
        }
    }
    
    /**
     * 创建集合
     */
    @Test
    public void createCollection() {
        try {
            // 连接到 mongodb 服务
            MongoClient mongoClient = new MongoClient("localhost", 27017);
            // 连接到数据库
            MongoDatabase db = mongoClient.getDatabase("test");
            System.out.println("Connect to database successfully");
            // 创建集合
            db.createCollection("credit");
            System.out.println("Collection created successfully");
            mongoClient.close();
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
        }
    }
    
    /**
     * 获取集合
     */
    @Test
    public void getCollection() {
        try {
            // 连接到 mongodb 服务
            MongoClient mongoClient = new MongoClient("localhost", 27017);
            // 连接到数据库
            MongoDatabase db = mongoClient.getDatabase("test");
            System.out.println("Connect to database successfully");
            // 获取集合
            MongoCollection collection = db.getCollection("credit");
            System.out.println("get collection successfully");
            mongoClient.close();
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
        }
    }
    
    /**
     * 插入文档
     */
    @Test
    public void insert() {
        try {
            // 连接到 mongodb 服务
            MongoClient mongoClient = new MongoClient("localhost", 27017);
            // 连接到数据库
            MongoDatabase db = mongoClient.getDatabase("test");
            System.out.println("Connect to database successfully");
            MongoCollection collection = db.getCollection("credit");
            for(int i=0;i<100;i++){
                Document doc = new Document();
                doc.append("title", "MongoDB");
                doc.append("description", "database"+i);
                doc.append("likes", 100+i);
                doc.append("url", "http://www.w3cschool.cc/mongodb/");
                doc.append("by", "w3cschool.cc");
                collection.insertOne(doc);
            }
            mongoClient.close();
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
        }
    }
    
    /**
     * 查询结果集
     */
    @Test
    public void queryResultSet() {
        try {
            // 连接到 mongoDB服务
            MongoClient mongoClient = new MongoClient("localhost", 27017);
            // 连接到数据库
            MongoDatabase db = mongoClient.getDatabase("test");
            // 获取集合
            MongoCollection<Document> collection = db.getCollection("credit");
            // 查询条件
            BsonDocument query = new BsonDocument();
            // 设置查询条件
            query.append("title", new BsonString("MongoDB"));
            // 查询结果集
            FindIterable<Document> resultSet = collection.find(query);
            // 获取迭代器
            MongoCursor<Document> ite = resultSet.iterator();
            // 循环结果集
            while(ite.hasNext()){
                // 结果集中的每一个元素
                Document doc = (Document) ite.next();
                // 输出每个元素的description字段的值
                System.out.println(doc.get("description")+"---"+doc.get("likes")+"---"+doc.get("url"));
            }
            // 关闭连接
            mongoClient.close();
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
        }
    }
}
