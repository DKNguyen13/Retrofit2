package vn.hcmute.retrofit2.activities;

import android.os.Bundle;
import android.util.Log;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import vn.hcmute.retrofit2.R;
import vn.hcmute.retrofit2.adapter.CategoryAdapter;
import vn.hcmute.retrofit2.model.Category;
import vn.hcmute.retrofit2.network.APIService;
import vn.hcmute.retrofit2.network.RetrofitClient;

public class MainActivity extends AppCompatActivity {
    RecyclerView rvCate;
    CategoryAdapter categoryAdapter;
    List<Category> cateList;
    APIService apiService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        rvCate = (RecyclerView) findViewById(R.id.rc_categories);
        cateList = new ArrayList<>();
        GetCate();
    }

    public void GetCate(){
        apiService = RetrofitClient.getRetrofit().create(APIService.class);
        apiService.getCategoryAll().enqueue(new Callback<List<Category>>() {
            @Override
            public void onResponse(Call<List<Category>> call, Response<List<Category>> response) {
                if(response.isSuccessful()){
                    cateList = response.body();
                    categoryAdapter = new CategoryAdapter(MainActivity.this, cateList);
                    Log.d("Hello", "sss");
                    rvCate.setHasFixedSize(true);
                    RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.HORIZONTAL, false);
                    rvCate.setLayoutManager(layoutManager);
                    rvCate.setAdapter(categoryAdapter);
                    categoryAdapter.notifyDataSetChanged();
                }
                else {
                    int statusCode =  response.code();
                    //Handle request errors depending on status code
                }
            }

            @Override
            public void onFailure(Call<List<Category>> call, Throwable t) {
                Log.d("logg", t.getMessage());
            }
        });
    }
}