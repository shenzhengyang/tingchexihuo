package com.example.zy.happyrun.Login.Activity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.baidu.apistore.sdk.ApiCallBack;
import com.baidu.apistore.sdk.ApiStoreSDK;
import com.baidu.apistore.sdk.network.Parameters;
import com.baidu.location.LocationClient;
import com.example.zy.happyrun.BD_location.BD_location_thread;
import com.example.zy.happyrun.Login.Entity.Login_in_result;
import com.example.zy.happyrun.Login.Service.Login_service;
import com.example.zy.happyrun.Main_pager.Activity.Mainpager_Activity;
import com.example.zy.happyrun.My_Application.StatusBars;
import com.example.zy.happyrun.My_Application.cn2char;
import com.example.zy.happyrun.My_Information.Entity.tianqi_back_entity;
import com.example.zy.happyrun.My_Information.My_Information_Applycation;
import com.example.zy.happyrun.R;
import com.google.gson.Gson;


/**
 * Created by zy on 2016/7/18.
 */
public class Login_Activity extends AppCompatActivity implements View.OnClickListener{
    private EditText name;
    private EditText password;
    private TextView login_Button;
    private TextView has_a_try;
    private TextView regist;
    private String nameString;
    private String passwordString;

    private ProgressDialog progressDialog;
    private Login_in_result login_in_result;

    public LocationClient mLocationClient;
    public BD_location_thread bd_location_thread;
    Gson gson;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        StatusBars statusBars=new StatusBars(R.color.status_color);
        statusBars.initSystemBar(this);
        setContentView(R.layout.login_in);
        init();
        setListener();

    }

    private void setListener() {
        name.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                nameString = s.toString();
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        password.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                passwordString = s.toString();
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
    }

    private void init() {
        name= (EditText) findViewById(R.id.name);
        password= (EditText) findViewById(R.id.password);
        login_Button= (TextView) findViewById(R.id.login_Button);
        has_a_try= (TextView) findViewById(R.id.have_aTry);
        regist= (TextView) findViewById(R.id.regist);
        login_Button.setOnClickListener(this);
        has_a_try.setOnClickListener(this);
        regist.setOnClickListener(this);
        gson=new Gson();
        mLocationClient=new LocationClient(getApplicationContext());
        bd_location_thread=new BD_location_thread(mLocationClient);
        bd_location_thread.run();
    }

    @Override
    public void onClick(View v) {
        int id=v.getId();
        switch (id){
            case R.id.login_Button:{
                nameString=name.getText().toString();
                passwordString=password.getText().toString();
                if(nameString.equals("")||nameString==null){
                    Toast.makeText(this,"用户名为空！",Toast.LENGTH_SHORT).show();
                }
                else if(passwordString.equals("")||passwordString==null){
                    Toast.makeText(this,"密码为空！",Toast.LENGTH_SHORT).show();
                }
                else{
                    new AsyncTask<Void,Integer,String>(){
                        @Override
                        protected void onPreExecute() {
                            progressDialog=new ProgressDialog(Login_Activity.this);
                            progressDialog.setMessage("登陆中。。。");
                            progressDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
                            progressDialog.show();
                        }

                        @Override
                        protected String doInBackground(Void... params) {
                            Login_service login_service=new Login_service();
                            return login_service.Login_in(nameString,passwordString);
                        }

                        @Override
                        protected void onPostExecute(String aBoolean) {
                            login_in_result=new Login_in_result();
                            progressDialog.cancel();
                            Gson gson=new Gson();
                            login_in_result=gson.fromJson(aBoolean,Login_in_result.class);
                            if(login_in_result.getResult().equals("seccess")){
                                Intent intent=new Intent(Login_Activity.this,Mainpager_Activity.class);
                                startActivity(intent);
                            }else{
                                Toast.makeText(Login_Activity.this,"该用户不存在，请注册！",Toast.LENGTH_SHORT).show();
                            }

                        }
                    }.execute();

                }
                break;
            }
            case R.id.have_aTry:{
                Intent intent=new Intent(Login_Activity.this,Mainpager_Activity.class);
                startActivity(intent);
                break;
            }
            case R.id.regist:{
                Intent intent=new Intent(Login_Activity.this,Regist_Activity.class);
                startActivity(intent);
                break;
            }

        }
    }


}
