package com.RosGramm.server.service;

import com.RosGramm.server.DAO.PostDAO;
import com.RosGramm.server.model.Post;
import com.RosGramm.server.repository.PostRepository;
import com.RosGramm.server.user.User;
import com.RosGramm.server.user.UserRepository;
import lombok.AllArgsConstructor;
import org.apache.commons.io.FileUtils;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;


@AllArgsConstructor
@Service
public class PostServiceImpl implements PostService {

    private final PostRepository postRepository;
    private final UserRepository userRepository;

    private final String uploadPath = "C:\\Users\\vabob\\IdeaProjects\\ServerForRosGramm\\src\\main\\java\\com\\RosGramm\\server\\photos";

    @Override
    public String add(MultipartFile photo, String label, String idUser, Integer counterLike) throws IOException {
        File uploadDir = new File(uploadPath);
        if (!uploadDir.exists()) {
            uploadDir.mkdirs();
        }
        String curDate = LocalDateTime.now().toString();
        String fileName = ("photo_" + curDate + "_" + photo.getOriginalFilename()).replaceAll("[ :]", "-");
        photo.transferTo(new File(uploadDir + "/" + fileName));
        //base64
        byte[] fileContent = FileUtils.readFileToByteArray(new File(uploadDir + "/" + fileName));
        String encodedString = Base64.getEncoder().encodeToString(fileContent);
        //base64
        Post post = new Post(encodedString,label,idUser,0);
        postRepository.insert(post);
        return null;
    }

    @Override
    public List<Post> findPost(String idUser) {
        List<Post> postList = postRepository.findByIdUser(idUser);
        return postList;
    }

    @Override
    public List<PostDAO> findPostForDao(String email){
        User user = userRepository.findByEmail(email).get();
        List<Post> postList = postRepository.findByIdUser(user.getId());
        List<PostDAO> postDAOList = new ArrayList<>();
        for (Post post:postList) {
            postDAOList.add(new PostDAO(
                    post.getEncodedPhoto(),
                    post.getLabel()));
        }
        return postDAOList;
    }

    @Override
    public Post findPostByLabel(String label) {
        return postRepository.findByLabel(label);
    }

}
