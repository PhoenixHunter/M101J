package com.tengen;

import com.mongodb.*;
import com.mongodb.util.JSON;
import org.bson.BSON;
import org.json.JSONObject;

import java.net.UnknownHostException;
import java.util.*;

/**
 * Created by haghighi on 1/20/15.
 */
public class Week3Homework1 {
    public static void main(String[] args) throws UnknownHostException {
        MongoClient client = new MongoClient();
        DB db = client.getDB("school");
        DBCollection students = db.getCollection("students");

        long count = students.count();
        System.out.println(count);

        JSONObject json;



//        for (int i = 0; i < count; i++) {
//          DBObject result = students.findOne(new BasicDBObject("_id", i), new BasicDBObject("scores", true));

//
//        }

        DBObject result = students.findOne(new BasicDBObject("_id", 0), new BasicDBObject("scores", true).append("_id", false));

        BasicDBList e = (BasicDBList) result.get("scores");

//        List<Object> docList = new ArrayList<Object>();
//        docList = result.get("scores");
//



        for(Iterator<Object> i = e.iterator(); i.hasNext(); ) {
            BasicDBList item = (BasicDBList) i.next();
          System.out.println(item);
        }



    }

}
