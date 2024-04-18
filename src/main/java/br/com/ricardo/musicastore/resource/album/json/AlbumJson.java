package br.com.ricardo.musicastore.resource.album.json;

import br.com.ricardo.musicastore.resource.artist.json.ArtistJson;
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
public class AlbumJson {

    @Null(message = "The id field cannot be informed")
    private Integer id;

    @NotBlank(message = "The title field must be informed")
    private String title;

    @NotNull(message = "The launchYear field must be informed")
    private Integer launchYear;

    private String image;

    @NotNull(message = "The artistId field must be informed")
    private Integer artistId;

    @Null(message = "The ArtistJson cannot be informed")
    private ArtistJson artist;

}
