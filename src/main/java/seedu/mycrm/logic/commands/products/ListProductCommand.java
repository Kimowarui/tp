package seedu.mycrm.logic.commands.products;

import static java.util.Objects.requireNonNull;
import static seedu.mycrm.model.Model.PREDICATE_SHOW_ALL_PRODUCTS;

import seedu.mycrm.logic.commands.Command;
import seedu.mycrm.logic.commands.CommandResult;
import seedu.mycrm.logic.commands.CommandType;
import seedu.mycrm.model.Model;

/**
 * Lists all products in MyCrm to the user.
 */
public class ListProductCommand extends Command {

    public static final String COMMAND_WORD = "listProduct";

    public static final String MESSAGE_SUCCESS = "Listed all products";

    private static final CommandType COMMAND_TYPE = CommandType.PRODUCTS;

    @Override
    public CommandResult execute(Model model) {
        requireNonNull(model);

        model.updateFilteredProductList(PREDICATE_SHOW_ALL_PRODUCTS);
        return new CommandResult(MESSAGE_SUCCESS, COMMAND_TYPE);
    }

    @Override
    public CommandType getType() {
        return COMMAND_TYPE;
    }
}