package com.example.zy.happyrun.My_Application;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Log;
import android.util.LruCache;
import android.widget.ImageView;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.ImageRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.zy.happyrun.R;

import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by zy on 2016/8/14.
 */
public class Volly_Request {
    //http://php.weather.sina.com.cn/images/yb3/180_180/baoyu_0.png 天气接口图片
    private String URL;
    private Context context;
    private RequestQueue mQueue;
    public String mStringRequest;
    public Map<String, String> map=new HashMap<>();
    public JSONObject JsonObject=new JSONObject();
    public Bitmap bitmap;
    public Volly_Request(){
        super();
    }
    public Volly_Request(Context context,String URL){
        this.context=context;
        mQueue= Volley.newRequestQueue(context);
        this.URL=URL;
    }
    public Volly_Request(Context context,String URL,Map<String, String> map){
        this.context=context;
        mQueue= Volley.newRequestQueue(context);
        this.URL=URL;
        this.map=map;
    }

    public String getStringRequest(){
        StringRequest stringRequest=new StringRequest(Request.Method.POST, URL,
                new Response.Listener<String>() {
            @Override
            public void onResponse(String s) {
                Log.d("request","s");
                mStringRequest=s;

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError volleyError) {
                Log.e("TAG", volleyError.getMessage(), volleyError);
            }
        }){
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Log.d("request","map");
                return map;
            }
        };
        mQueue.add(stringRequest);
        return "mStringRequest";
    }
    public JSONObject getJsonObjectRequest(){
        JsonObjectRequest jsonRequest=new JsonObjectRequest(Request.Method.POST, URL, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject jsonObject) {
                JsonObject=jsonObject;
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError volleyError) {

            }
        }){
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                return map;
            }
        };
        mQueue.add(jsonRequest);
        return JsonObject;
    }
    public Bitmap getImageRequest(){

        ImageRequest imageRequest = new ImageRequest(URL,
                new Response.Listener<Bitmap>() {
                    @Override
                    public void onResponse(Bitmap response) {
                        bitmap=response;
                        //imageView.setImageBitmap(response);
                    }
                }, 0, 0, Bitmap.Config.RGB_565,
                new Response.ErrorListener() {
                        @Override
                    public void onErrorResponse(VolleyError error) {
                        //imageView.setImageResource(R.drawable.);
                        bitmap= BitmapFactory.decodeResource(context.getResources(),R.mipmap.ic_launcher);

                    }
        });
        mQueue.add(imageRequest);
        return bitmap;
    }
    public void getImageLoader(ImageView imageView){

        ImageLoader imageLoader = new ImageLoader(mQueue,new BitmapCache());
        ImageLoader.ImageListener listener = ImageLoader.getImageListener(imageView,
                R.mipmap.loading, R.mipmap.loading);
        imageLoader.get(URL, listener);
    }

    public class BitmapCache implements ImageLoader.ImageCache {

        private LruCache<String, Bitmap> mCache;

        public BitmapCache() {
            int maxSize = 10 * 1024 * 1024;
            mCache = new LruCache<String, Bitmap>(maxSize) {
                @Override
                protected int sizeOf(String key, Bitmap bitmap) {
                    return bitmap.getRowBytes() * bitmap.getHeight();
                }
            };
        }

        @Override
        public Bitmap getBitmap(String url) {
            return mCache.get(url);
        }

        @Override
        public void putBitmap(String url, Bitmap bitmap) {
            mCache.put(url, bitmap);
        }

    }

}
