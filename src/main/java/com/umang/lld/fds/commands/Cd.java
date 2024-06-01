package com.umang.lld.fds.commands;

import com.umang.lld.fds.State;
import com.umang.lld.fds.filesAndDirectory.DirEntry;
import com.umang.lld.fds.filesAndDirectory.Directory;

import java.util.List;

public class Cd implements Command {
    String args;

    public Cd(String args){
        this.args = args;
    }
    @Override
    public void apply(State state) {
        Directory currentDirectory = state.getWd();
        List<DirEntry> contents = currentDirectory.getContents();
        if(args.equals("..")){
            if(currentDirectory.equals(state.getROOT())){
                state.setOutput("ERR: ALREADY IN ROOT");
                return;
            }
            state.setWd(currentDirectory.getParentDirectory());
            state.setOutput("SUCC: REACHED");
            return;
        }
        for(DirEntry cDir: contents){
            if(cDir.isDirectory() && cDir.getName().equals(args)){
                state.setWd((Directory) cDir);
                state.setOutput("SUCC: REACHED");
                return;
            }
        }
        state.setOutput("ERR: NO SUCH DIRECTORY");
    }
}
