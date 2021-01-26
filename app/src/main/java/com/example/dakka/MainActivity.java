package com.example.dakka;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.dakka.API.APIReq;
import com.example.dakka.API.RetroServer;
import com.example.dakka.Model.Users.ResponModel;
import com.example.dakka.Model.Users.User;
import com.example.dakka.Model.Wisata.ResponseModel;
import com.example.dakka.Model.Wisata.Wisata;
import com.example.dakka.PrefManager.PrefManager;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    EditText uname, passwd;
    Button signin;
    TextView signup;
    private APIReq apiReq = RetroServer.getClient().create(APIReq.class);
    private PrefManager preference;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        uname = findViewById(R.id.username);
        passwd = findViewById(R.id.password);
        signin = findViewById(R.id.sign_in);
        signup = findViewById(R.id.tv_signup);
        preference = new PrefManager(MainActivity.this);


        if (preference.getLogin()){
            startActivity(new Intent(MainActivity.this,Dashboard.class));
            finish();
        }


        signin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Toast.makeText(getApplicationContext(), "Welcome", Toast.LENGTH_SHORT).show();
//                Intent intent = new Intent(MainActivity.this, Dashboard.class);
//                startActivity(intent);
//                finish();
               Login(uname.getText().toString(),passwd.getText().toString());
            }
        });

        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Signup.class);
                startActivity(intent);
            }
        });
    }
    public void Login(String username,String password){
        Call<ResponModel> userArray = apiReq.login(username,password);
        userArray.enqueue(new Callback<ResponModel>() {
            @Override
            public void onResponse(Call<ResponModel> call, Response<ResponModel> response) {
                String kode = response.body().getSuccess();
                if (kode.equals("true")){
                    User users = response.body().getResult().get(0);
                    preference.setID(users.getId());
                    preference.setLogin(true);
                    preference.setNama(users.getNama());
                    preference.setFoto(users.getFoto());
                    Intent intent = new Intent(MainActivity.this, Dashboard.class);
                    intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
                    startActivity(intent);
                    finish();
                }else {
                    Toast.makeText(MainActivity.this,"Your username and passowrd is incorrect",Toast.LENGTH_SHORT).show();
                }





            }

            @Override
            public void onFailure(Call<ResponModel> call, Throwable t) {
                Toast.makeText(MainActivity.this,t.toString(),Toast.LENGTH_LONG).show();
            }
        });
    }
}