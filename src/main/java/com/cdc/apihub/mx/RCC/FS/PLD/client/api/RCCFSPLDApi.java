package com.cdc.apihub.mx.RCC.FS.PLD.client.api;

import com.google.gson.reflect.TypeToken;
import com.cdc.apihub.mx.RCC.FS.PLD.client.ApiClient;
import com.cdc.apihub.mx.RCC.FS.PLD.client.ApiException;
import com.cdc.apihub.mx.RCC.FS.PLD.client.ApiResponse;
import com.cdc.apihub.mx.RCC.FS.PLD.client.Configuration;
import com.cdc.apihub.mx.RCC.FS.PLD.client.Pair;
import com.cdc.apihub.mx.RCC.FS.PLD.client.ProgressRequestBody;
import com.cdc.apihub.mx.RCC.FS.PLD.client.ProgressResponseBody;
import com.cdc.apihub.mx.RCC.FS.PLD.client.model.Consultas;
import com.cdc.apihub.mx.RCC.FS.PLD.client.model.Creditos;
import com.cdc.apihub.mx.RCC.FS.PLD.client.model.DomiciliosRespuesta;
import com.cdc.apihub.mx.RCC.FS.PLD.client.model.Empleos;
import com.cdc.apihub.mx.RCC.FS.PLD.client.model.Mensajes;
import com.cdc.apihub.mx.RCC.FS.PLD.client.model.PersonaPeticion;
import com.cdc.apihub.mx.RCC.FS.PLD.client.model.Respuesta;
import com.cdc.apihub.mx.RCC.FS.PLD.client.model.Scores;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RCCFSPLDApi {
    private ApiClient apiClient;
    public RCCFSPLDApi() {
        this(Configuration.getDefaultApiClient());
    }
    public RCCFSPLDApi(ApiClient apiClient) {
        this.apiClient = apiClient;
    }
    public ApiClient getApiClient() {
        return apiClient;
    }
    public void setApiClient(ApiClient apiClient) {
        this.apiClient = apiClient;
    }
  
    
  
 
   
    
 
    
    public okhttp3.Call getReporteCall(String xApiKey, String username, String password, PersonaPeticion request,  final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = request;
        String localVarPath = "";
        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();
        Map<String, String> localVarHeaderParams = new HashMap<String, String>();
        if (xApiKey != null)
        localVarHeaderParams.put("x-api-key", apiClient.parameterToString(xApiKey));
        if (username != null)
        localVarHeaderParams.put("username", apiClient.parameterToString(username));
        if (password != null)
        localVarHeaderParams.put("password", apiClient.parameterToString(password));

        Map<String, Object> localVarFormParams = new HashMap<String, Object>();
        final String[] localVarAccepts = {
            "application/json"
        };
        final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        if (localVarAccept != null) localVarHeaderParams.put("Accept", localVarAccept);
        final String[] localVarContentTypes = {
            "application/json"
        };
        final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);
        localVarHeaderParams.put("Content-Type", localVarContentType);
        if(progressListener != null) {
            apiClient.getHttpClient().networkInterceptors().add(new okhttp3.Interceptor() {
                @Override
                public okhttp3.Response intercept(okhttp3.Interceptor.Chain chain) throws IOException {
                    okhttp3.Response originalResponse = chain.proceed(chain.request());
                    return originalResponse.newBuilder()
                    .body(new ProgressResponseBody(originalResponse.body(), progressListener))
                    .build();
                }
            });
        }
        String[] localVarAuthNames = new String[] {  };
        return apiClient.buildCall(localVarPath, "POST", localVarQueryParams, localVarCollectionQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAuthNames, progressRequestListener);
    }
    private okhttp3.Call getReporteValidateBeforeCall(String xApiKey, String username, String password, PersonaPeticion request,  final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        if (xApiKey == null) {
            throw new ApiException("Missing the required parameter 'xApiKey' when calling getReporte(Async)");
        }
        if (username == null) {
            throw new ApiException("Missing the required parameter 'username' when calling getReporte(Async)");
        }
        if (password == null) {
            throw new ApiException("Missing the required parameter 'password' when calling getReporte(Async)");
        }
        if (request == null) {
            throw new ApiException("Missing the required parameter 'request' when calling getReporte(Async)");
        }
        
        okhttp3.Call call = getReporteCall(xApiKey, username, password, request, progressListener, progressRequestListener);
        return call;
    }
    
    public Respuesta getReporte(String xApiKey, String username, String password, PersonaPeticion request  ) throws ApiException {
        ApiResponse<Respuesta> resp = getReporteWithHttpInfo(xApiKey, username, password, request );
        return resp.getData();
    }
    
    public ApiResponse<?> getGenericReporte(String xApiKey, String username, String password, PersonaPeticion request ) throws ApiException {
        ApiResponse<?> resp = getReporteWithHttpInfo(xApiKey, username, password, request );
        return resp;
    }
    
    public ApiResponse<Respuesta> getReporteWithHttpInfo(String xApiKey, String username, String password, PersonaPeticion request ) throws ApiException {
        okhttp3.Call call = getReporteValidateBeforeCall(xApiKey, username, password, request,  null, null);
        Type localVarReturnType = new TypeToken<Respuesta>(){}.getType();
        return apiClient.execute(call, localVarReturnType);
    }
    
    public okhttp3.Call getScoresCall(String folioConsulta, String xApiKey, String username, String password, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = null;
        String localVarPath = "/{folioConsulta}/scores"
            .replaceAll("\\{" + "folioConsulta" + "\\}", apiClient.escapeString(folioConsulta.toString()));
        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();
        Map<String, String> localVarHeaderParams = new HashMap<String, String>();
        if (xApiKey != null)
        localVarHeaderParams.put("x-api-key", apiClient.parameterToString(xApiKey));
        if (username != null)
        localVarHeaderParams.put("username", apiClient.parameterToString(username));
        if (password != null)
        localVarHeaderParams.put("password", apiClient.parameterToString(password));
        Map<String, Object> localVarFormParams = new HashMap<String, Object>();
        final String[] localVarAccepts = {
            "application/json"
        };
        final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        if (localVarAccept != null) localVarHeaderParams.put("Accept", localVarAccept);
        final String[] localVarContentTypes = {
            "application/json"
        };
        final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);
        localVarHeaderParams.put("Content-Type", localVarContentType);
        if(progressListener != null) {
            apiClient.getHttpClient().networkInterceptors().add(new okhttp3.Interceptor() {
                @Override
                public okhttp3.Response intercept(okhttp3.Interceptor.Chain chain) throws IOException {
                    okhttp3.Response originalResponse = chain.proceed(chain.request());
                    return originalResponse.newBuilder()
                    .body(new ProgressResponseBody(originalResponse.body(), progressListener))
                    .build();
                }
            });
        }
        String[] localVarAuthNames = new String[] {  };
        return apiClient.buildCall(localVarPath, "GET", localVarQueryParams, localVarCollectionQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAuthNames, progressRequestListener);
    }
    private okhttp3.Call getScoresValidateBeforeCall(String folioConsulta, String xApiKey, String username, String password, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        if (folioConsulta == null) {
            throw new ApiException("Missing the required parameter 'folioConsulta' when calling getScores(Async)");
        }
        if (xApiKey == null) {
            throw new ApiException("Missing the required parameter 'xApiKey' when calling getScores(Async)");
        }
        if (username == null) {
            throw new ApiException("Missing the required parameter 'username' when calling getScores(Async)");
        }
        if (password == null) {
            throw new ApiException("Missing the required parameter 'password' when calling getScores(Async)");
        }
        
        okhttp3.Call call = getScoresCall(folioConsulta, xApiKey, username, password, progressListener, progressRequestListener);
        return call;
    }
    
    public Scores getScores(String folioConsulta, String xApiKey, String username, String password) throws ApiException {
        ApiResponse<Scores> resp = getScoresWithHttpInfo(folioConsulta, xApiKey, username, password);
        return resp.getData();
    }
    
    public ApiResponse<Scores> getScoresWithHttpInfo(String folioConsulta, String xApiKey, String username, String password) throws ApiException {
        okhttp3.Call call = getScoresValidateBeforeCall(folioConsulta, xApiKey, username, password, null, null);
        Type localVarReturnType = new TypeToken<Scores>(){}.getType();
        return apiClient.execute(call, localVarReturnType);
    }
}
