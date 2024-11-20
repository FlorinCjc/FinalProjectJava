package com.onlineshop.comonlineshop.services;

import com.onlineshop.comonlineshop.model.Command;

import java.util.List;

public interface CommandService {
    List<Command> getAllCommands();
    Command getCommandById(int id);

    Command createCommand(Command command);

    Command updateCommand(Command command);

    void deleteCommand(int id);
}
