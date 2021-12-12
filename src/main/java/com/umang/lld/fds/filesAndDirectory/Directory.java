package com.umang.lld.fds.filesAndDirectory;

import java.util.ArrayList;

public class Directory extends DirEntry{
    private Long createdAt;
    private ArrayList<DirEntry> contents;


    @Override
    public Boolean isFile() {
        return false;
    }

    @Override
    public Boolean isDirectory() {
        return true;
    }

    public Directory(Directory parentDirectory, String name) {
        super(parentDirectory, name);
        this.contents = new ArrayList<>();
        this.createdAt = System.currentTimeMillis();
    }

    public Long getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Long createdAt) {
        this.createdAt = createdAt;
    }

    public ArrayList<DirEntry> getContents() {
        return contents;
    }

    public void setContents(ArrayList<DirEntry> contents) {
        this.contents = contents;
    }
}
