package exercise.dto.users;

import exercise.model.User;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class UserPage {
    private User user;
}
