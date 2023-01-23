package com.RosGramm.server.service;


import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface AvatarService {

    String add(MultipartFile photo, String idUser) throws IOException;
    String findPhoto(String email);
    Boolean checkUserAvatar(String idUser); //исправлять
}
