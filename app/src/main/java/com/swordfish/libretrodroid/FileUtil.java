package com.swordfish.libretrodroid;

import android.content.Context;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;

public class FileUtil {

    public static void copyFromAsses(Context context, String fileName, String des) {
        InputStream in = null;
        FileOutputStream fo = null;
        try {
            in = context.getAssets().open(fileName);
            File outFile = new File(des);
            if (!outFile.getParentFile().exists()) {
                outFile.getParentFile().mkdirs();
            }
            fo = new FileOutputStream(outFile);

            byte[] buffer = new byte[1024 * 8];
            int len = -1;
            while ((len = in.read(buffer)) != -1) {
                fo.write(buffer, 0, len);
            }
            fo.flush();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (in != null) {
                try {
                    in.close();
                } catch (Exception e) {
                }
            }
            if (fo != null) {
                try {
                    fo.close();
                } catch (Exception e) {
                }
            }
        }
    }

}
