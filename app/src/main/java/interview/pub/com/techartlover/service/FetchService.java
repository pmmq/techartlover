package interview.pub.com.techartlover.service;

import interview.pub.com.techartlover.BuildConfig;
import interview.pub.com.techartlover.response.PageDetailResponse;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.http.GET;

/**
 * Created by Pub on 11/9/2559.
 */
public interface FetchService {

    String DetailURL = "api.php";

    @GET(BuildConfig.SERVICE_URL+DetailURL)
    Call<PageDetailResponse> getPageDetail();
}
