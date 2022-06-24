package com.code.JavaProject.ServiceImpl;

import com.code.JavaProject.Entity.product_Img;
import com.code.JavaProject.Repository.product_ImgRepository;
import com.code.JavaProject.Service.product_ImgService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class product_ImgServiceImpl implements product_ImgService {

    @Autowired
    private product_ImgRepository product_imgRepository ;
    @Override
    public void save(product_Img product_img) {
        product_imgRepository.save(product_img);
    }
    @Override
    public List<product_Img> getByProduct(String name) {
        List<product_Img> product_imgs =  product_imgRepository.findAll();
        List<product_Img> result = new ArrayList<product_Img>();
        for (product_Img img:product_imgs) {
            if(img.getProduct().getName().equals(name)) result.add(img);
        }
        return result;
    }

    @Override
    public void delete(int id) {
        product_imgRepository.deleteById(id);
    }


}
