/*
   Followed this https://cloud.google.com/tools/android-studio/endpoints/add_module
   For step-by-step instructions on connecting your Android application to this backend module,
   see "App Engine Java Endpoints Module" template documentation at
   https://github.com/GoogleCloudPlatform/gradle-appengine-templates/tree/master/HelloEndpoints
*/

package com.lmcloud.builditbigger.backend;

import com.google.api.server.spi.config.Api;
import com.google.api.server.spi.config.ApiMethod;
import com.google.api.server.spi.config.ApiNamespace;
import com.udacity.gradle.jokes.Joker;

/** An endpoint class we are exposing */
@Api(
  name = "myApi",
  version = "v1",
  namespace = @ApiNamespace(
    ownerDomain = "backend.builditbigger.lmcloud.com",
    ownerName = "backend.builditbigger.lmcloud.com",
    packagePath=""
  )
)
public class MyEndpoint {

    /** A simple endpoint method that takes a name and says Hi back */
    // very tricky, the string after @ApiMethod(name = is the name of the method, not the thing
    // after the "public MyBean"
    @ApiMethod(name = "getBean")
    public MyBean getBean(){
        Joker mJoker = new Joker();
        MyBean myBean = new MyBean(mJoker.generateJoke());
        return myBean;
    }

}
