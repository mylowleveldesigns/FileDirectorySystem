package com.umang.lld.fds.commands;

import com.umang.lld.fds.State;
import com.umang.lld.fds.filesAndDirectory.DirEntry;
import com.umang.lld.fds.filesAndDirectory.Directory;

import java.util.List;

public class Ls implements Command {

    @Override
    public void apply(State state) {
        Directory currentDirectory = state.getWd();
        List<DirEntry> contentNames = currentDirectory.getContents();
        StringBuilder outputStr = new StringBuilder();
        for(DirEntry entry: contentNames) {
            outputStr.append(entry.getName());
            outputStr.append(" ");
        }
        state.setOutput(outputStr.toString());
    }
}
