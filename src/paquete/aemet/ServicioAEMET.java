package paquete.aemet;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface ServicioAEMET {
	@GET("ovcservweb/ovcswlocalizacionrc/ovccallejero.asmx/ConsultaProvincia")
	Call<Provinciero> pedirProvincias();
	
	
	//?Provincia=&Municipio="
	@GET("ovcservweb/ovcswlocalizacionrc/ovccallejero.asmx/ConsultaMunicipio")
	Call<Municipiero> pedirMunicipios(@Query("Provincia") String provincia, @Query("Municipio") String municipio);
	
	//https://www.aemet.es/xml/municipios/
    @GET("localidad_{localidad}.xml")
    Call<Localidad> pedriLocalidad(@Path("localidad") String localidad);
}