package ixigo.invincible.takemethere.haimal.Utils;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;


/**
 * <h1>Networking Class to be used for all API calls, Eg get and Post</h1>
 *
 * @author Haimal Khetan
 * @version 1.0
 * @since 20/4/2016
 */


public class MarshmallowClient {


    /**
     * To send POST API parameters along with the API
     */

    DataOutputStream printout;
    /**
     * Parameter to be sent along with the API in POST API
     */
    JSONObject jsonParam = new JSONObject();
    /**
     * Result status code of the API call, usually 200 for successful API call.
     */

    private int statusCode;
    /**
     * API url to be called
     */

    private String url;


    /**
     * Constructor to initialize the url.
     *
     * @param url url to be hit.
     */
    public MarshmallowClient(String url) {
        LogClass.displayLog("MarshMallow URL", url);
        this.url = url;
    }


    /**
     * To get the status code of the API hit
     */
    public int getStatusCode() {
        return statusCode;
    }


    /**
     * To start the connection with the API for retrieving data.
     *
     * @param method the type of API to hit either GET or POST
     */

    public String Execute(RequestMethod method) throws Exception {

        StringBuilder stringBuilder = new StringBuilder();

        /**
         * For GET API's
         */

        switch (method) {
            case GET: {
                try {
                    URL urlObject = new URL(url);
                    HttpURLConnection urlConnection = (HttpURLConnection) urlObject.openConnection();
                    urlConnection.setRequestMethod("GET");
                    urlConnection.connect();

                    statusCode = urlConnection.getResponseCode();

                    if (statusCode == 200) {
                        InputStream inputStream = urlConnection.getInputStream();
                        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
                        String line;
                        while ((line = reader.readLine()) != null) {
                            stringBuilder.append(line);
                        }
                    } else {
                        LogClass.displayLog("Marshmallow Json", "Failed to Download File, Response code != 200");
                    }
                } catch (IOException e) {
                    LogClass.displayLog("Marshmallow exception", "Exception occured:" + e.getMessage());
                }
                break;
            }


            /**
             * For POST API's
             */

            case POST: {
                try {
                    URL urlObject = new URL(url);
                    HttpURLConnection urlConnection = (HttpURLConnection) urlObject.openConnection();
                    urlConnection.setRequestMethod("POST");
                    urlConnection.setRequestProperty("Content-Type", "application/json");
                    urlConnection.setDoInput(true);
                    urlConnection.setDoOutput(true);
                    urlConnection.setUseCaches(false);
                    urlConnection.connect();

                    LogClass.displayLog("Marshmallow POST Json", jsonParam.toString());

                    printout = new DataOutputStream(urlConnection.getOutputStream());
                    printout.writeBytes(jsonParam.toString());
                    printout.flush();
                    printout.close();

                    statusCode = urlConnection.getResponseCode();

                    if (statusCode == 200) {
                        InputStream inputStream = urlConnection.getInputStream();
                        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
                        String line;
                        while ((line = reader.readLine()) != null) {
                            stringBuilder.append(line);
                        }
                    } else {
                        LogClass.displayLog("Marshmallow Json", "Failed to Download File, Response code != 200");
                    }
                } catch (IOException e) {
                    LogClass.displayLog("Marshmallow exception", "Exception occured:" + e.getMessage());
                }
                break;
            }
        }
        LogClass.displayLog("Marshmallow Response", stringBuilder.toString());
        return stringBuilder.toString();
    }


    /**
     * To Add parameters to the POST API which will be converted to jsonObject
     *
     * @param name  String key used to recognize the value at the server end.
     * @param value String actual parameter to be sent.
     */

    public void AddParam(String name, String value) throws JSONException {
        jsonParam.put(name, value);
    }


    /**
     * To set the already existing jsonObject as parameter. If SetParam is being used, avoid using AddParam simultaneously.
     */

    public void SetParam(JSONObject jsonParam) throws JSONException {
        this.jsonParam = jsonParam;
    }


    /**
     * Enums denoting the type of API.
     */

    public enum RequestMethod {
        GET,
        POST
    }
}