package com.onlineshop.comonlineshop.services.impl;

import com.onlineshop.comonlineshop.model.Command;
import com.onlineshop.comonlineshop.repositories.CommandRepository;
import com.onlineshop.comonlineshop.services.CommandService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommandServiceImpl implements CommandService {
private final CommandRepository commandRepository;

    public CommandServiceImpl(CommandRepository commandRepository) {
        this.commandRepository = commandRepository;
    }

    @Override
    public List<Command> getAllCommands() {
        return commandRepository.findAll();
    }

    @Override
    public Command getCommandById(int id) {
       return commandRepository.findById(id).orElseThrow(() -> new RuntimeException("Command not found with id " + id));
    }

    @Override
    public Command createCommand(Command command) {
        return commandRepository.save(command);
    }

    @Override
    public Command updateCommand(Command command) {
        return commandRepository.save(command);
    }

    @Override
    public void deleteCommand(int id) {
    commandRepository.deleteById(id);
    }
}
