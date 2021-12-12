package com.umang.lld.fds.filesAndDirectory;

public class File extends DirEntry {

    String fileContent;
    Long createdAt;

    public File(Directory parentDirectory, String name, String fileContent) {
        super(parentDirectory, name);
        this.fileContent = fileContent;
        this.createdAt = System.currentTimeMillis();
    }

    @Override
    public Boolean isFile() {
        return true;
    }

    @Override
    public Boolean isDirectory() {
        return false;
    }


}
