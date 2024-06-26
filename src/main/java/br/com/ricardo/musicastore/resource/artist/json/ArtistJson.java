package br.com.ricardo.musicastore.resource.artist.json;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Null;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ArtistJson {

    @Null(message = "The id cannot be informed")
    private Integer id;

    @NotBlank(message = "The name must be informed")
    private String name;

    @NotBlank(message = "The nationality field must be informed")
    private String nationality;

    @NotBlank(message = "The site field must be informed")
    private String site;

    @NotBlank(message = "The image field must be informed")
    private String image;
}
