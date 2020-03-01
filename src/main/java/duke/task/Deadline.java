package duke.task;

import java.time.LocalDateTime;
import java.time.temporal.TemporalAmount;

import duke.exception.DuchessException;
import duke.util.DateTimeStringFormatter;

/**
 * The {@code Deadline} class extends from {@code Task} to allow the setting of
 * a {@code LocalDateTime deadline}.
 */
public class Deadline extends Task {
    protected static final String DEADLINE_SYMBOL = "[D]";
    protected LocalDateTime deadline;

    /**
     * Initialises the {@code Deadline} instance with its description and deadline.
     *
     * @param description Written description of the task.
     * @param deadline    {@code LocalDateTime} object indicating the deadline of
     *                    the task.
     */
    public Deadline(String description, LocalDateTime deadline) {
        super(description);
        this.deadline = deadline;
    }

    /**
     * Initialises the {@code Deadline} instance with its description, deadline and
     * completion status.
     *
     * @param description Written description of the task.
     * @param deadline    {@code LocalDateTime} object indicating the deadline of
     *                    the task.
     * @param isCompleted {@code boolean} value indicating whether the task is
     *                    completed.
     */
    public Deadline(String description, LocalDateTime deadline, boolean isCompleted) {
        super(description, isCompleted);
        this.deadline = deadline;
    }

    /**
     * Returns the deadline of the {@code Deadline}.
     *
     * @return Deadline in {@code LocalDateTime} format.
     */
    public LocalDateTime getDeadline() {
        return deadline;
    }

    /**
     * Snoozes the deadline by the given amount of time.
     *
     * @param snoozePeriod The amount of time to snooze the deadline for.
     */
    public void snooze(TemporalAmount snoozePeriod) {
        this.deadline = this.deadline.plus(snoozePeriod);
    }

    @Override
    public String toString() {
        return DEADLINE_SYMBOL + super.toString() + " (by: "
                + DateTimeStringFormatter.formatDateTime(this.deadline, this.isCompleted) + ")";
    }

    @Override
    protected Object clone() throws DuchessException {
        Deadline clonedDeadline = (Deadline) super.clone();
        clonedDeadline.deadline = this.deadline; // as LocalDateTime is immutable
        return clonedDeadline;
    }
}
