package com.test123.retrofitmvpdemo.api;



import com.test123.retrofitmvpdemo.pojo.SOAnswersResponse;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by pankaj on 22/11/17.
 */

public interface PartnerService {


    @GET("/answers?order=desc&sort=activity&site=stackoverflow")
    Call<SOAnswersResponse> getAnswers();

}
