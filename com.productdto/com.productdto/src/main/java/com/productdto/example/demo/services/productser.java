package com.productdto.example.demo.services;

import com.productdto.example.demo.dto.productdto;
import com.productdto.example.demo.dto.productdto1;
import com.productdto.example.demo.entity.product;
import com.productdto.example.demo.repositiry.prorepo;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class productser {

    @Autowired
    private prorepo reposi;

    @Autowired
    private ModelMapper Mapper;

    public productdto select(int id){
        Optional pro2 = reposi.findById(id);
        if(pro2.isPresent())
        {
            product p2 = (product) pro2.get();
            return convertToDTO(p2);
        }
        return null;
    }

    public boolean insert(productdto1 p1){
        reposi.save(tdotoentity(p1));
        return true;
    }

    public boolean insertall(List<productdto1> p1){
        reposi.saveAll(p1.stream().map(e->tdotoentity(e)).toList());
        return true;
    }

    public List<productdto> selectall(){
        List<product> list1 = reposi.findAll();
        return list1.stream().map(e->convertToDTO(e)).collect(Collectors.toList());
    }

    public boolean updatedata(int id,productdto1 productdto1)
    {
        if(reposi.existsById(id)) {
            productdto1.setId(id);
            reposi.save(tdotoentity(productdto1));
            return true;
        }
        return false;
    }

    public boolean delete(int id){
        if(reposi.existsById(id)){
            reposi.deleteById(id);
            return true;
        }
        return false;
    }

    public boolean deleteall(){
        if(reposi.findAll()!=null) {
            reposi.deleteAll();
            return true;
        }
        return false;
    }



    public productdto convertToDTO(product pro1){
        return Mapper.map(pro1,productdto.class);
    }

    public product tdotoentity(productdto1 pro2){
        return Mapper.map(pro2,product.class);
    }

}
