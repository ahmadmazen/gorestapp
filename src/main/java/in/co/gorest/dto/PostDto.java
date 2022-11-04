package in.co.gorest.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PostDto {
    @JsonProperty("id")
    public Integer id;
    @JsonProperty("user_id")
    public Integer userId;
    @JsonProperty("title")
    public String title;
    @JsonProperty("body")
    public String body;
}
