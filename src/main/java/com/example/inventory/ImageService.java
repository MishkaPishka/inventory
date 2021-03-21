package com.example.inventory;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import java.util.Base64;
import javax.persistence.EntityNotFoundException;
import java.io.IOException;
import java.util.stream.Stream;
@Service
public class ImageService {

    @Autowired
    private ImageRepository imageRepository ;static String B64_DEFAULT_IMAGE = "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";
    public Image getImage(int id ) {
        return imageRepository.findById(id).orElseThrow(EntityNotFoundException::new);

}

    public Image getImageByItemID(int id) {

//        return imageRepository.getImageByItemID(  id );
        return imageRepository.getImageByItemID(  id );


    }
    public void addImage(Image image)
    {
        imageRepository.save(image);

    }

    public Stream<Image> getAllFiles() {
        return imageRepository.findAll().stream();
    }



    public void createNewImageFromMultipartFileAndItemIDAndSave(int itemID, MultipartFile imageFile) throws IOException {

        String fileType = imageFile.getContentType();
        byte [] data = imageFile.getBytes();
        String encodedString = Base64.getEncoder().encodeToString(imageFile.getBytes());
        System.out.println("encodedString:"+encodedString);

        Image im =  imageRepository.getImageByItemID(itemID);

        if (im==null) {
            im = new Image(fileType, encodedString, itemID);
        }
        else {
            im.setData(encodedString);
        }

        imageRepository.save(im);

    }
}
