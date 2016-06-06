package com.udacity.gradle.builditbigger;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.util.Pair;
import android.view.View;
import android.widget.ProgressBar;

import com.google.api.client.extensions.android.http.AndroidHttp;
import com.google.api.client.extensions.android.json.AndroidJsonFactory;
import com.google.api.client.googleapis.services.AbstractGoogleClientRequest;
import com.google.api.client.googleapis.services.GoogleClientRequestInitializer;
import com.lmcloud.builditbigger.backend.myApi.MyApi;
import com.lmcloud.jokeslibandroid.JokesActivity;

import java.io.IOException;

// reference: https://cloud.google.com/solutions/mobile/google-cloud-endpoints-for-android/#google-cloud-messaging
// reference: https://cloud.google.com/appengine/docs/java/endpoints/helloendpoints-android-studio#connecting_your_android_app_to_the_backend
public class EndpointsAsyncTask extends AsyncTask<Pair<Context, String>, Void, String> {
    private static MyApi myApiService = null;
    private Context mContext;
    private String mResult;
    private ProgressBar mProgressBar;
    String rootUrl = "http://10.0.2.2:8080/_ah/api";
    //String rootUrl = "https://myApplicationId.appspot.com/_ah/api";

    public EndpointsAsyncTask(Context context, ProgressBar progressBar) {
        this.mContext = context;
        this.mProgressBar = progressBar;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        if (mProgressBar != null) {
            mProgressBar.setVisibility(View.VISIBLE);
        }
    }

    @Override
    protected String doInBackground(Pair<Context, String>... params) {
        if (myApiService == null) {// Only do this once
            MyApi.Builder builder = new MyApi.Builder(AndroidHttp.newCompatibleTransport(),
                    new AndroidJsonFactory(), null)
                    // options for running against local devappserver
                    // - 10.0.2.2 is localhost's IP address in Android emulator
                    // - turn off compression when running against local devappserver
                    .setRootUrl(rootUrl)
                    .setGoogleClientRequestInitializer(new GoogleClientRequestInitializer() {
                        @Override
                        public void initialize(AbstractGoogleClientRequest<?> abstractGoogleClientRequest) throws IOException {
                            abstractGoogleClientRequest.setDisableGZipContent(true);
                        }
                    });
            // end options for devappserver
            myApiService = builder.build();
        }

        try {
            return myApiService.getBean().execute().getData();
        } catch (IOException e) {
            return e.getMessage();
        }
    }

    @Override
    protected void onPostExecute(String result) {
        super.onPostExecute(result);
        if (mProgressBar != null) {
            mProgressBar.setVisibility(View.GONE);
        }
        mResult = result;
        Intent intent = new Intent(mContext, JokesActivity.class);
        intent.putExtra(JokesActivity.INTENT_JOKES, result);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        mContext.startActivity(intent);
    }
}
