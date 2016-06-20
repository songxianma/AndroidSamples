package com.bdqn.sample.files;

import java.io.File;
import java.io.FilenameFilter;

/**
 * Created by teng on 2016/4/29.
 */
public class MyFilenameFilter implements FilenameFilter {
    String type = null;

    public MyFilenameFilter(String type) {
        this.type = type;
    }

    @Override
    public boolean accept(File dir, String name) {
        return name.endsWith(type);
    }
}
