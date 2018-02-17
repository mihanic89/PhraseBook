package xyz.yapapa.phrasebook;

import android.content.Context;

import com.bumptech.glide.Glide;

/**
 * Created by Misha on 17.02.2018.
 */

public abstract class GlideSingleton {

    private static volatile GlideRequests glide;

    static synchronized GlideRequests getGlide(final Context context){
        if (glide==null){
               glide= GlideApp.with(context);
        }
        return glide;
    }
}
