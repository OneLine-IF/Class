package developer.jkey20.retrofittest;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;

public interface APIService {
    @GET("api/v1/posts/list")
    Call<ArrayList<Notice>> findAll();

}
