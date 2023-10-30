package com.zhj.chatbot.api;

import org.apache.http.HttpStatus;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.junit.Test;

import java.io.IOException;

/**
 * @author zhj
 * @version 1.0
 * @description 单元测试
 * @date 2023/10/30 20:07
 */
public class ApiTest {

    @Test
    //查询没有处理的提问信息
    public void queryUnansweredQuestion() throws IOException {
        CloseableHttpClient httpClient = HttpClientBuilder.create().build();

        HttpGet get = new HttpGet("https://api.zsxq.com/v2/groups/51112814442814/topics?scope=unanswered_questions&count=20");

        get.addHeader("cookie","zsxq_access_token=4EE17C73-6C72-82DC-366D-B8AD16B60FCE_79E14511AE9880AB; abtest_env=product; zsxqsessionid=53620108054374a7e77a050d7e0d50e4; sensorsdata2015jssdkcross=%7B%22distinct_id%22%3A%22418111182828888%22%2C%22first_id%22%3A%2218aac6aa584fe5-09c3e160da00fb8-78505774-2073600-18aac6aa5851288%22%2C%22props%22%3A%7B%22%24latest_traffic_source_type%22%3A%22%E7%9B%B4%E6%8E%A5%E6%B5%81%E9%87%8F%22%2C%22%24latest_search_keyword%22%3A%22%E6%9C%AA%E5%8F%96%E5%88%B0%E5%80%BC_%E7%9B%B4%E6%8E%A5%E6%89%93%E5%BC%80%22%2C%22%24latest_referrer%22%3A%22%22%7D%2C%22identities%22%3A%22eyIkaWRlbnRpdHlfY29va2llX2lkIjoiMThhYWM2YWE1ODRmZTUtMDljM2UxNjBkYTAwZmI4LTc4NTA1Nzc0LTIwNzM2MDAtMThhYWM2YWE1ODUxMjg4IiwiJGlkZW50aXR5X2xvZ2luX2lkIjoiNDE4MTExMTgyODI4ODg4In0%3D%22%2C%22history_login_id%22%3A%7B%22name%22%3A%22%24identity_login_id%22%2C%22value%22%3A%22418111182828888%22%7D%2C%22%24device_id%22%3A%221866902421265d-0ca673e28086d9-74525476-1327104-18669024213f50%22%7D; __cuid=98d35f6cdb9e49a89588f6bce5cae9d5; amp_fef1e8=3d206ea4-d611-46d5-9b36-9345f7030ef5R...1he0kg9ha.1he0kg9hf.1.1.2");
        get.addHeader("Content-Type","application/json; charset=UTF-8");

        CloseableHttpResponse response = httpClient.execute(get);
        if(response.getStatusLine().getStatusCode()== HttpStatus.SC_OK){
            String res = EntityUtils.toString(response.getEntity());
            System.out.println(res);
        }else{
            System.out.println(response.getStatusLine().getStatusCode());
        }
    }

    @Test
    public void answer() throws IOException {
        CloseableHttpClient httpClient = HttpClientBuilder.create().build();

        HttpPost post = new HttpPost("https://api.zsxq.com/v2/topics/211228121884151/answer");
        post.addHeader("cookie","zsxq_access_token=4EE17C73-6C72-82DC-366D-B8AD16B60FCE_79E14511AE9880AB; abtest_env=product; zsxqsessionid=53620108054374a7e77a050d7e0d50e4; sensorsdata2015jssdkcross=%7B%22distinct_id%22%3A%22418111182828888%22%2C%22first_id%22%3A%2218aac6aa584fe5-09c3e160da00fb8-78505774-2073600-18aac6aa5851288%22%2C%22props%22%3A%7B%22%24latest_traffic_source_type%22%3A%22%E7%9B%B4%E6%8E%A5%E6%B5%81%E9%87%8F%22%2C%22%24latest_search_keyword%22%3A%22%E6%9C%AA%E5%8F%96%E5%88%B0%E5%80%BC_%E7%9B%B4%E6%8E%A5%E6%89%93%E5%BC%80%22%2C%22%24latest_referrer%22%3A%22%22%7D%2C%22identities%22%3A%22eyIkaWRlbnRpdHlfY29va2llX2lkIjoiMThhYWM2YWE1ODRmZTUtMDljM2UxNjBkYTAwZmI4LTc4NTA1Nzc0LTIwNzM2MDAtMThhYWM2YWE1ODUxMjg4IiwiJGlkZW50aXR5X2xvZ2luX2lkIjoiNDE4MTExMTgyODI4ODg4In0%3D%22%2C%22history_login_id%22%3A%7B%22name%22%3A%22%24identity_login_id%22%2C%22value%22%3A%22418111182828888%22%7D%2C%22%24device_id%22%3A%221866902421265d-0ca673e28086d9-74525476-1327104-18669024213f50%22%7D; __cuid=98d35f6cdb9e49a89588f6bce5cae9d5; amp_fef1e8=3d206ea4-d611-46d5-9b36-9345f7030ef5R...1he0kg9ha.1he0kg9hf.1.1.2");
        post.addHeader("Content-Type","application/json; charset=UTF-8");

        String paramJson="{\n" +
                "  \"req_data\": {\n" +
                "    \"text\": \"等于2！\\n\",\n" +
                "    \"image_ids\": [],\n" +
                "    \"silenced\": false\n" +
                "  }\n" +
                "}";

        StringEntity stringEntity = new StringEntity(paramJson, ContentType.create("text/json", "UTF-8"));
        post.setEntity(stringEntity);

        CloseableHttpResponse response = httpClient.execute(post);
        if(response.getStatusLine().getStatusCode()== HttpStatus.SC_OK){
            String res = EntityUtils.toString(response.getEntity());
            System.out.println(res);
        }else{
            System.out.println(response.getStatusLine().getStatusCode());
        }
    }
}
