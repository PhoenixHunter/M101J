package com.tengen;

import com.mongodb.*;

import java.net.UnknownHostException;

/**
 * Created by haghighi on 1/20/15.
 */
public class Week2Homework2 {
    public static void main(String[] args) throws UnknownHostException {
        MongoClient client = new MongoClient();
        DB db = client.getDB("students");
        DBCollection grads = db.getCollection("grades");


//        for (int i = 0; i < 200; i++) {
//            DBCursor cursor = grads.find(new BasicDBObject("student_id", i))
//                    .sort(new BasicDBObject("score", 1)).limit(1);
//            try {
//                while (cursor.hasNext()) {
//                    DBObject cur = cursor.next();
//                    grads.remove(new BasicDBObject("score", cur.get("score")).append("student_id", i));
//                }
//            } finally {
//                cursor.close();
//            }
//        }
        DBCursor cursor = grads.find()
                .sort(new BasicDBObject("student_id", -1));

        try {
            while (cursor.hasNext()) {
                DBObject cur = cursor.next();
                System.out.println(cur);
            }
        } finally {
            cursor.close();
        }
    }

}
