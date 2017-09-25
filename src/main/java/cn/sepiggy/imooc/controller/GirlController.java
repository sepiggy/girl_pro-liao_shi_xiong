package cn.sepiggy.imooc.controller;

import cn.sepiggy.imooc.domain.Girl;
import cn.sepiggy.imooc.service.GirlService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class GirlController {

    @Autowired
    private GirlService girlService;

    /**
     * 查询所有女生列表
     *
     * @return the list
     */
    @GetMapping(value = "/girls")
    public List<Girl> girlList() {
        return girlService.findAll();
    }

    /**
     * 添加一个女生
     *
     * @param cupSize the cup size
     * @param age     the age
     * @return the girl
     */
    @PostMapping(value = "/girls")
    public Girl girlAdd(@RequestParam("cupSize") String cupSize,
                        @RequestParam("age") Integer age) {
        Girl girl = new Girl();
        girl.setCupSize(cupSize);
        girl.setAge(age);

        return girlService.add(girl);
    }

    /**
     * 查询一个女生
     *
     * @param id the id
     * @return the girl
     */
    @GetMapping(value = "/girls/{id}")
    public Girl girlFindOne(@PathVariable("id") Integer id) {
        return girlService.findOne(id);
    }

    /**
     * 更新一个女生
     *
     * @param id      the id
     * @param cupSize the cup size
     * @param age     the age
     * @return the girl
     */
    @PutMapping(value = "/girls/{id}")
    public Girl girlUpdate(@PathVariable("id") Integer id,
                           @RequestParam("cupSize") String cupSize,
                           @RequestParam("age") Integer age) {
        Girl girl = new Girl();
        girl.setId(id);
        girl.setCupSize(cupSize);
        girl.setAge(age);

        return girlService.update(girl);
    }

    /**
     * 删除一个女生
     *
     * @param id the id
     */
    @DeleteMapping(value = "/girls/{id}")
    public void girlDelete(@PathVariable("id") Integer id) {
        girlService.delete(id);
    }

    /**
     * 通过年龄查询女生列表
     *
     * @param age the age
     * @return the list
     */
    @GetMapping(value = "/girls/age/{age}")
    public List<Girl> girlListByAge(@PathVariable("age") Integer age) {
        List<Girl> girls = girlService.findByAge(age);
        return girls;
    }

    /**
     * 同时插入两个女生 ---> 演示 Spring Boot 的事务管理
     */
    @PostMapping(value = "/girls/two")
    public void girlTwo() {
        girlService.addTwo();
    }

}
