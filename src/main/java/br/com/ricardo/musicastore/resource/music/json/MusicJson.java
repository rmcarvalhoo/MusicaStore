package br.com.ricardo.musicastore.resource.music.json;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Null;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MusicJson {

    @Null(message = "The id field cannot be informed")
    private Integer id;

    @NotBlank(message = "The title must be informed")
    private String title;

    @NotNull(message = "The duration must be informed")
    private Integer duration;
}
