package com.umang.lld.fds.commands;

import com.umang.lld.fds.State;
import com.umang.lld.fds.filesAndDirectory.Directory;

import java.util.Stack;

public class Pwd implements Command {

    @Override
    public void apply(State state) {
        Directory currentDirectory = state.getWd();
        Stack<String> st = new Stack<>();
        while(currentDirectory.getParentDirectory() != null) {
            st.push(currentDirectory.getName());
            currentDirectory=currentDirectory.getParentDirectory();
        }
        StringBuilder ansStr = new StringBuilder();
        if(st.isEmpty()){
            ansStr.append("/");
        }
        while(!st.isEmpty()){
            ansStr.append("/");
            ansStr.append(st.pop());
        }
        state.setOutput(ansStr.toString());
    }
}
