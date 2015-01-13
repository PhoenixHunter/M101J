package ir.wispo;

import freemarker.template.Configuration;
import freemarker.template.Template;
import spark.Request;
import spark.Response;
import spark.Route;
import spark.Spark;

import java.io.StringWriter;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by haghighi on 1/12/15.
 */
public class SparkFormHandling {
    public static void main(String[] args) {
        final Configuration configuration = new Configuration();
        configuration.setClassForTemplateLoading(
                SparkFormHandling.class, "/"
        );
        Spark.get(new Route("/") {
            @Override
            public Object handle(final Request request, final Response response) {
                StringWriter writer = new StringWriter();
                try {
                    Template helloTemplate = configuration.getTemplate("fruitPicker.ftl");

                    Map<String, Object> helloMap = new HashMap<String, Object>();
                    helloMap.put("fruits", Arrays.asList("apple", "orange", "banana", "peach"));

                    helloTemplate.process(helloMap, writer);
                } catch (Exception e) {
                    halt(500);
                    e.printStackTrace();
                }
                return writer;
            }
        });

        Spark.post(new Route("/favorite_fruit") {
            @Override
            public Object handle(Request request, Response response) {
                final String fruit = request.queryParams("fruit");

                if (fruit == null){
                    return "Why don't you pick a fruit?";
                }
                else {
                    return "Your fruit is: " + fruit;
                }
            }
        });
    }
}
