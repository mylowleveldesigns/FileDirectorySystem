package com.umang.lld.fds;

import com.umang.lld.fds.filesAndDirectory.Directory;

public class State {
    final String SHELL_TOKEN = "$";

    private Directory ROOT;
    private String output;
    private Directory wd;

    public Directory getROOT() {
        return ROOT;
    }

    public void setROOT(Directory ROOT) {
        this.ROOT = ROOT;
    }

    public String getOutput() {
        return output;
    }

    public void setOutput(String output) {
        this.output = output;
    }

    public Directory getWd() {
        return wd;
    }

    public void setWd(Directory wd) {
        this.wd = wd;
    }

    public State(Directory root) {
        this.wd = root;
        this.ROOT = root;
    }
}
