package com.umang.lld.fds.commands;

import com.umang.lld.fds.State;
import com.umang.lld.fds.filesAndDirectory.DirEntry;
import com.umang.lld.fds.filesAndDirectory.Directory;

import java.util.List;

public class Rm implements Command {
    String args;
    @Override
    public void apply(State state) {
        Directory currentDirectory = state.getWd();
        List<DirEntry> contents = currentDirectory.getContents();
        for(DirEntry cc: contents){
            if(cc.getName().equals(args)){
                contents.remove(cc);
                state.setOutput("SUCC: REMOVED");
                return;
            }
        }
        state.setOutput("ERR: NO SUCH ENTRY TO REMOVE");
    }

    public Rm(String args) {
        this.args = args;
    }
}
