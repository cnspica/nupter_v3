package org.nupter.nupter.utils;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;

/**
 * ��ȡ�Ͼ�����������
 * @author <a href="mailto:lxyweb@gmail.com">Lin xiangyu</a>
 *
 * ʹ�����й���������̨��API
 * ������Դ��ַѡ��:
 * - http://www.weather.com.cn/data/sk/101190101.html ����ǰ������
 * - http://m.weather.com.cn/data/101190101.html ��δ������Ԥ����
 * - http://www.weather.com.cn/data/cityinfo/101190101.html (��ǰ����)
 *
 */
public class Weather {

    public static final String NOW_WEATHER_URL_1 = "http://www.weather.com.cn/data/sk/101190101.html";
    public static final String FUTURE_WEATHER_URL = "http://m.weather.com.cn/data/101190101.html";
    public static final String NOW_WEATHER_URL_2 = "http://www.weather.com.cn/data/cityinfo/101190101.html";


    public String getNanjingWeather(){
        AsyncHttpClient client = new AsyncHttpClient();
        client.get(NOW_WEATHER_URL_1, new AsyncHttpResponseHandler() {
            @Override
            public void onSuccess(String response) {
                Log.d(response);

            }

            @Override
            public void onFailure(Throwable throwable, String s) {

            }
        });

        return "";
    }
}
