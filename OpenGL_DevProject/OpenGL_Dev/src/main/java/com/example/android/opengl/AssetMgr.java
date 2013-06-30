
package com.example.android.opengl;
import android.content.Context;
import android.content.res.AssetManager;
import android.util.Log;

import java.io.IOException;
import java.io.InputStream;

public class AssetMgr{

    private static final String TAG = AssetMgr.class.getSimpleName();

    private Context aContext = null;
    private AssetManager sbAssets = null;

    public static AssetMgr create (Context aContext) {
        return new AssetMgr(aContext);
    }

    public AssetMgr ( Context aContext) {
        this.setContext( aContext);
        this.setSbAssets( this.getContext ().getAssets());
    }

    public StringBuilder readShader (String shader) {
        try {
            InputStream is = getSbAssets().open(shader, AssetManager.ACCESS_BUFFER);
            int bytesRead = 0;
            byte[] buffer = new byte[256];
            StringBuilder data = new StringBuilder();
            while ( (bytesRead = is.read(buffer, 0, buffer.length)) > 0) {
                data.append( new String (buffer, 0, bytesRead));
            }

            return data;
        } catch (IOException ex) {
            Log.e(TAG, ex.getMessage(), ex);
        } catch (Exception ex) {
            Log.e(TAG, ex.getMessage(), ex);
        }
        return null;
    }

    public void setContext (Context aContext) {
        this.aContext = aContext;
    }

    public Context getContext () {
        return aContext;
    }

    public void setSbAssets ( AssetManager sbAssets) {
        this.sbAssets = sbAssets;
    }

    public AssetManager getSbAssets () {
        return sbAssets;
    }

}