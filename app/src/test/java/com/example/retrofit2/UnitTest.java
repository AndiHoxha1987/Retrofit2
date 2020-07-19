package com.example.retrofit2;

import org.junit.Test;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertNotNull;
import static junit.framework.TestCase.assertTrue;

public class UnitTest {

    private JsonPlaceHolderApi jsonPlaceHolderApi = ServiceGenerator.createService(JsonPlaceHolderApi.class);


    @Test
    public void setJsonPlaceHolderApi() throws Exception {
        assertNotNull(jsonPlaceHolderApi);
    }

    @Test
    public void testCallJsonPlaceHolderApiDelete() throws Exception {
        Call<Void> call = jsonPlaceHolderApi.deletePost(5);
        assertNotNull(call);
        call.enqueue(new Callback<Void>() {
            @Override
            public void onResponse(Call<Void> call, Response<Void> response) {
                assertTrue(response.isSuccessful());
            }

            @Override
            public void onFailure(Call<Void> call, Throwable t) {
            }
        });
    }

}
