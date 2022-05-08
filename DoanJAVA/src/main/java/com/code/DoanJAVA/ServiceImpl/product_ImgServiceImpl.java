package com.code.DoanJAVA.ServiceImpl;

import com.code.DoanJAVA.Entity.product_Img;
import com.code.DoanJAVA.Repository.product_ImgRepository;
import com.code.DoanJAVA.Service.product_ImgService;
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
    public List<String> getByProduct(String name) {
        List<product_Img> product_imgs =  product_imgRepository.findAll();
        List<String> result = new ArrayList<String>();
        for (product_Img img:product_imgs) {
            if(img.getProduct().getName().equals(name)) result.add(img.getImg());
        }
        return result;
    }


}
