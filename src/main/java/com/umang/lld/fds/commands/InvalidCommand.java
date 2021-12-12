package com.umang.lld.fds.commands;

import com.umang.lld.fds.State;

public class InvalidCommand implements Command {
    @Override
    public void apply(State state) {
        state.setOutput("Invalid Command");
    }
}
