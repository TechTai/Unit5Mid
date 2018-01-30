package nyc.c4q.randomuserapp;

import android.app.LauncherActivity;
import android.app.Service;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.widget.GridLayout;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.security.Provider;
import java.util.List;

import nyc.c4q.randomuserapp.Model.UserModel;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    String url = "https://randomuser.me/api/?nat=us&inc=name,location,cell,email,dob,picture&results=20";

    private ImageView photo;
    private TextView name;
    private TextView description;
    private ProgressBar progressBar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recyclerview);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this);
        recyclerView.setLayoutManager(GridLayoutManager);

        progressBar = (ProgressBar) findViewById(R.id.pb_loading_indicator);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://randomuser.me/api/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        Service service = retrofit.create(Service.class);
        Call<UserModel> responseCall = service.();
        responseCall.enqueue(new Callback<UserModel>() {
            @Override
            public void onResponse(Call<UserModel> call, Response<UserModel> response) {
                response.body().getResults();
                //RecyclerView Adapter must be placed with the onResponse
                RandomUserAdapter userAdapter = new RandomUserAdapter(myArrayList);
                recyclerView.setAdpater(userAdapter);
            }

            @Override
            public void onFailure(Call<UserModel> call, Throwable t) {

            }
        })

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.refresh, menu);
        return true;
    }



    }
}
