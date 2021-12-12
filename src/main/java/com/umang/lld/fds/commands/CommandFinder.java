package com.umang.lld.fds.commands;

public class CommandFinder {

    static String SEPERATOR = "/";
    static String SPACE = " ";

    private interface allCommands {
        String LS = "ls";
        String PWD = "pwd";
        String MKDIR = "mkdir";
        String CD = "cd";
        String RM = "rm";
        String SESSION_CLEAR = "session clear";
    }

    public static Command findFromString(String input) {
        if (input == null || input.equals("")) {
            return new UnknownCommand();
        }
        String[] tokens = input.split(" ");
        if (tokens.length < 1) {
            return new UnknownCommand();
        }
        String commandName = tokens[0];
        switch (commandName) {
            case allCommands.LS:
                if (tokens.length == 1) {
                    return new Ls();
                } else return new InvalidCommand();
            case allCommands.PWD:
                 return new Pwd();
            case allCommands.MKDIR:
                if (tokens.length != 2) {
                    return new InvalidCommand();
                } else return new Mkdir(tokens[1]);
            case allCommands.CD:
                if (tokens.length != 2) {
                    return new InvalidCommand();
                } else return new Cd (tokens[1]);
            case allCommands.RM:
                if (tokens.length != 2) {
                    return new InvalidCommand();
                } else return new Rm(tokens[2]);
            default:
                if(allCommands.SESSION_CLEAR.equals(input)){
                    return new SessionClear();
                }
                return new UnknownCommand();
        }
    }
}
