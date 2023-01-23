package com.RosGramm.server.service;

import com.RosGramm.server.DAO.PostDAO;
import com.RosGramm.server.model.Post;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public interface PostService {
    String add(MultipartFile photo,String label, String idUser) throws IOException;
    List<Post> findPost(String email);
    List<PostDAO> findPostForDao(String email);
}
