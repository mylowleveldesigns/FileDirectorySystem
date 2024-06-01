package com.umang.lld.fds.commands;

public class CommandFinder {

    static String SEPARATOR = "/";
    static String SPACE = " ";

    public enum CommandType {
        LS("ls"),
        PWD("pwd"),
        MKDIR("mkdir"),
        CD("cd"),
        RM("rm"),
        SESSION_CLEAR("session clear");

        private final String command;

        CommandType(String command) {
            this.command = command;
        }

        public String getCommand() {
            return command;
        }

        public static CommandType fromString(String command) {
            for (CommandType type : CommandType.values()) {
                if (type.getCommand().equals(command)) {
                    return type;
                }
            }
            return null;
        }
    }

    public static Command findFromString(String input) {
        if (input == null || input.equals("")) {
            return new UnknownCommand();
        }
        String[] tokens = input.split(SPACE);
        if (tokens.length < 1) {
            return new UnknownCommand();
        }
        String commandName = tokens[0];
        CommandType commandType = CommandType.fromString(commandName);
        if (commandType == null) {
            return new UnknownCommand();
        }
        switch (commandType) {
            case LS:
                if (tokens.length == 1) {
                    return new Ls();
                } else return new InvalidCommand();
            case PWD:
                return new Pwd();
            case MKDIR:
                if (tokens.length != 2) {
                    return new InvalidCommand();
                } else return new Mkdir(tokens[1]);
            case CD:
                if (tokens.length != 2) {
                    return new InvalidCommand();
                } else return new Cd(tokens[1]);
            case RM:
                if (tokens.length != 2) {
                    return new InvalidCommand();
                } else return new Rm(tokens[2]);
            case SESSION_CLEAR:
                if (input.equals(CommandType.SESSION_CLEAR.getCommand())) {
                    return new SessionClear();
                }
                return new UnknownCommand();
            default:
                return new UnknownCommand();
        }
    }
}
