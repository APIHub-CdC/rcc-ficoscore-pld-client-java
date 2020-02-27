package io.RCCFicoScorePLD.client.api;

import io.RCCFicoScorePLD.client.ApiClient;
import io.RCCFicoScorePLD.client.ApiException;
import io.RCCFicoScorePLD.client.model.CatalogoEstados;
import io.RCCFicoScorePLD.client.model.Consultas;
import io.RCCFicoScorePLD.client.model.Creditos;
import io.RCCFicoScorePLD.client.model.DomicilioPeticion;
import io.RCCFicoScorePLD.client.model.DomiciliosRespuesta;
import io.RCCFicoScorePLD.client.model.Empleos;
import io.RCCFicoScorePLD.client.model.Mensajes;
import io.RCCFicoScorePLD.client.model.PersonaPeticion;
import io.RCCFicoScorePLD.client.model.Respuesta;
import io.RCCFicoScorePLD.client.model.Scores;
import io.RCCFicoScorePLD.interceptor.SignerInterceptor;
import okhttp3.OkHttpClient;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.junit.Before;
import org.junit.Assert;

import java.util.concurrent.TimeUnit;

public class ApiTest {
	private final RCCFicoScorePLDApi api = new RCCFicoScorePLDApi();
	private Logger logger = LoggerFactory.getLogger(ApiTest.class.getName());

	private ApiClient apiClient;

	@Before()
	public void setUp() {
		this.apiClient = api.getApiClient();
		this.apiClient.setBasePath("the_url");
		OkHttpClient okHttpClient = new OkHttpClient().newBuilder()
			    .readTimeout(30, TimeUnit.SECONDS)
			    .addInterceptor(new SignerInterceptor())
			    .build();
		apiClient.setHttpClient(okHttpClient);
	}

	@Test
	public void getReporteTest() throws ApiException {
		
		String xApiKey = "your_api_key";
		String username = "your_username";
		String password = "your_password";
		Boolean xFullReport = false;

		PersonaPeticion persona = new PersonaPeticion();
		DomicilioPeticion domicilio = new DomicilioPeticion();
		
		persona.setApellidoPaterno("PATERNO");
		persona.setApellidoMaterno("MATERNO");
		persona.setApellidoAdicional(null);
		persona.setPrimerNombre("PRIMERNOMBRE");
	    persona.setSegundoNombre(null);
	    persona.setFechaNacimiento("1952-05-13");
	    persona.setRFC("PAMP010101");
	    persona.setCURP(null);
	    persona.setNacionalidad("MX");
	    persona.setResidencia(null);
	    persona.setEstadoCivil(null);
	    persona.setSexo(null);
	    persona.setClaveElectorIFE(null);
	    persona.setNumeroDependientes(null);
	    persona.setFechaDefuncion(null);
	    persona.setDomicilio(null);
		
	    
		domicilio.setDireccion("HIDALGO 32");
		domicilio.setColoniaPoblacion("CENTRO");
		domicilio.setDelegacionMunicipio("LA BARCA");
		domicilio.setCiudad("BENITO JUAREZ");
		domicilio.setEstado(CatalogoEstados.JAL);
		domicilio.setCP("47917");
		domicilio.setFechaResidencia(null);
		domicilio.setNumeroTelefono(null);
		domicilio.setTipoDomicilio(null);
		domicilio.setTipoAsentamiento(null);
		
		persona.setDomicilio(domicilio);
		
		Respuesta response = api.getReporte(xApiKey, username, password, persona, xFullReport);

		Assert.assertTrue(response.getFolioConsulta() != null);
		
		logger.info(response.toString());

		if (response.getFolioConsulta() != null && !xFullReport ) {
			String folioConsulta = response.getFolioConsulta();

			Consultas consultas2 = api.getConsultas(folioConsulta, xApiKey, username, password);
			Assert.assertTrue(consultas2.getConsultas() != null);

			Creditos creditos = api.getCreditos(folioConsulta, xApiKey, username, password);
			Assert.assertTrue(creditos.getCreditos() != null);

			DomiciliosRespuesta domicilios = api.getDomicilios(folioConsulta, xApiKey, username, password);
			Assert.assertTrue(domicilios.getDomicilios() != null);

			Empleos empleos = api.getEmpleos(folioConsulta, xApiKey, username, password);
			Assert.assertTrue(empleos.getEmpleos() != null);

			Scores scores = api.getScores(folioConsulta, xApiKey, username, password);
			Assert.assertTrue(scores.getScores() != null);
			
			Mensajes mensajes = api.getMensajes(folioConsulta, xApiKey, username, password);
			Assert.assertTrue(mensajes.getMensajes() != null);
		}

	}
        
}
