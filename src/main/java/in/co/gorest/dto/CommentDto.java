package in.co.gorest.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CommentDto {
    @JsonProperty("id")
    public Integer id;
    @JsonProperty("post_id")
    public Integer postId;
    @JsonProperty("name")
    public String name;
    @JsonProperty("email")
    public String email;
    @JsonProperty("body")
    public String body;
}
