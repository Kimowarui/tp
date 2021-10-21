package seedu.mycrm.logic.commands.contacts;

import static java.util.Objects.requireNonNull;
import static seedu.mycrm.model.Model.PREDICATE_SHOW_ALL_CONTACTS;

import java.util.function.Predicate;

import seedu.mycrm.logic.commands.Command;
import seedu.mycrm.logic.commands.CommandResult;
import seedu.mycrm.logic.commands.CommandType;
import seedu.mycrm.model.Model;
import seedu.mycrm.model.contact.Contact;

/**
 * Lists all contacts in the myCrm to the user.
 */
public class ListContactCommand extends Command {

    public static final String COMMAND_WORD = "listContact";

    public static final String MESSAGE_SUCCESS = "Here are the listed all contacts:";
    public static final String MESSAGE_USAGE = COMMAND_WORD + ": Lists all unhidden contact by default. "
            + "If a user types in '-a', MyCRM will also list hidden contact. "
            + "Parameters: [-a]\n"
            + "Example: " + COMMAND_WORD + "-a";;

    private static final CommandType COMMAND_TYPE = CommandType.CONTACTS;

    private final Predicate<Contact> listPredicate;

    public ListContactCommand() {
        this.listPredicate = PREDICATE_SHOW_ALL_CONTACTS;
    }

    public ListContactCommand(Predicate<Contact> listPredicate) {
        this.listPredicate = listPredicate;
    }

    @Override
    public CommandResult execute(Model model) {
        requireNonNull(model);
        model.updateFilteredContactList(listPredicate);
        return new CommandResult(MESSAGE_SUCCESS, COMMAND_TYPE);
    }

    @Override
    public CommandType getType() {
        return COMMAND_TYPE;
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof ListContactCommand // instanceof handles nulls
                && listPredicate.equals(((ListContactCommand) other).listPredicate)); // state check
    }
}