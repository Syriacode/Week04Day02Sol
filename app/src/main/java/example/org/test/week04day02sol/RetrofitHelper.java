package example.org.test.week04day02sol;

import example.org.test.week04day02sol.model.users.UserResponse;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Query;

import static example.org.test.week04day02sol.UrlConstants.BASE_URL;
import static example.org.test.week04day02sol.UrlConstants.PATH;
import static example.org.test.week04day02sol.UrlConstants.QUERY_RESULTS;

public class RetrofitHelper {
    private Retrofit getRetrofitClient(){
        return new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    private GetRandomUsers getUserResponse(){
        return getRetrofitClient().create(GetRandomUsers.class);
    }

    public Call<UserResponse> getRandomUsers(String numOfResponses) {
        return getUserResponse().getRandomUsers("10");
    }


    public interface GetRandomUsers{
        @GET(PATH)
        Call<UserResponse> getRandomUsers(@Query(QUERY_RESULTS) String numOfResponse);
    }
}
