package br.com.ricardo.musicastore.resource.musicOfAlbum.json;

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
public class MusicOfAlbumJson {

    @Null(message = "The id field cannot be informed")
    private Integer id;

    @NotNull(message = "The musicId must be informed")
    private Integer musicId;

    @NotNull(message = "The duration must be informed")
    private Integer albumId;
}
