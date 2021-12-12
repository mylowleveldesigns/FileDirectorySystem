package com.umang.lld.fds;

import com.umang.lld.fds.commands.Command;
import com.umang.lld.fds.commands.CommandFinder;
import com.umang.lld.fds.filesAndDirectory.Directory;
import com.umang.lld.fds.filesAndDirectory.RootDirectory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Scanner;

@SpringBootApplication
public class FdsApplication {

	public static void main(String[] args) {
		SpringApplication.run(FdsApplication.class, args);


		Directory root = new RootDirectory();
		State state = new State(root);

		while(true) {
			try {
                System.out.print(state.SHELL_TOKEN);
                Scanner sc = new Scanner(System.in);
				String input = sc.nextLine();
				Command command = CommandFinder.findFromString(input);
				command.apply(state);
				System.out.println(state.getOutput());
			} catch (Exception e){
				System.out.println(e.getMessage());
			}

		}
	}
}
