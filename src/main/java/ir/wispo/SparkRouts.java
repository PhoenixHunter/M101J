package ir.wispo;

import spark.Request;
import spark.Response;
import spark.Route;
import spark.Spark;

/**
 * Created by haghighi on 1/12/15.
 */
public class SparkRouts {
    public static void main(String[] args) {
        Spark.get(new Route("/echo/:any") {
            @Override
            public Object handle(Request request, Response response) {
                return request.params(":any");
            }
        });
    }
}
