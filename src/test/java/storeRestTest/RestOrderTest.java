package storeRestTest;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.testng.annotations.Test;
import storeRest.Order;
import storeRest.PostOrder;

import java.io.IOException;

public class RestOrderTest {
    @Test(description = "Create order")
    public void createOrderTest() throws IOException {

        Order order = new Order();
        order.setId(10);
        order.setPetId(15);
        order.setQuantity(2);
        order.setShipDate("22-02-2022");
        order.setStatus("placed");
        order.setComplete(true);

        new PostOrder().createOrder(order);
    }

    @Test(description = "Get order")
    public void getOrderTest() throws IOException {
        Order order = new Order();
        Request request = new Request.Builder()
                .url("https://petstore.swagger.io/v2/store/order/"+order.getId())
                .get()
                .build();

        OkHttpClient client = new OkHttpClient();
        Response response = client.newCall(request).execute();

        System.out.println(response.body().string());
    }

    @Test(description = "Delete order")
    public void deleteOrderTest() throws IOException {
        Order order = new Order();
        Request request = new Request.Builder()
                .url("https://petstore.swagger.io/v2/store/order/"+order.getId())
                .delete()
                .build();

        OkHttpClient client = new OkHttpClient();
        Response response = client.newCall(request).execute();

        System.out.println(response.body().string());
    }
}
