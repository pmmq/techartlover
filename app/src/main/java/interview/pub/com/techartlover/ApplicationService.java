package interview.pub.com.techartlover;

import com.google.gson.Gson;

import interview.pub.com.techartlover.service.FetchService;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Pub on 11/9/2559.
 */

public class ApplicationService {

    private static ApplicationService instance;

    public FetchService service;
    private Retrofit retrofit;

    public static ApplicationService getService(){
        if(instance==null){
            instance = new ApplicationService();
        }
        return instance;
    }

    public ApplicationService() {
        retrofit = new Retrofit.Builder()
                .baseUrl(BuildConfig.SERVICE_URL)
                .addConverterFactory(GsonConverterFactory.create(new Gson()))
                .build();
        service = retrofit.create(FetchService.class);
    }

}
