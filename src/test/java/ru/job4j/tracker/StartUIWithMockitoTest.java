package ru.job4j.tracker;

import org.junit.jupiter.api.Test;
import ru.job4j.tracker.action.*;
import ru.job4j.tracker.input.Input;
import ru.job4j.tracker.output.Output;
import ru.job4j.tracker.output.StubOutput;

import java.sql.SQLException;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class StartUIWithMockitoTest {
    private final String ln = System.lineSeparator();

    private record TestContext(Output output, MemTracker memTracker, Item item, Input input) {
    }

    private TestContext createTestContext(String itemName) {
        Output output = new StubOutput();
        MemTracker memTracker = new MemTracker();
        Item item = memTracker.add(new Item(itemName));
        Input input = mock(Input.class);
        return new TestContext(output, memTracker, item, input);
    }

    @Test
    public void whenItemWasReplacedSuccessfully() throws SQLException {
        TestContext context = createTestContext("Replaced item");
        EditAction replaceAction = new EditAction(context.output());

        when(context.input().askInt(any(String.class))).thenReturn(1);
        when(context.input().askStr(any(String.class))).thenReturn("New item name");

        replaceAction.execute(context.input(), context.memTracker);

        assertThat(context.output().toString()).isEqualTo(
                "=== Edit item ===" + ln + "Заявка изменена успешно." + ln
        );
    }

    @Test
    public void whenItemWasReplacedNoSuccessfully() throws SQLException {
        TestContext context = createTestContext("Replaced item");
        EditAction replaceAction = new EditAction(context.output());

        replaceAction.execute(context.input(), context.memTracker);

        assertThat(context.output().toString()).isEqualTo(
                "=== Edit item ===" + ln + "Ошибка замены заявки." + ln
        );
    }

    @Test
    public void whenItemWasDeletedSuccessfully() throws SQLException {
        TestContext context = createTestContext("Deleted item");
        DeleteAction deleteAction = new DeleteAction(context.output());

        when(context.input().askInt(any(String.class))).thenReturn(1);

        deleteAction.execute(context.input(), context.memTracker);

        assertThat(context.output().toString()).isEqualTo(
                "=== Delete item ===" + ln + "Заявка удалена успешно." + ln
        );
        assertThat(context.memTracker.findById(1)).isNull();
    }

    @Test
    public void whenItemWasDeletedNoSuccessfully() throws SQLException {
        TestContext context = createTestContext("Deleted item");
        DeleteAction deleteAction = new DeleteAction(context.output());

        when(context.input().askInt(any(String.class))).thenReturn(999);

        deleteAction.execute(context.input(), context.memTracker);

        assertThat(context.output().toString()).isEqualTo(
                "=== Delete item ===" + ln + "Ошибка удаления заявки." + ln
        );
        assertThat(context.memTracker.findById(1)).isNotNull();
    }

    @Test
    public void whenItemWasFoundByIdSuccessfully() throws SQLException {
        TestContext context = createTestContext("Found item");
        FindByIdAction findAction = new FindByIdAction(context.output());

        when(context.input().askInt(any(String.class))).thenReturn(1);

        findAction.execute(context.input(), context.memTracker);

        assertThat(context.output().toString()).isEqualTo(
                "=== Find item by id ===" + ln + context.item + ln
        );
    }

    @Test
    public void whenItemWasFoundByIdNoSuccessfully() throws SQLException {
        TestContext context = createTestContext("Some item");
        FindByIdAction findAction = new FindByIdAction(context.output());

        when(context.input().askInt(any(String.class))).thenReturn(999);

        findAction.execute(context.input(), context.memTracker);

        assertThat(context.output().toString()).isEqualTo(
                "=== Find item by id ===" + ln + "Заявка с введенным id: 999 не найдена." + ln
        );
    }

    private TestContext createTestContextForNameSearch() {
        Output output = new StubOutput();
        MemTracker memTracker = new MemTracker();
        Input input = mock(Input.class);
        return new TestContext(output, memTracker, null, input);
    }

    @Test
    public void whenItemsWereFoundByNameSuccessfully() throws SQLException {
        TestContext context = createTestContextForNameSearch();
        Item item1 = context.memTracker.add(new Item("test"));
        Item item2 = context.memTracker.add(new Item("test"));
        context.memTracker.add(new Item("other"));

        FindByNameAction findAction = new FindByNameAction(context.output());

        when(context.input().askStr(any(String.class))).thenReturn("test");

        findAction.execute(context.input(), context.memTracker);

        assertThat(context.output().toString()).isEqualTo(
                "=== Find items by name ===" + ln + item1 + ln + item2 + ln
        );
    }

    @Test
    public void whenItemsWereFoundByNameNoSuccessfully() throws SQLException {
        TestContext context = createTestContext("test");
        FindByNameAction findAction = new FindByNameAction(context.output());

        when(context.input().askStr(any(String.class))).thenReturn("nonexistent");

        findAction.execute(context.input(), context.memTracker);

        assertThat(context.output().toString()).isEqualTo(
                "=== Find items by name ===" + ln + "Заявки с именем: nonexistent не найдены." + ln
        );
    }
}
