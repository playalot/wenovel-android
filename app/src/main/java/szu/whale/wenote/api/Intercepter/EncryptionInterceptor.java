package szu.whale.wenote.api.Intercepter;


import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.MediaType;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okio.Buffer;
import szu.whale.wenote.util.encryption.AESEncryption;
import szu.whale.wenote.util.encryption.JsonConversion;
import szu.whale.wenote.util.encryption.RSAEncryption;
import szu.whale.wenote.util.encryption.ReqEncryption;

/**
 * funtion :
 * author  :smallbluewhale.
 * date    :2017/6/20 0020.
 * version :1.0.
 */
public class EncryptionInterceptor implements Interceptor {
    @Override
    public Response intercept(Chain chain) throws IOException {
        Request request = chain.request();
        RequestBody requestBody = request.body();
        Buffer buffer = new Buffer();
        requestBody.writeTo(buffer);
        String newString = buffer.readUtf8();
        try{
            ReqEncryption reqEncryption = new ReqEncryption();
            reqEncryption.setEncode(RSAEncryption.rsaSign(AESEncryption.getKey()));
            reqEncryption.setParam(AESEncryption.AESencrypt(newString, null));
            newString = JsonConversion.toJSON(reqEncryption);
        }
        catch (Exception e){

        }
        MediaType mediaType = MediaType.parse("application/json; charset=utf-8");
        RequestBody encryptionRequestBody = RequestBody.create(mediaType , newString);
        request = request.newBuilder().header("Content-Type", encryptionRequestBody.contentType().toString()).header("Content-Length", String.valueOf(encryptionRequestBody.contentLength())).method(request.method(), encryptionRequestBody).build();
        return chain.proceed(request);
    }
}
