package example.org.test.week04day02sol;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import java.util.ArrayList;

import example.org.test.week04day02sol.model.users.Location;
import example.org.test.week04day02sol.model.users.Login;
import example.org.test.week04day02sol.model.users.Picture;
import example.org.test.week04day02sol.model.users.UserResponse;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    public ArrayList<user> userArraylist = new ArrayList<Picture, Login, Location, String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        RetrofitHelper retrofitHelper = new RetrofitHelper();
        retrofitHelper.getRandomUsers("10").enqueue(new Callback<UserResponse>() {
            @Override
            public void onResponse(Call<UserResponse> call, Response<UserResponse> response) {
                Picture picture = response.body().getResults().get(0).getPicture();
                Login userName = response.body().getResults().get(0).getLogin();
                Location address = response.body().getResults().get(0).getLocation();
                String phone = response.body().getResults().get(0).getPhone();
                Log.d("TAG_RETROFIT", "onResponse: " + picture + userName + address + phone);
            }

            @Override
            public void onFailure(Call<UserResponse> call, Throwable t) {

            }
        });

    }
}
