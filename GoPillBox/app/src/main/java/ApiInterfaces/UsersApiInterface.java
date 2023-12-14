package ApiInterfaces;

import retrofit2.Call;
import retrofit2.http.*;
import Models.User;
import Models.UserView;

public interface UsersApiInterface {

    @GET("Users")
    Call<User> getUsers();

    @POST("Users")
    Call<User> createUser(@Body User user);

    @GET("Users/{id}")
    Call<User> getUserById(@Path("id") int userId);

    @PUT("Users/{id}")
    Call<User> updateUser(@Path("id") int userId, @Body UserView user);

    @DELETE("Users/{id}")
    Call<User> deleteUser(@Path("id") int userId);
}
