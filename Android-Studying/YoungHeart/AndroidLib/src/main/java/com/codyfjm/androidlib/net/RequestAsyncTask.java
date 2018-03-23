package com.codyfjm.androidlib.net;

import android.os.AsyncTask;

import com.alibaba.fastjson.JSON;

import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;
import org.apache.http.util.EntityUtils;

import java.io.IOException;

/**
 * author：codyfjm on 18/3/22
 * email：CodyFeng@lansion.cn
 * company:MIDONG TECHENOLOGY
 * Copyright © 2018 MIDONG TECHENOLOGY All rights reserved.
 */
public abstract class RequestAsyncTask extends AsyncTask<String,Void,Response> {

    /**
     * 请求接口成功的回调
     * @param result 回调的数据
     */
    public abstract void onSuccess(String result);

    /**
     * 请求接口失败的回调
     * @param errorMessage 失败的信息
     */
    public abstract void onFail(String errorMessage);

    @Override
    protected void onPreExecute() {

    }

    @Override
    protected void onPostExecute(Response response) {
        if (response.isError()){
            onFail(response.getErrorMessage());
        }else {
            onSuccess(response.getResult());
        }
    }

    @Override
    protected Response doInBackground(String... url) {
        return getResponseFromURL(url[0]);
    }

    private Response getResponseFromURL(String url) {
        Response response = new Response();
        HttpGet get = new HttpGet(url);
        String strResponse = null;

        try {
            HttpParams httpParams = new BasicHttpParams();
            HttpConnectionParams.setConnectionTimeout(httpParams,8000);
            HttpClient httpClient = new DefaultHttpClient(httpParams);
            HttpResponse httpResponse = httpClient.execute(get);
            if (httpResponse.getStatusLine().getStatusCode() == HttpStatus.SC_OK){
                strResponse = EntityUtils.toString(httpResponse.getEntity());
            }
        } catch (IOException e) {
            response.setErrorType(-1);
            response.setError(true);
            response.setErrorMessage(e.getMessage());
        }

        if (strResponse==null){
            response.setErrorType(-1);
            response.setError(true);
            response.setErrorMessage("网络异常，返回空值");
        }else {
            strResponse = "{'isError':false,'errorType':0,'errorMessage':'','result':{'city':'北京','cityid':'101010100','temp':'17','WD':'西南风','WS':'2级','SD':'54%','WSE':'2','time':'23:15','isRadar':'1','Radar':'JC_RADAR_AZ9010_JB','njd':'暂无实况','qy':'1016'}}";
            response = JSON.parseObject(strResponse,Response.class);
        }


        return response;
    }
}
