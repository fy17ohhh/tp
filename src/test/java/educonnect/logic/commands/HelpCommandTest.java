package educonnect.logic.commands;

import static educonnect.logic.commands.CommandTestUtil.assertCommandSuccess;
import static educonnect.logic.commands.HelpCommand.SHOWING_HELP_MESSAGE;

import org.junit.jupiter.api.Test;

import educonnect.model.Model;
import educonnect.model.ModelManager;

public class HelpCommandTest {

    private static final String[] VALID_COMMANDS =
    {"add", "clear", "delete", "edit", "find", "list", "", "slots", "copy"};
    private Model model = new ModelManager();
    private Model expectedModel = new ModelManager();

    @Test
    public void execute_helpNoArgs_success() {
        CommandResult expectedCommandResult = new CommandResult(SHOWING_HELP_MESSAGE, true, false);
        assertCommandSuccess(new HelpCommand(), model, expectedCommandResult, expectedModel);
    }

    @Test
    public void execute_helpValidArgs_success() {
        String validArg = VALID_COMMANDS[3];
        CommandResult expectedCommandResult = new CommandResult(EditCommand.MESSAGE_USAGE);
        assertCommandSuccess(new HelpCommand(validArg), model, expectedCommandResult, expectedModel);
    }
}
