package id.rama17030009.infocovid.api;

import id.rama17030009.infocovid.model.CountryModel;
import id.rama17030009.infocovid.model.RingkasanModel;
import id.rama17030009.infocovid.model.RiwayatModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;



public interface ApiEndPoint {

    @GET(Api.END_POINT_WORLD_HISTORY)
    Call<List<RiwayatModel>> getHistoryList(@Path("date") String date);

    @GET(Api.END_POINT_SUMMARY_WORLD)
    Call<RingkasanModel> getSummaryWorld();

    @GET(Api.END_POINT_IDN)
    Call<CountryModel> getSummaryIdn();

}
