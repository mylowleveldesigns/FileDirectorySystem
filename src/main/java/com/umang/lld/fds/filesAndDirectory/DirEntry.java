package com.umang.lld.fds.filesAndDirectory;

public abstract class DirEntry {
    private Directory parentDirectory;
    private String name;

    public Directory getParentDirectory() {
        return parentDirectory;
    }

    public void setParentDirectory(Directory parentDirectory) {
        this.parentDirectory = parentDirectory;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public DirEntry(Directory parentDirectory, String name) {
        this.parentDirectory = parentDirectory;
        this.name = name;
    }

    public abstract Boolean isFile();

    public abstract Boolean isDirectory();
}
