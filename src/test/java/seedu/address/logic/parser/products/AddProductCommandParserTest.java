package seedu.address.logic.parser.products;

import static seedu.address.commons.core.Messages.MESSAGE_INVALID_COMMAND_FORMAT;
import static seedu.address.logic.commands.CommandTestUtil.INVALID_PRODUCT_NAME_DESC;
import static seedu.address.logic.commands.CommandTestUtil.PRODUCT_DESCRIPTION_DESC;
import static seedu.address.logic.commands.CommandTestUtil.PRODUCT_EMPTY_DESCRIPTION_DESC;
import static seedu.address.logic.commands.CommandTestUtil.PRODUCT_EMPTY_MANUFACTURER_DESC;
import static seedu.address.logic.commands.CommandTestUtil.PRODUCT_EMPTY_TYPE_DESC;
import static seedu.address.logic.commands.CommandTestUtil.PRODUCT_MANUFACTURER_DESC;
import static seedu.address.logic.commands.CommandTestUtil.PRODUCT_NAME_DESC;
import static seedu.address.logic.commands.CommandTestUtil.PRODUCT_TYPE_DESC;
import static seedu.address.logic.commands.CommandTestUtil.VALID_PRODUCT_DESCRIPTION;
import static seedu.address.logic.commands.CommandTestUtil.VALID_PRODUCT_MANUFACTURER;
import static seedu.address.logic.commands.CommandTestUtil.VALID_PRODUCT_NAME;
import static seedu.address.logic.commands.CommandTestUtil.VALID_PRODUCT_TYPE;
import static seedu.address.logic.parser.CommandParserTestUtil.assertParseFailure;
import static seedu.address.logic.parser.CommandParserTestUtil.assertParseSuccess;

import org.junit.jupiter.api.Test;

import seedu.address.logic.commands.products.AddProductCommand;
import seedu.address.model.products.Description;
import seedu.address.model.products.Manufacturer;
import seedu.address.model.products.Product;
import seedu.address.model.products.Type;

public class AddProductCommandParserTest {
    @Test
    public void parse_validArgs_success() {
        // Valid arguments: name, type, manufacturer, description
        assertParseSuccess(new AddProductCommandParser(), PRODUCT_NAME_DESC + PRODUCT_TYPE_DESC
                        + PRODUCT_MANUFACTURER_DESC + PRODUCT_DESCRIPTION_DESC,
                new AddProductCommand(new Product(VALID_PRODUCT_NAME, VALID_PRODUCT_TYPE, VALID_PRODUCT_MANUFACTURER,
                        VALID_PRODUCT_DESCRIPTION)));

        // Valid name, empty type, valid manufacturer, valid description
        assertParseSuccess(new AddProductCommandParser(), PRODUCT_NAME_DESC + PRODUCT_EMPTY_TYPE_DESC
                        + PRODUCT_MANUFACTURER_DESC + PRODUCT_DESCRIPTION_DESC,
                new AddProductCommand(new Product(VALID_PRODUCT_NAME, Type.getEmptyType(),
                        VALID_PRODUCT_MANUFACTURER, VALID_PRODUCT_DESCRIPTION)));

        // Valid name, valid type, empty manufacturer, valid description
        assertParseSuccess(new AddProductCommandParser(), PRODUCT_NAME_DESC + PRODUCT_TYPE_DESC
                        + PRODUCT_EMPTY_MANUFACTURER_DESC + PRODUCT_DESCRIPTION_DESC,
                new AddProductCommand(new Product(VALID_PRODUCT_NAME, VALID_PRODUCT_TYPE,
                        Manufacturer.getEmptyManufacturer(), VALID_PRODUCT_DESCRIPTION)));

        // Valid name, valid type, valid manufacturer, empty description
        assertParseSuccess(new AddProductCommandParser(), PRODUCT_NAME_DESC + PRODUCT_TYPE_DESC
                        + PRODUCT_MANUFACTURER_DESC + PRODUCT_EMPTY_DESCRIPTION_DESC,
                new AddProductCommand(new Product(VALID_PRODUCT_NAME, VALID_PRODUCT_TYPE,
                        VALID_PRODUCT_MANUFACTURER, Description.getEmptyDescription())));
    }

    @Test
    public void parse_invalidArgs_failure() {
        String expectedMessage = String.format(MESSAGE_INVALID_COMMAND_FORMAT, AddProductCommand.MESSAGE_USAGE);

        // Lack of name field
        assertParseFailure(new AddProductCommandParser(), "", expectedMessage);

        // Empty string for name field
        assertParseFailure(new AddProductCommandParser(), INVALID_PRODUCT_NAME_DESC, expectedMessage);
    }
}