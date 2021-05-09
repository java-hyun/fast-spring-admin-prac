package com.example.study.reposiotry;

import com.example.study.StudyApplicationTests;
import com.example.study.model.entity.Item;
import com.example.study.repository.ItemRepository;
import junit.framework.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

public class ItemRepositoryTest extends StudyApplicationTests {

    @Autowired
    private ItemRepository itemRepository;

    @Test
    public void create(){
        Item item = new Item();
        item.setName("맥북");
        item.setPrice(200000);
        item.setContent("애플 노트북");

        Item newItem = itemRepository.save(item);
        Assert.assertNotNull(newItem);

    }

    @Test
    public void read(){
        Long id = 1L;
        Optional<Item> item = itemRepository.findById(id);
        System.out.println("===================== test ===================================");

        item.ifPresent(i-> {
            System.out.println(i);
        });

        Assert.assertTrue(item.isPresent());
    }

}
