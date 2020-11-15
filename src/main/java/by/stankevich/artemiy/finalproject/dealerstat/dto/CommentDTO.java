package by.stankevich.artemiy.finalproject.dealerstat.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CommentDTO {

    @NotNull
    private UUID id;

    @NotNull
    private String messageText;

    private boolean approved;

    @NotNull
    @Size(min = 1, message = "rating couldn't to be a less than 1")
    @Size(max = 5, message = "rating couldn't to be a greater than 5")
    private int rating;
}
