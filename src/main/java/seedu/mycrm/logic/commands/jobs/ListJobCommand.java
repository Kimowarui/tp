package seedu.mycrm.logic.commands.jobs;

import static java.util.Objects.requireNonNull;

import java.util.function.Predicate;

import seedu.mycrm.logic.commands.Command;
import seedu.mycrm.logic.commands.CommandResult;
import seedu.mycrm.logic.commands.CommandType;
import seedu.mycrm.logic.commands.exceptions.CommandException;
import seedu.mycrm.model.Model;
import seedu.mycrm.model.job.Job;

public class ListJobCommand extends Command {
    public static final String SHOW_ALL_FLAG = "-a";
    public static final String SHOW_COMPLETED_FLAG = "-c";

    public static final String COMMAND_WORD = "listJob";

    public static final String MESSAGE_USAGE = COMMAND_WORD
        + ": Lists all incomplete jobs by default\n"
        + "Flags to modify list of jobs displayed (only one flag allowed at a time): \n"
        + SHOW_ALL_FLAG + ": to show all jobs\n"
        + SHOW_COMPLETED_FLAG + ": to show only completed jobs\n"
        + "Example: " + COMMAND_WORD + " 1";

    public static final String MESSAGE_SUCCESS = "Listed all pending jobs";

    private static final CommandType COMMAND_TYPE = CommandType.JOBS;

    private final Predicate<Job> listPredicate;

    /**
     * Creates an ListJobCommand to list jobs matching the {@code listPredicate}.
     */
    public ListJobCommand(Predicate<Job> listPredicate) {
        requireNonNull(listPredicate);
        this.listPredicate = listPredicate;
    }

    @Override
    public CommandResult execute(Model model) throws CommandException {
        requireNonNull(model);
        model.updateFilteredJobList(listPredicate);
        return new CommandResult(MESSAGE_SUCCESS, COMMAND_TYPE);
    }

    @Override
    public CommandType getType() {
        return COMMAND_TYPE;
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
            || (other instanceof ListJobCommand // instanceof handles nulls
            && listPredicate.equals(((ListJobCommand) other).listPredicate)); // state check
    }
}