package com.camarasa.robin.nutritivecoach.Activities.Activities.Stats;

import android.content.Context;
import android.opengl.GLSurfaceView;

/**
 * Created by robin on 15/12/17.
 */

public class MyGLSurfaceView extends GLSurfaceView {
    private final MyGLRenderer mRenderer;

    public MyGLSurfaceView(Context context){
        super(context);

        // Create an OpenGL ES 2.0 context
        setEGLContextClientVersion(2);

        mRenderer = new MyGLRenderer();

        // Set the Renderer for drawing on the GLSurfaceView
        setRenderer(mRenderer);
    }
}
