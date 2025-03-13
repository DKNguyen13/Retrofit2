package vn.hcmute.retrofit2.network;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import vn.hcmute.retrofit2.model.Category;

public interface APIService {
    //@GET("api/category")
    @GET("/categories.php")
    Call<List<Category>> getCategoryAll();
}
