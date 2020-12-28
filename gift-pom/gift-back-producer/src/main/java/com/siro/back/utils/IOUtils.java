package com.siro.back.utils;

import java.io.Closeable;
import java.io.IOException;

/**
 * @author mshcc
 */
public class IOUtils {

    /**
     * 关闭对象，连接
     * @param closeable
     */
    public static void closeQuietly(final Closeable closeable) {
        try {
            if (closeable != null) {
                closeable.close();
            }
        } catch (final IOException ioe) {
            // ignore
        }
    }
}
