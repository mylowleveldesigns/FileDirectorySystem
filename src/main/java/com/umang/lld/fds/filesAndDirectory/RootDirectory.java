package com.umang.lld.fds.filesAndDirectory;

public class RootDirectory extends Directory {

    public RootDirectory() {
        super(null, "");
    }

    @Override
    public Boolean isFile() {
        return false;
    }

    @Override
    public Boolean isDirectory() {
        return true;
    }
}
