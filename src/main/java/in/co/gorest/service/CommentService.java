package in.co.gorest.service;

import in.co.gorest.client.GorestClient;
import in.co.gorest.client.GorestServiceGenerator;
import in.co.gorest.dto.CommentDto;
import in.co.gorest.dto.PostDto;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import retrofit2.Call;
import retrofit2.Response;

import javax.naming.ServiceUnavailableException;
import javax.xml.stream.events.Comment;
import java.io.IOException;
import java.util.List;

@Service
public class CommentService {

    @Autowired
    private GorestServiceGenerator gorestServiceGenerator;

    public List<CommentDto> getComments() throws Exception {
        try {
            GorestClient gorestClient = gorestServiceGenerator.createService(GorestClient.class);
            Call<List<CommentDto>> call = gorestClient.getComments();
            Response<List<CommentDto>> response = call.execute();
            if (response.isSuccessful()) {
                List<CommentDto> comments = response.body();
                if (CollectionUtils.isNotEmpty(comments)) {
                    return comments;
                }
            }
        } catch (IOException e) {
            throw new ServiceUnavailableException("gorestApi.getCommentsError");

        }
        return null;
    }
    public List<CommentDto> getPostComments(Integer postId) throws Exception {
        try {
            GorestClient gorestClient = gorestServiceGenerator.createService(GorestClient.class);
            Call<List<CommentDto>> call = gorestClient.getPostComments(postId);
            Response<List<CommentDto>> response = call.execute();
            if (response.isSuccessful()) {
                List<CommentDto> postComments = response.body();
                if (CollectionUtils.isNotEmpty(postComments)) {
                    return postComments;
                }
            }
        } catch (IOException e) {
            throw new ServiceUnavailableException("gorestApi.getPostCommentsError");

        }
        return null;
    }
}
