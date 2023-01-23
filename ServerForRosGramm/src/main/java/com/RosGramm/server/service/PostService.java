package com.RosGramm.server.service;

import com.RosGramm.server.DAO.PostDAO;
import com.RosGramm.server.model.Post;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public interface PostService {
    String add(MultipartFile photo, String label, String idUser, Integer counterLike) throws IOException;
    List<Post> findPost(String idUser);
    List<PostDAO> findPostForDao(String email);
    Post findPostByLabel(String label);
}
