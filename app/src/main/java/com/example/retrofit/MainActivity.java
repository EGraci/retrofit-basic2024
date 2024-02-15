package com.example.retrofit;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.gson.Gson;

import java.util.Arrays;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
    private Button get, post, update, delete, getAll;
    private EditText txtIdAkun, txtUsername, txtPassword, txtLevel;
    private TextView viewAll;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        get = (Button) findViewById(R.id.btnGet);
        post = (Button) findViewById(R.id.btnPost);
        update = (Button) findViewById(R.id.btnPut);
        delete = (Button) findViewById(R.id.btnDelete);
        getAll = (Button) findViewById(R.id.btnGetAll);

        txtIdAkun = (EditText) findViewById(R.id.txtIdAkun);
        txtUsername = (EditText) findViewById(R.id.txtUsername);
        txtPassword = (EditText) findViewById(R.id.txtPassword);
        txtLevel = (EditText) findViewById(R.id.txtLevel);

        viewAll = (TextView) findViewById(R.id.viewAll);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://192.168.100.26/basic/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        API apiService = retrofit.create(API.class);

        get.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("Onclick GET", txtUsername.getText().toString()+" "+txtPassword.getText().toString());
                apiService.getAkun(txtUsername.getText().toString(), txtPassword.getText().toString()).enqueue(new Callback<DtoAkun>() {
                    @Override
                    public void onResponse(Call<DtoAkun> call, Response<DtoAkun> response) {
                        if(response.body() != null){
                            DtoAkun akun = response.body();
                            txtIdAkun.setText(akun.getIdAkun());
                            txtUsername.setText(akun.getUsername());
                            txtLevel.setText(akun.getLevel());
                            Log.d("GET", new Gson().toJson(response.body()));

                        }else{
                            Log.d("GET", new Gson().toJson(response.body()));
                        }
                    }

                    @Override
                    public void onFailure(Call<DtoAkun> call, Throwable t) {
                        Log.e("GET", t.toString());

                    }
                });
            }
        });
        post.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("Onclick POST", txtUsername.getText().toString()+" "+txtPassword.getText().toString()+" "+txtLevel.getText().toString());
                DtoNewUser newUser = new DtoNewUser(txtUsername.getText().toString(), txtPassword.getText().toString(), txtLevel.getText().toString());
                apiService.addAkun(newUser).enqueue(new Callback<String>() {
                    @Override
                    public void onResponse(Call<String> call, Response<String> response) {
                        Log.d("POST",  response.body().toString());
                    }

                    @Override
                    public void onFailure(Call<String> call, Throwable t) {
                        Log.e("POST", t.toString());
                    }
                });
            }
        });

        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("Onclick PUT", txtUsername.getText().toString()+" "+txtPassword.getText().toString()+" "+txtLevel.getText().toString());
                DtoNewUser user = new DtoNewUser(txtUsername.getText().toString(), txtPassword.getText().toString(), txtLevel.getText().toString());
                apiService.updateAkun(user).enqueue(new Callback<String>() {
                    @Override
                    public void onResponse(Call<String> call, Response<String> response) {
                        Log.d("PUT",  new Gson().toJson(response.body()));
                    }

                    @Override
                    public void onFailure(Call<String> call, Throwable t) {
                        Log.e("PUT",  t.toString());
                    }
                });
            }
        });

        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("Onclick DELETE", txtIdAkun.getText().toString());
                apiService.deleteAkun(txtIdAkun.getText().toString()).enqueue(new Callback<String>() {
                    @Override
                    public void onResponse(Call<String> call, Response<String> response) {
                        Log.d("DELETE", new Gson().toJson(response.body()));
                    }

                    @Override
                    public void onFailure(Call<String> call, Throwable t) {
                        Log.e("DELETE", t.toString());
                    }
                });
            }
        });

        getAll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("Onclick GET ALL", "Klik");
                apiService.getAkunAll().enqueue(new Callback<List<DtoAkun>>() {
                    @Override
                    public void onResponse(Call<List<DtoAkun>> call, Response<List<DtoAkun>> response) {
                        List<DtoAkun> all = response.body();
                        viewAll.setText(all.toString());
                        Log.d("GET ALL", all.toString());
                    }

                    @Override
                    public void onFailure(Call<List<DtoAkun>> call, Throwable t) {
                        Log.e("GET ALL", t.toString());
                    }
                });
            }
        });
    }
}