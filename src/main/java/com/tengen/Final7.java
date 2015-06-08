/*
 * Copyright (c) 2008 - 2013 10gen, Inc. <http://10gen.com>
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 */

package com.tengen;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.MongoClient;
import com.mongodb.DBCursor;


import java.io.IOException;
import java.net.UnknownHostException;

public class Final7 {
    public static void main(String[] args) throws IOException {
        MongoClient client = new MongoClient();
        DB db = client.getDB("photoshare");
        int i =0;
        DBCollection album = db.getCollection("albums");
        DBCollection image = db.getCollection("images");

        DBCursor cur = image.find();
        cur.next();

        while (cur.hasNext()){
            Object id = cur.curr().get("_id");
            DBCursor curalbum = album.find(new BasicDBObject("images", id));
            if(!curalbum.hasNext()){
                image.remove(new BasicDBObject("_id", id));
            }
            cur.next();
        }
    }
}
