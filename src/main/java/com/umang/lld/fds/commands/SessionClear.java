package com.umang.lld.fds.commands;

import com.umang.lld.fds.State;
import com.umang.lld.fds.filesAndDirectory.Directory;
import com.umang.lld.fds.filesAndDirectory.RootDirectory;

public class SessionClear implements Command {
    @Override
    public void apply(State state) {
        Directory root = new RootDirectory();
        state.setROOT(root);
        state.setWd(root);
        state.setOutput("SUCC: SESSION CLEARED ");
    }
}
