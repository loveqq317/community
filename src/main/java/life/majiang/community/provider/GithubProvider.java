package life.majiang.community.provider;

import com.alibaba.fastjson.JSON;
import life.majiang.community.dto.AccessTokenDTO;
import life.majiang.community.dto.GithubUser;
import okhttp3.*;
import org.springframework.stereotype.Component;

import java.io.IOException;

/**
 * @ClassName GitHubProvider
 * @Description TODO
 * @Author Q
 * @Date 2020/3/21 4:04 下午
 * @Version 1.0
 **/
@Component
public class GithubProvider {
    public String getAccessToken(AccessTokenDTO accessTokenDTO){
        MediaType mediaType= MediaType.get("application/json; charset=utf-8");
        OkHttpClient client = new OkHttpClient();
        //String json=
        RequestBody body = RequestBody.create(JSON.toJSONString(accessTokenDTO),mediaType);
        Request request = new Request.Builder()
                .url("https://github.com/login/oauth/access_token")
                .post(body)
                .build();
        try (Response response = client.newCall(request).execute()) {
            String responseString=response.body().string();
            System.out.println(responseString);
            //access_token=23468f8edb9d2152aa5c318747ddf726d7c80ffd&scope=user&token_type=bearer
            String[] split=responseString.split("&");
            String tokenString=split[0].split("=")[1];
            System.out.println(tokenString);
            return tokenString;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void main(String[] args) {
        String a="access_token=a8a40e2f20ebe125634e8086935fcb16798b6951&scope=user&token_type=bearer";
        String[] split=a.split("&");
        String tokenString=split[0];
        String token=tokenString.split("=")[1];

        System.out.println(token);
    }
    public GithubUser getUser(String assessToken){
        OkHttpClient client = new OkHttpClient();

        Request request = new Request.Builder()
                .url("https://api.github.com/user?access_token="+assessToken)
                .build();

        try (Response response = client.newCall(request).execute()) {
            String responseString = response.body().string();
            GithubUser githubUser=JSON.parseObject(responseString,GithubUser.class);
            return githubUser;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
