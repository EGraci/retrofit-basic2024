package com.example.retrofit;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface API {
    @GET("index.php")
    Call<DtoAkun> getAkun(@Query("cuser") String username, @Query("cpw") String password);

    @POST("index.php")
    Call<String> addAkun(@Body DtoNewUser dtoNewUser);

    @PUT("index.php")
    Call<String> updateAkun(@Body DtoNewUser dtoNewUser);

    @GET("login.php")
    Call<List<DtoAkun>> getAkunAll();

    @DELETE("index.php")
    Call<String> deleteAkun(@Query("id") String id);
}
