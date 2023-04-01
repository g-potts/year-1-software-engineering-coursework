package com.films4you.req4;

import com.films4you.main.RequirementInterface;
import com.films4you.main.TaskNotAttemptedException;
import org.checkerframework.checker.nullness.qual.NonNull;
import org.checkerframework.checker.nullness.qual.Nullable;

/**
 * Your class description here.

 * @author Your name
 *
 */
//4. List top 10 cities by revenue.
public class Requirement implements RequirementInterface {
  
  @Override
  public @Nullable String getValueAsString() {
    throw new TaskNotAttemptedException();
  }

  @Override
  public @NonNull String getHumanReadable() {
    throw new TaskNotAttemptedException();
  }

}
