package com.umang.lld.fds.commands;

import com.umang.lld.fds.State;

public class UnknownCommand implements Command {

    @Override
    public void apply(State state) {
        state.setOutput("Unknown Command");
    }
}
