package com.udacity.gradle.builditbigger;

import android.test.AndroidTestCase;
import android.util.Log;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

public class MyTest extends AndroidTestCase {
    private static final String LOG_TAG = MyTest.class.getSimpleName();
    final CountDownLatch signal = new CountDownLatch(1);
    Exception mError = null;

    public void mytest() throws InterruptedException {
        // to run: androidTest -> Run 'All Tests'
        // ref: http://marksunghunpark.blogspot.com/2015/05/how-to-test-asynctask-in-android.html
        // ref: http://stackoverflow.com/questions/34003465/android-unit-testing-with-asynctask
        String result = null;
        EndpointsAsyncTask endpointsAsyncTask = new EndpointsAsyncTask(getContext(), null);

        endpointsAsyncTask.execute();

         /* The testing thread will wait here until the UI thread releases it
          * above with the countDown() or 30 seconds passes and it times out.
          */
        signal.await(30, TimeUnit.SECONDS);

        // The task is done, and now you can assert some things!
        assertTrue("Happiness", true);
        try {
            result = endpointsAsyncTask.get();
            Log.d(LOG_TAG, result);
        } catch (Exception e) {
            e.printStackTrace();
            mError = e;
        }
        assertNull(mError);
        assertNotNull(result);
    }
}