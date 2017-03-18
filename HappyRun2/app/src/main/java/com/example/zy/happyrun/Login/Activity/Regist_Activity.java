package com.example.zy.happyrun.Login.Activity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.zy.happyrun.Login.Entity.Login_in_result;
import com.example.zy.happyrun.Login.Service.Login_service;
import com.example.zy.happyrun.Main_pager.Activity.Mainpager_Activity;
import com.example.zy.happyrun.My_Application.Volly_Request;
import com.example.zy.happyrun.R;
import com.google.gson.Gson;

/**
 * Created by zy on 2016/8/21.
 */
public class Regist_Activity extends AppCompatActivity implements View.OnClickListener{
    private Volly_Request volly_request;
    private String image_code_URL="http://115.29.136.135:8080/HappyRun/ValidateCodeServlet";
    private ImageView image_code;
    private Bitmap bitmap;
    private EditText yonghuming,shouji,password1,password2,image_code_text;
    private TextView regist;
    private ProgressDialog progressDialog;
    private Login_in_result login_in_result;
    private String S_yonghuming,S_shouji,S_password1,S_password2,S_image_code_text;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_regist);
        innit();
        setListener();
    }

    private void setListener() {
        image_code.setOnClickListener(this);
        regist.setOnClickListener(this);
        yonghuming.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                S_yonghuming=s.toString();
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
//                S_yonghuming=s.toString();
            }
        });
        shouji.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                S_shouji = s.toString();
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                S_shouji = s.toString();
            }
        });
        password1.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                S_password1 = s.toString();
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                S_password1 = s.toString();
            }
        });
        password2.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                S_password2 = s.toString();
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                S_password2 = s.toString();
            }
        });
        image_code_text.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                S_image_code_text = s.toString();
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                S_image_code_text = s.toString();
//                if(!judgePhoneNums(S_image_code_text)){
//                    Toast.makeText(Regist_Activity.this, "手机号码输入有误！",Toast.LENGTH_SHORT).show();
//                }
            }
        });
    }

    private void innit() {
        image_code= (ImageView) findViewById(R.id.image_code);
        yonghuming= (EditText) findViewById(R.id.yonghuming);
        shouji= (EditText) findViewById(R.id.shouji);
        password1= (EditText) findViewById(R.id.password1);
        password2= (EditText) findViewById(R.id.password2);
        image_code_text= (EditText) findViewById(R.id.yanzhengma);
        regist= (TextView) findViewById(R.id.mregist);
    }

    @Override
    protected void onResume() {
        getImage_code();
        super.onResume();
    }

    @Override
    public void onBackPressed() {
        this.finish();
        super.onBackPressed();
    }

    @Override
    public void onClick(View v) {
        int id=v.getId();
        switch(id){
            case R.id.image_code:{
                getImage_code();
                break;
            }
            case R.id.mregist:{
                regist();
                break;
            }
        }

    }

    private void regist() {
        S_yonghuming=yonghuming.getText().toString();
        S_shouji=shouji.getText().toString();
        S_password1=password1.getText().toString();
        S_password2=password2.getText().toString();
        S_image_code_text=image_code_text.getText().toString();
        if(S_yonghuming.equals("")||S_yonghuming==null){
            Toast.makeText(this, "用户名为空！", Toast.LENGTH_SHORT).show();
        }
        else if(S_shouji.equals("")||S_shouji==null){
            Toast.makeText(this,"手机号为空！",Toast.LENGTH_SHORT).show();
        }
        else if(!judgePhoneNums(S_shouji)){
            Toast.makeText(this,"手机号格式不正确！",Toast.LENGTH_SHORT).show();
        }
        else if(S_password1.equals("")||S_password1==null){
            Toast.makeText(this,"密码为空！",Toast.LENGTH_SHORT).show();
        }
        else if(S_password2.equals("")||S_password2==null){
            Toast.makeText(this, "再次输入的密码为空！", Toast.LENGTH_SHORT).show();
        }
        else if(!(S_password1.equals(S_password2))){
            Toast.makeText(this,"两次密码输入不一致！",Toast.LENGTH_SHORT).show();
        }
        else if(S_image_code_text.equals("")||S_image_code_text==null){
            Toast.makeText(this,"验证码为空！",Toast.LENGTH_SHORT).show();

        }
        else{
            new AsyncTask<Void, Integer, String>() {
                @Override
                protected void onPreExecute() {
                    progressDialog=new ProgressDialog(Regist_Activity.this);
                    progressDialog.setMessage("注册中。。。");
                    progressDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
                    progressDialog.show();
                    super.onPreExecute();
                }

                @Override
                protected String doInBackground(Void... voids) {
                    Login_service login_service=new Login_service();
                    return login_service.Regist(S_yonghuming,S_password1,S_shouji,S_image_code_text);
                }

                @Override
                protected void onPostExecute(String s) {
                    login_in_result=new Login_in_result();
                    progressDialog.cancel();
                    Gson gson=new Gson();
                    login_in_result=gson.fromJson(s,Login_in_result.class);
                    if(login_in_result.getResult().equals("seccess")){
                        Intent intent=new Intent(Regist_Activity.this,Login_Activity.class);
                        startActivity(intent);
                    }else if(login_in_result.getResult().equals("isregist")){
                        Intent intent=new Intent(Regist_Activity.this,Login_Activity.class);
                        startActivity(intent);
                        Toast.makeText(Regist_Activity.this,"该用户已经注册！",Toast.LENGTH_SHORT).show();
                    }
                    else if(login_in_result.getResult().equals("wrongimagecode")){
                        Toast.makeText(Regist_Activity.this,"验证码错误！",Toast.LENGTH_SHORT).show();
                    }
                    else{
                        Toast.makeText(Regist_Activity.this,"注册失败，请重新注册！",Toast.LENGTH_SHORT).show();
                    }
                    super.onPostExecute(s);
                }
            }.execute();

        }
    }

    public void getImage_code() {
        volly_request=new Volly_Request(Regist_Activity.this,image_code_URL);
        volly_request.getImageLoader(image_code);
    }
    /**
     * 判断手机号码是否合理
     *
     * @param phoneNums
     */
    private boolean judgePhoneNums(String phoneNums) {
        if (isMatchLength(phoneNums, 11)
                && isMobileNO(phoneNums)) {
            return true;
        }

        return false;
    }

    /**
     * 判断一个字符串的位数
     * @param str
     * @param length
     * @return
     */
    public static boolean isMatchLength(String str, int length) {
        if (str.isEmpty()) {
            return false;
        } else {
            return str.length() == length ? true : false;
        }
    }

    /**
     * 验证手机格式
     */
    public static boolean isMobileNO(String mobileNums) {
        /*
         * 移动：134、135、136、137、138、139、150、151、157(TD)、158、159、187、188
                * 联通：130、131、132、152、155、156、185、186 电信：133、153、180、189、（1349卫通）
        * 总结起来就是第一位必定为1，第二位必定为3或5或8，其他位置的可以为0-9
                */
        String telRegex = "[1][358]\\d{9}";// "[1]"代表第1位为数字1，"[358]"代表第二位可以为3、5、8中的一个，"\\d{9}"代表后面是可以是0～9的数字，有9位。
        if (TextUtils.isEmpty(mobileNums))
            return false;
        else
            return mobileNums.matches(telRegex);
    }

}
