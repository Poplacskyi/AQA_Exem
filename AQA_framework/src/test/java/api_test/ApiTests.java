package api_test;

import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import api.models.User;

public class ApiTests {
    private api.services.userservice userService = new api.services.userservice();

    @Test
    public void testGetUser(){
        Response response = userService.getUserById("2");
        Assert.assertEquals(response.getStatusCode(), 200, "User not retrieved successfully");
    }

    @Test
    public void testCreateUser(){
        api.models.User user = new api.models.User(null, "John Doe", "john@example.com");
        Response response = userService.createUser(user);
        Assert.assertEquals(response.getStatusCode(), 201, "User not created");
    }
}
