package storeRest;

import com.google.gson.Gson;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

public class PostOrder {
    public void createOrder(Order order) throws IOException {

        Gson gson = new Gson();
        gson.toJson(order);

        RequestBody body = RequestBody.create(gson.toJson(order).getBytes(StandardCharsets.UTF_8));

        Request request = new Request.Builder()
                .post(body)
                .url("https://petstore.swagger.io/v2/store/order")
                .addHeader("Content-Type", "application/json")
                .build();

        OkHttpClient client = new OkHttpClient();

        Response response = client.newCall(request).execute();
    }
}
