package paquete.aemet;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.simplexml.SimpleXmlConverterFactory;

public class PeticionesRetrofit {
	static Municipiero m = null;
	static Provinciero p = null;
	static Localidad l = null;
	static Retrofit retrofit = new Retrofit.Builder().baseUrl("http://ovc.catastro.meh.es/")
			.addConverterFactory(SimpleXmlConverterFactory.create()).build();

	static ServicioAEMET service = retrofit.create(ServicioAEMET.class);

	public static void pedirProvincias(Actualizacion a) {

		Call<Provinciero> llamada = service.pedirProvincias();

		llamada.enqueue(new Callback<Provinciero>() {

			@Override
			public void onResponse(Call<Provinciero> call, Response<Provinciero> response) {
				p = response.body();

				a.recuperardatosProvincias(p);
			}

			@Override
			public void onFailure(Call<Provinciero> call, Throwable t) {
				// TODO Auto-generated method stub
				System.out.println("Ha habido un fallo: " + t.getMessage());
			}

		});

	}

	public static void pedirMunicipios(Actualizacion a, String provincia) {

		Call<Municipiero> llamada = service.pedirMunicipios(provincia, "");

		llamada.enqueue(new Callback<Municipiero>() {

			@Override
			public void onResponse(Call<Municipiero> call, Response<Municipiero> response) {
				m = response.body();

				a.recuperardatosMunicipios(m);
			}

			@Override
			public void onFailure(Call<Municipiero> call, Throwable t) {
				// TODO Auto-generated method stub
				System.out.println("Ha habido un fallo: " + t.getMessage());
			}

		});

	}

	public static void pedirLocalidad(Actualizacion a, String codLocalidad) {
		Retrofit retrofit2 = new Retrofit.Builder().baseUrl("https://www.aemet.es/xml/municipios/")
				.addConverterFactory(SimpleXmlConverterFactory.create()).build();

		ServicioAEMET service2 = retrofit2.create(ServicioAEMET.class);
		Call<Localidad> llamada = service2.pedriLocalidad(codLocalidad);

		llamada.enqueue(new Callback<Localidad>() {

			@Override
			public void onResponse(Call<Localidad> call, Response<Localidad> response) {
				l = response.body();
				a.recuperardatosLocalidad(l);
			}

			@Override
			public void onFailure(Call<Localidad> call, Throwable t) {
				// TODO Auto-generated method stub
				System.out.println("Ha habido un fallo: " + t.getMessage());
			}

		});

	}

	public interface Actualizacion {
		public void recuperardatosProvincias(Provinciero p);

		public void recuperardatosMunicipios(Municipiero m);

		public void recuperardatosLocalidad(Localidad l);
	}
}
