package com.umang.lld.fds.commands;

import com.umang.lld.fds.State;

public interface Command {
    public void apply(State state);
}
