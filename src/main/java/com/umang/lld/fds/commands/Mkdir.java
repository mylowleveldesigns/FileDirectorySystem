package com.umang.lld.fds.commands;

import com.umang.lld.fds.State;
import com.umang.lld.fds.filesAndDirectory.DirEntry;
import com.umang.lld.fds.filesAndDirectory.Directory;

import java.util.List;

public class Mkdir implements Command{
    String args;

    public Mkdir(String args) {
        this.args = args;
    }

    @Override
    public void apply(State state) {
        Directory currentDirectory = state.getWd();

        Directory newDirectory = new Directory(currentDirectory, args);

        List<DirEntry> contents = currentDirectory.getContents();
        for(DirEntry content: contents){
            if(content.isDirectory() && content.getName().equals(args)){
                state.setOutput("ERR: DIRECTORY ALREADY EXISTS");
                return;
            }
        }
        contents.add(newDirectory);
        state.setOutput("SUCC: CREATED");
    }
}
