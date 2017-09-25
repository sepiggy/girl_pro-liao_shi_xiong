package cn.sepiggy.imooc.service;

import cn.sepiggy.imooc.domain.Girl;
import cn.sepiggy.imooc.repository.GirlRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class GirlService {

    @Autowired
    private GirlRepository girlRepository;

    public List<Girl> findAll() {
        return girlRepository.findAll();
    }

    public List<Girl> findByAge(Integer age) {
        return girlRepository.findByAge(age);
    }

    public Girl findOne(Integer id) {
        return girlRepository.findOne(id);
    }

    public Girl add(Girl girl) {
        return girlRepository.save(girl);
    }

    @Transactional
    public void addTwo() {
        Girl girlA = new Girl();
        girlA.setCupSize("A");
        girlA.setAge(18);
        girlRepository.save(girlA);

        Girl girlB = new Girl();
        girlB.setCupSize("BBBBBBBBBBBBB");
        girlB.setAge(19);
        girlRepository.save(girlB);
    }

    public Girl update(Girl girl) {
        return girlRepository.save(girl);
    }

    public void delete(Integer id) {
        girlRepository.delete(id);
    }

}
