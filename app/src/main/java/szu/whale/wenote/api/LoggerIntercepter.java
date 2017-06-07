package szu.whale.wenote.api;

import android.text.TextUtils;
import android.util.Log;

import java.io.IOException;
import java.nio.charset.Charset;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okio.Buffer;
import okio.BufferedSource;

/**
 * funtion :
 * author  :smallbluewhale.
 * date    :2017/6/6 0006.
 * version :1.0.
 */
class LoggerIntercepter implements Interceptor {

    private static final String TAG = "LoggerIntercepter";
    private static final Charset UTF_8 = Charset.forName("UTF-8");


    @Override
    public Response intercept(Chain chain) throws IOException {
        Log.d(TAG , "Request");
        Request request = chain.request();
        Response response;
        try{
            long starTime = System.nanoTime();
            response = chain.proceed(request);
            long endTime  = System.nanoTime();
            double interval = (endTime - starTime) / 1e6d;
            String acid = request.url().queryParameter("acid");        //项目中请求头信息参数
            String userID = request.url().queryParameter("userid");    //userid信息
            String type = "";
            switch (request.method()){
                case "GET":
                    type = "GET";
                    break;
                case "POST":
                    type = "POST";
                    break;
                case "DELETE":
                    type = "DELETE";
                    break;
                case "PUT":
                    type = "PUT";
                    break;
            }
            BufferedSource bufferedSource = response.body().source();
            bufferedSource.request(Long.MAX_VALUE);                     //保留所有的body信息
            Buffer buffer = bufferedSource.buffer();

            String logStr = "\n--------------------".concat(TextUtils.isEmpty(acid) ? "" : acid).concat("  begin--------------------\n")
                    .concat(type)
                    .concat("\nacid->").concat(TextUtils.isEmpty(acid) ? "" : acid)
                    .concat("\nuserId->").concat(TextUtils.isEmpty(userID) ? "" : userID)
                    .concat("\nnetwork code->").concat(response.code() + "")
                    .concat("\nurl->").concat(request.url() + "")
                    .concat("\ntime->").concat(interval + "")
                    .concat("\nrequest headers->").concat(request.headers() + "")
                    .concat("request->").concat(bodyToString(request.body()))
                    .concat("\nbody->").concat(buffer.clone().readString(UTF_8));
        }catch (Exception e){
            throw e;
        }
        return chain.proceed(request);
    }

    private static String bodyToString(final RequestBody requestBody){
        try{
            final Buffer buffer = new Buffer();
            requestBody.writeTo(buffer);
            return buffer.readUtf8();
        }catch (final IOException e){
            return "did not work";
        }
    }
}
