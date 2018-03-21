package com.brainzerstech.asyncsample;

import android.os.AsyncTask;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by ebsadmin on 21/03/18.
 */

public class BackgroundTask extends AsyncTask<String, String, String> {
    @Override
    protected String doInBackground(String... strings) {
        String response = "";
        URL url = null;
        HttpURLConnection urlConnection = null;
        try {
            url = new URL("https://api.myjson.com/bins/rk2kr");
            urlConnection = (HttpURLConnection) url.openConnection();
            urlConnection.setRequestMethod("GET");
            InputStream in = new BufferedInputStream(urlConnection.getInputStream());
            BufferedReader br = new BufferedReader(new InputStreamReader((urlConnection.getInputStream())));
            StringBuilder sb = new StringBuilder();
            String output;
            while ((output = br.readLine()) != null) {
                response = output;
                sb.append(output);
                return sb.toString();
        }
        }catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            urlConnection.disconnect();
        }
        return response;
    }

    @Override
    protected void onPostExecute(String s) {
        super.onPostExecute(s);
        MainActivity.mtextvieView.setText(s);
    }
}
