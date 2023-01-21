package com.RosGramm.server.service;

import com.RosGramm.server.model.Avatar;
import com.RosGramm.server.repository.AvatarRepository;
import com.RosGramm.server.user.User;
import com.RosGramm.server.user.UserRepository;
import lombok.AllArgsConstructor;
import org.apache.commons.io.FileUtils;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.Base64;
import java.util.UUID;

@AllArgsConstructor
@Service
public class AvatarServiceImpl implements AvatarService{

    private final AvatarRepository avatarRepository;
    private final String uploadPath = "C:\\Users\\vabob\\IdeaProjects\\ServerForRosGramm\\src\\main\\java\\com\\RosGramm\\server\\photos";
    private final UserRepository userRepository;


    @Override
    public String add(MultipartFile photo, String idUser) throws IOException {
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
        Avatar avatar = new Avatar(encodedString,idUser);
        avatarRepository.insert(avatar);
        return avatar.getId();
    }

    @Override
    public String findPhoto(String email) {
        User user = userRepository.findByEmail(email).get();
        return avatarRepository.findByIdUser(user.getId()).get().getEncodedPhoto();
    }

    @Override
    public Boolean checkUserAvatar(String idUser) {
        avatarRepository.deleteAllByIdUser(idUser);
        return true;
    }


}
